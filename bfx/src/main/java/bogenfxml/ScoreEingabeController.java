/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bogenfxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import Datenklassen.MainData;
import Model.Anmeldedaten;
import Utils.KlasseModel;
import Utils.PostleitzahlModel;
import Utils.VereinModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Werner
 */
public class ScoreEingabeController implements Initializable {

    private MainData md;
    MainViewController mainView;
    
    @FXML
    private HBox topPaneScoreEingabe;
    @FXML
    private TextField txtVorname;
    @FXML
    private TextField txtNachname;
      @FXML
    private ComboBox cbVerein;
    private VereinModel vereinModel;
    @FXML
    private TextField email;
    @FXML
    private ComboBox cbPlzOrt;
    private PostleitzahlModel plzModel;
    @FXML
    private ComboBox cbKlasse;
    private KlasseModel klasseModel;
    @FXML
    private RadioButton rdbEinTag;
    @FXML
    private ToggleGroup tage;
    @FXML
    private RadioButton rdbZweiTage;
    @FXML
    private RadioButton rdbKind;
    @FXML
    private ToggleGroup geschlecht;
    @FXML
    private RadioButton rdbJugend;
    @FXML
    private RadioButton rdbFrau;
    @FXML
    private RadioButton rdbMann;
    @FXML
    private Button btnSpeichern;
    @FXML
    private Button btnAbbrechen;
    @FXML
    private Button btnNeu;
    @FXML
    private TextField tag1Score;
    @FXML
    private TextField tag2Score;
    @FXML
    private TextField tag1_10er;
    @FXML
    private TextField tag2_10er;
    @FXML
    private TextField tag1_8er;
    @FXML
    private TextField tag2_8er;
    @FXML
    private TextField tag1_5er;
    @FXML
    private TextField tag2_5er;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   void init(MainData md) {
        this.md = md;
        initFields();
//        fillKlassen();
    }

    void initFields() {
        plzModel = new PostleitzahlModel(cbPlzOrt, md);
        klasseModel = new KlasseModel(cbKlasse, md);
        vereinModel = new VereinModel(cbVerein, md);
        
    }
//    private void fillKlassen() {
//        cbKlasse.setItems(md.getKlassenListe());
//    }

    public void showTeilnehmerDetails(Anmeldedaten ad) {
        if (ad != null) {
            txtVorname.setText(ad.getVorname());
            txtNachname.setText(ad.getNachname());
            plzModel.setSelected(ad.getPlz());
            klasseModel.setSelected(ad.getKlasse());
            vereinModel.setSelected(ad.getVerein());
//            cbPlzOrt.getSelectionModel().select(ad.getPlz());
//            cbVerein.getSelectionModel().select(ad.getKlasse());
            email.setText(ad.getEmail());
            setRbGeschlecht(ad.getGeschlecht());
//            cbKlasse.getSelectionModel().select(ad.getKlasse());
        } else {
            txtVorname.setText("");
            txtNachname.setText("");
            cbPlzOrt.getSelectionModel().select(0);
            cbVerein.getSelectionModel().select(0);
            email.setText("");
            cbKlasse.getSelectionModel().select(0);
        }
    }

    private void setRbGeschlecht(int idGeschlecht) {
        switch (idGeschlecht) {
            case 1:
                rdbMann.setSelected(true);
                break;
            case 2:
                rdbFrau.setSelected(true);
                break;
            case 3:
                rdbKind.setSelected(true);
                break;
            case 4:
                rdbJugend.setSelected(true);
                break;
            default:
                rdbMann.setSelected(true);
        }
    }

    void setMainView(MainViewController mainView) {
        this.mainView = mainView;
    }
}
