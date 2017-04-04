package bogenfxml;

import Model.Anmeldedaten;
import Queries.TeilnehmerQueries;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLDocumentController {

    @FXML
    private TableView<Anmeldedaten> tblTeilnehmer;
    @FXML
    private TableColumn<Anmeldedaten, String> colVorname;
    @FXML
    private TableColumn<Anmeldedaten, String> colNachname;
    @FXML
    private TableColumn<Anmeldedaten, String> colVerein;
    @FXML
    private Button speichern;
    @FXML
    private Label label;
    @FXML
    private TextField email;
    @FXML
    private TextField vorname;
    @FXML
    private TextField nachname;
    @FXML
    private TextField verein;
    @FXML
    private ComboBox klasse;
    @FXML
    private ToggleGroup geschlecht;
    @FXML
    private Button neu;
    @FXML
    private Button abbrechen;
    @FXML
    private TextField plz;
    @FXML
    private TextField ort;
    @FXML
    private ToggleGroup tage;
    
    // Referenz zum Main
    private BogenFxml bogenFxml;

    public FXMLDocumentController() {
    }

    @FXML
    private void initialize() throws SQLException {
        colVorname.setCellValueFactory(cellData -> cellData.getValue().vornameProperty());
        colNachname.setCellValueFactory(cellData -> cellData.getValue().nachnameProperty());
//        colVerein.setCellValueFactory(cellData -> cellData.getValue().vereinProperty());

        ObservableList<Anmeldedaten> daten = TeilnehmerQueries.getAnmeldedaten();
        tblTeilnehmer.setItems((ObservableList<Anmeldedaten>) daten);
        showTeilnehmerDetails(daten.get(0));

        tblTeilnehmer.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTeilnehmerDetails(newValue));

        addListener();
    }

    private void addListener() {
        vorname.focusedProperty().addListener((ObservableValue<? extends Boolean> arg0, 
                Boolean oldPropertyValue, Boolean newPropertyValue) -> {
            if (newPropertyValue) {
                System.out.println("Textfield on focus");
            } else {
                System.out.println("Textfield out focus");
            }
        });
        email.focusedProperty().addListener((ObservableValue<? extends Boolean> arg0, 
                Boolean oldPropertyValue, Boolean newPropertyValue) -> {
            if (newPropertyValue) {
                System.out.println("Textfield on focus");
            } else {
                System.out.println("Textfield out focus");
            }
        });

    }

    private boolean additionalChecks() {
        boolean result = false;
        String message;
        // Field validierungen mit bindings
        //hier https://gist.github.com/james-d/9904574
        
        
        // Ist Nachname ausgefüllt

        // Ist Vorname ausgefüllt
        // ist Klasse gewählt
        // Ist Ort gewählt
        // ISt Plz gewählt
        // Ist gebDatum ausgefüllt
        // Ist Geschlecht gewählt
        return result;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public void setBogenFxml(BogenFxml bogenFxml) {
        this.bogenFxml = bogenFxml;
        tblTeilnehmer.setItems(null);
    }

    private void showTeilnehmerDetails(Anmeldedaten ad) {
        if (ad != null) {
            vorname.setText(ad.getVorname());
            nachname.setText(ad.getNachname());
//            plz.setText(String.valueOf(ad.getPlz()));
//            ort.setText(ad.getOrt());
//            verein.setText(ad.getVerein());
            email.setText(ad.getEmail());
            klasse.getSelectionModel().select(ad.getKlasse());
        } else {
            vorname.setText("");
            nachname.setText("");
            plz.setText("");
            ort.setText("");
            verein.setText("");
            email.setText("");
            klasse.getSelectionModel().select(0);
        }
    }

    @FXML
    void handleAbbrechenAction(ActionEvent event) {
    }

    @FXML
    void handleNeuAction(ActionEvent event) {
    }

    @FXML
    void handleSpeichernAction(ActionEvent event) {
    }

    public Button getSpeichern() {
        return speichern;
    }

    public void setSpeichern(Button speichern) {
        this.speichern = speichern;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public TextField getVorname() {
        return vorname;
    }

    public void setVorname(TextField vorname) {
        this.vorname = vorname;
    }

    public TextField getNachname() {
        return nachname;
    }

    public void setNachname(TextField nachname) {
        this.nachname = nachname;
    }

    public TextField getVerein() {
        return verein;
    }

    public void setVerein(TextField verein) {
        this.verein = verein;
    }

//    public Label getKlasse() {
//        return klasse;
//    }
//
//    public void setKlasse(Label klasse) {
//        this.klasse = klasse;
//    }
    public ToggleGroup getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(ToggleGroup geschlecht) {
        this.geschlecht = geschlecht;
    }

    public Button getNeu() {
        return neu;
    }

    public void setNeu(Button neu) {
        this.neu = neu;
    }

    public Button getAbbrechen() {
        return abbrechen;
    }

    public void setAbbrechen(Button abbrechen) {
        this.abbrechen = abbrechen;
    }

    public TextField getPlz() {
        return plz;
    }

    public void setPlz(TextField plz) {
        this.plz = plz;
    }

    public TextField getOrt() {
        return ort;
    }

    public void setOrt(TextField ort) {
        this.ort = ort;
    }

    public ToggleGroup getTage() {
        return tage;
    }

    public void setTage(ToggleGroup tage) {
        this.tage = tage;
    }
}
