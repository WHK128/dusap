/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bogenfxml;

import Datenklassen.MainData;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Werner
 */
public class VeranstaltungController implements Initializable {

    private MainData md;
    MainViewController mainView;

    @FXML
    private BorderPane VeranstaltungPane;
    @FXML
    private TextField txtTurnierName;
    @FXML
    private DatePicker dpTurnierDatum;
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSpeichern;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initFields();
    }

    private void initFields() {
        dpTurnierDatum.setValue(LocalDate.now());
        txtTurnierName.requestFocus();
    }

    @FXML
    void cancelHandler(ActionEvent event) {

    }

    @FXML
    void speichernHandler(ActionEvent event) {
        mainView.getMm().saveNeueVeranstaltung(txtTurnierName.getText().trim(), dpTurnierDatum.getValue());
    }

    void setMainView(MainViewController mainView) {
        this.mainView = mainView;
    }

    void init(MainData md) {
        this.md = md;
    }

}
