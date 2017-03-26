/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bogenfxml;

import Model.Anmeldedaten;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Werner
 */
public class TeilnehmerListeController implements Initializable {

    MainViewController mn;
    @FXML
    private HBox topPaneTeilnehmerliste;
    @FXML
    private BorderPane teilnehmerListePane;
    @FXML
    private TextField suchFeld;
    @FXML
    private TableView tblTeilnehmerListe;
    @FXML
    private TableColumn<Anmeldedaten, String> colVorname;
    @FXML
    private TableColumn<Anmeldedaten, String> colNachname;
    @FXML
    private TableColumn<Anmeldedaten, Integer> colKlasse;
    @FXML
    private TableColumn<Anmeldedaten, Integer> colGeschlecht;
    @FXML
    private TableColumn<Anmeldedaten, Integer> colTage;

    ObservableList<Anmeldedaten> turnierAnmeldungen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addListener();
    }

    void setMainView(MainViewController mn) {
        this.mn = mn;
    }

    void initTable() {
        colVorname.setCellValueFactory(cellData -> cellData.getValue().vornameProperty());
        colNachname.setCellValueFactory(cellData -> cellData.getValue().nachnameProperty());
        colKlasse.setCellValueFactory(cellData -> cellData.getValue().klasseProperty().asObject());
        colGeschlecht.setCellValueFactory(cellData -> cellData.getValue().geschlechtProperty().asObject());
        colTage.setCellValueFactory(cellData -> cellData.getValue().tageProperty().asObject());

        colKlasse.setCellFactory((TableColumn<Anmeldedaten, Integer> param) -> {
            TableCell<Anmeldedaten, Integer> cell = new TableCell<Anmeldedaten, Integer>() {
                @Override
                public void updateItem(Integer item, boolean empty) {
                    if (item != null) {
                        setText(mn.getMd().getKlasse(item));
                    }
                }
            };
            return cell;
        });
        colGeschlecht.setCellFactory((TableColumn<Anmeldedaten, Integer> param) -> {
            TableCell<Anmeldedaten, Integer> cell = new TableCell<Anmeldedaten, Integer>() {
                @Override
                public void updateItem(Integer item, boolean empty) {
                    if (item != null) {
                        setText(mn.getMd().getGeschlecht(item));
                    }
                }
            };
            return cell;
        });
        turnierAnmeldungen = FXCollections.observableArrayList();
        fillTable("");
    }

    private void fillTable(String suche) {
        FilteredList<Anmeldedaten> fl = turnierAnmeldungen.filtered(row
                -> row.getNachname().toLowerCase().contains(suche.toLowerCase())
                || row.getVorname().toLowerCase().contains(suche.toLowerCase()));
        tblTeilnehmerListe.setItems(fl);
    }

    void addListener() {
        // Suchfeld Suche bei der Eingabe
        suchFeld.textProperty().addListener((ObservableValue<? extends String> observable,
                String oldValue, String newValue) -> {
                    fillTable(suchFeld.getText());
                });
        // SingleClick
        tblTeilnehmerListe.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> mn.getEditViewController().showTeilnehmerDetails((Anmeldedaten) newValue));
//                        // Doppelklick
//        tblTeilnehmerListe.setOnMouseClicked((MouseEvent event) -> {
//            if (event.getClickCount() == 2) { // double click
//                Anmeldedaten selected = (Anmeldedaten) tblTeilnehmerListe.getSelectionModel().getSelectedItem();
//                if (selected != null) {
//                    mn.getEditViewController().showTeilnehmerDetails(selected);
//                }
//            }
//        });
    }

    public TextField getSuchFeld() {
        return suchFeld;
    }

    public TableView getTblTeilnehmerListe() {
        return tblTeilnehmerListe;
    }

    public ObservableList<Anmeldedaten> getTurnierAnmeldungen() {
        return turnierAnmeldungen;
    }

}
