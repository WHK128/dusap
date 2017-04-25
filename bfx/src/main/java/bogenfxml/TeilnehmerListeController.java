/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bogenfxml;

import Datenklassen.Score;
import Model.Anmeldedaten;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private TableColumn<Anmeldedaten, Integer> colScoreTag1;
    @FXML
    private TableColumn<Anmeldedaten, Integer> colScoreTag2;

    ObservableList<Anmeldedaten> turnierAnmeldungen;
    private Boolean score;

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

    /**
     *
     * @param score score ist der Parameter für die Score Spalten, ob sie
     * angezeigt werden oder nicht
     *
     */
    void initTable(Boolean score) {
        this.score = score;
        colVorname.setCellValueFactory(cellData -> cellData.getValue().vornameProperty());
        colNachname.setCellValueFactory(cellData -> cellData.getValue().nachnameProperty());
        colKlasse.setCellValueFactory(cellData -> cellData.getValue().klasseProperty().asObject());
        colGeschlecht.setCellValueFactory(cellData -> cellData.getValue().geschlechtProperty().asObject());
        colTage.setCellValueFactory(cellData -> cellData.getValue().tageProperty().asObject());

        colScoreTag1.setVisible(false);
        colScoreTag2.setVisible(false);

        if (score) {
            colScoreTag1.setVisible(true);
            colScoreTag2.setVisible(true);
            colScoreTag1.setCellValueFactory(cellData -> cellData.getValue().scoreTag1Property().asObject());
            colScoreTag2.setCellValueFactory(cellData -> cellData.getValue().scoreTag2Property().asObject());

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
            Callback<TableColumn<Anmeldedaten, Integer>, TableCell<Anmeldedaten, Integer>> cellFactory
                    = (TableColumn<Anmeldedaten, Integer> param) -> new EditingCell();

            colScoreTag1.setCellFactory(cellFactory);
            colScoreTag1.setOnEditCommit(
                    (TableColumn.CellEditEvent<Anmeldedaten, Integer> t) -> {
                        ((Anmeldedaten) t.getTableView().getItems()
                                .get(t.getTablePosition().getRow()))
                                .setScoreTag1(t.getNewValue());
                    });
            colScoreTag2.setCellFactory(cellFactory);
            colScoreTag2.setOnEditCommit(
                    (TableColumn.CellEditEvent<Anmeldedaten, Integer> t) -> {
                        ((Anmeldedaten) t.getTableView().getItems()
                                .get(t.getTablePosition().getRow()))
                                .setScoreTag1(t.getNewValue());
                    });

//        colScoreTag1.setCellFactory((TableColumn<Anmeldedaten, Integer> param) -> {
//            TableCell<Anmeldedaten, Integer> cell;
//            cell = new TableCell<Anmeldedaten, Integer>() {
//                TextField tf = new TextField();
//
//                @Override
//                public void updateItem(Integer item, boolean empty) {
//                    tf.setPromptText("Score");
//                    tf.setAlignment(Pos.CENTER_RIGHT);
//                    if(!empty){
//                    this.setGraphic(tf);}
//                    if (item != null) {
//                        
//                        setText(null);
//                    }
//                    tf.focusedProperty().addListener((ObservableValue<? extends Boolean> observable,
//                        Boolean oldValue, Boolean newValue) -> {
//                    if (!newValue) {
//                        String s = String.valueOf(item);
//                        if (s.matches("[0-9]*")) {
//                            tf.setText(s);
//                        }
//                    }
//                });
//                }
//            };
//            return cell;
//        });
        }
        turnierAnmeldungen = FXCollections.observableArrayList();
        turnierAnmeldungen = mn.getMd().getTurnierTeilnahmeListe();
        fillTable("");
    }

    private void fillTable(String suche) {
        FilteredList<Anmeldedaten> fl;
        if (score) {
            fl = turnierAnmeldungen.filtered(row -> row.getNachname().toLowerCase().contains(suche.toLowerCase())
                    || row.getVorname().toLowerCase().contains(suche.toLowerCase()));
        } else {
            fl = turnierAnmeldungen.filtered(row
                    -> row.getNachname().toLowerCase().contains(suche.toLowerCase())
                    || row.getVorname().toLowerCase().contains(suche.toLowerCase()));
        }
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
tblTeilnehmerListe.setOnKeyPressed(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER)  {
            Anmeldedaten row = (Anmeldedaten) tblTeilnehmerListe.getSelectionModel().getSelectedItem();
//            int FKTeilnhemer, int FKVeranstaltung, int tage,
//            int punkteTag1, int col10erTag1, int col8erTag1, int col5erTag1,
//            int punkteTag2, int col10erTag2, int col8erTag2, int col5erTag2
//           Score score = new Score(row.getIdTeilnehmer(), , , row., 0, 0, 0, 0, 0, 0, 0)
        }
    }
});
    }
    private String jahrZahl = "";

    class EditingCell extends TableCell<Anmeldedaten, Integer> {

        private TextField textField;

        private EditingCell() {
            textField = new TextField("");
            textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue) {
                    if (textField.getText().matches("[0-9]{4}")) {
                        jahrZahl = textField.getText();
                        // ins Objekt zurückschreiben
//                        currentRow.getItem().setFabJahr(textField.getText());
                    } else {
//                        AlertHelper.startInfoAlert("FAB", "FAB 8-jährig gebundene Beträge", "Sie müssen eine 4-stellige Jaheszahl eingeben.");
                        textField.requestFocus();
                    }
                }
            });
        }
//        @Override
//        public void startEdit() {
//            if (!isEmpty()) {
//                super.startEdit();
//                createTextField();
//                setText(null);
//                setGraphic(textField);
//                textField.selectAll();
//                textField.setPromptText("Score");
//                textField.setAlignment(Pos.CENTER_RIGHT);
//            }
//        }

//        @Override
//        public void cancelEdit() {
//            super.cancelEdit();
//
//            setText(validDigit(String.valueOf(getItem())));
//            setGraphic(null);
//        }
// @Override
//                public void updateItem(Integer item, boolean empty) {
//                    tf.setPromptText("Score");
//                    tf.setAlignment(Pos.CENTER_RIGHT);
//                    if(!empty){
//                    this.setGraphic(tf);}
//                    if (item != null) {
//                        
//                        setText(null);
//                    }
//                    tf.focusedProperty().addListener((ObservableValue<? extends Boolean> observable,
//                        Boolean oldValue, Boolean newValue) -> {
//                    if (!newValue) {
//                        String s = String.valueOf(item);
//                        if (s.matches("[0-9]*")) {
//                            tf.setText(s);
//                        }
//                    }
//                });
        @Override
        public void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);
            createTextField();
            if (!empty) {
//                setText(String.valueOf(item));
//                setGraphic(null);
//            } else {
//                if (isEditing()) {
//                if (textField != null) {
//                    textField.setText(validDigit(getString()));
////                        setGraphic(null);
//                }
                setText(null);
                setGraphic(textField);
//                } else {
//                    setText(getString());
//                    setGraphic(null);
//                }
            }

//            textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable,
//                    Boolean oldValue, Boolean newValue) -> {
//                        if (!newValue) {
//                            String s = String.valueOf(item);
//                            if (s.matches("[0-9]*")) {
//                                textField.setText(s);
//                            }
//                        }
//                    });
        }

        private void createTextField() {
            textField = new TextField();
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
//            textField.setOnAction((e) -> commitEdit(Integer.valueOf(textField.getText())));
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.equals("")) {
                    textField.setText(validDigit(textField.getText()));
                }
            });
        }

        private String validDigit(String s) {
            if (s.matches("[0-9]*")) {
                return s;
            }
            return "";
        }

        private String getString() {
            return getItem() == null ? "" : String.valueOf(getItem());
        }
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
