/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bogenfxml;

import Datenklassen.MainData;
import Model.Anmeldedaten;
import Queries.TeilnehmerQueries;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Werner
 */
public class TableViewController implements Initializable {

    MainViewController mainView;
    MainData md;

    @FXML
    private HBox topPaneTableView;
    @FXML
    private TextField suchfeld;
    @FXML
    private Button btnSuche;
    @FXML
    private TableView<Anmeldedaten> tblTeilnehmer;
    @FXML
    private TableColumn<Anmeldedaten, String> colVorname;
    @FXML
    private TableColumn<Anmeldedaten, String> colNachname;
    @FXML
    private TableColumn<Anmeldedaten, String> colVerein;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void initTable(MainData md) {
        this.md = md;
        colVorname.setCellValueFactory(cellData -> cellData.getValue().vornameProperty());
        colNachname.setCellValueFactory(cellData -> cellData.getValue().nachnameProperty());
//        colVerein.setCellValueFactory(cellData -> cellData.getValue().vereinProperty());
        fillTable("");
        addListener();
    }

    private void fillTable(String suche) {
        ObservableList<Anmeldedaten> daten = md.getAnmeldeDatenListe();
        daten = daten.filtered(row
                -> row.getNachname().toLowerCase().contains(suche.toLowerCase())
                || row.getVorname().toLowerCase().contains(suche.toLowerCase()));
        tblTeilnehmer.setItems(daten);

//        mainView.getEditViewController().showTeilnehmerDetails(daten.get(0));
    }

    @FXML
    void handleSuchenAction(ActionEvent event) {
        fillTable(suchfeld.getText());
    }

    void addListener() {
        // Suchfeld Suche bei der Eingabe
        suchfeld.textProperty().addListener((ObservableValue<? extends String> observable,
                String oldValue, String newValue) -> {
            fillTable(suchfeld.getText());
        });

        // SingleClick
        tblTeilnehmer.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> mainView.getEditViewController().showTeilnehmerDetails(newValue));

        // DoppelKlick
        tblTeilnehmer.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) { // double click

                Anmeldedaten selected = (Anmeldedaten) tblTeilnehmer.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    mainView.getEditViewController().showTeilnehmerDetails(selected);
                    if (!mainView.getTeilnehmerListeController().getTblTeilnehmerListe().getItems().contains(selected)) {
                        mainView.getTeilnehmerListeController().getTurnierAnmeldungen().add(selected);
                    }
                }
            }
        });

        tblTeilnehmer.setOnDragDetected((MouseEvent event) -> {
            // drag was detected, start drag-and-drop gesture
            Anmeldedaten selected = (Anmeldedaten) tblTeilnehmer.getSelectionModel().getSelectedItem();
            if (selected != null) {

                Dragboard db = tblTeilnehmer.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putString(selected.toString());
                db.setContent(content);
                event.consume();
            }
        });

        tblTeilnehmer.setOnDragOver((DragEvent event) -> {
            // data is dragged over the target
            Dragboard db = event.getDragboard();
            if (event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        tblTeilnehmer.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (event.getDragboard().hasString()) {

                Anmeldedaten item = new Anmeldedaten(db.getString());
                mainView.getTeilnehmerListeController().getTblTeilnehmerListe().getItems().add(item);
//                tblTeilnehmer.setItems(turnierAnmeldungen);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }

    void setMainView(MainViewController mainView) {
        this.mainView = mainView;
    }

}
