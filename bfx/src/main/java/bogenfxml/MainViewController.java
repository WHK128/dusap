/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bogenfxml;

import Datenklassen.MainData;
import Model.MainModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Werner
 */
public class MainViewController implements Initializable {

    @FXML
    private BorderPane mainPain;
    @FXML
    private HBox centerHBox;
    @FXML
    private Button btnAnmeldung;
    @FXML
    private Button btnScoreeingabe;
    @FXML
    private Button btnAuswertung;
    @FXML
    private Button btnTeilnehmerliste;
    @FXML
    private Button btnTurnierAnlegen;

    EditViewController editViewController;
    TableViewController tableViewController;
    TeilnehmerListeController teilnehmerListeController;
    ScoreEingabeController scoreEingabeController;
    Parent listView;
    Parent teilnehmerList;
    Parent scoreEingabe;
    MainData md;
    MainModel mm;
    private VeranstaltungController veranstaltungController;
    private Parent veranstaltungAnlegen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        md = new MainData();
        mm = new MainModel(md);

        // TODO
    }

    @FXML
    void handleAnmeldungAction(ActionEvent event) {
        centerHBox.getChildren().clear();
        mainPain.setRight(null);
        loadAnmeldeView();
        loadListView();
        loadTeilnehmerListView();
        Platform.runLater(() -> {
            setAnmeldeView();
            setListView();
            setTeilnehmerListView(false);
        });
    }

    @FXML
    void handleScoreeingabeAction(ActionEvent event) {
        centerHBox.getChildren().clear();
        mainPain.setRight(null);
        loadTeilnehmerListView();
        loadScoreEingabeView();
        Platform.runLater(() -> {
            setTeilnehmerListView(true);
            setScoreEingabeView();
        });
    }

    @FXML
    void handleAuswertungAction(ActionEvent event) {
    }

    @FXML
    void handleTeilnehmerlisteAction(ActionEvent event) {
    }

    @FXML
    void handleTurnierAnlegenAction(ActionEvent event) {
        centerHBox.getChildren().clear();
        mainPain.setRight(null);
        loadVeranstaltungAnlegenView();
        Platform.runLater(() -> {
            setVeranstaltungAnlegenView();
        });
    }

    private void loadAnmeldeView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EditView.fxml"));
            Parent root = (Parent) loader.load();
            editViewController = loader.getController();
            mainPain.setRight(root);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setAnmeldeView() {
        editViewController.setMainView(this);
        editViewController.init(md);
    }

    private void loadListView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TableView.fxml"));
            listView = (Parent) loader.load();
            tableViewController = loader.getController();
            centerHBox.getChildren().add(listView);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setListView() {
        tableViewController.setMainView(this);
        tableViewController.initTable(md);
    }

    private void loadTeilnehmerListView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TeilnehmerListe.fxml"));
            teilnehmerList = (Parent) loader.load();
            teilnehmerListeController = loader.getController();
            centerHBox.getChildren().add(teilnehmerList);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setTeilnehmerListView(boolean score) {
        teilnehmerListeController.setMainView(this);
        teilnehmerListeController.initTable(score);
    }

    private void loadScoreEingabeView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ScoreEingabe.fxml"));
            scoreEingabe = (Parent) loader.load();
            scoreEingabeController = loader.getController();
            centerHBox.getChildren().add(scoreEingabe);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setScoreEingabeView() {
        scoreEingabeController.setMainView(this);
        scoreEingabeController.init(md);
    }

    private void loadVeranstaltungAnlegenView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Veranstaltung.fxml"));
            veranstaltungAnlegen = (Parent) loader.load();
            veranstaltungController = loader.getController();
            centerHBox.getChildren().add(veranstaltungAnlegen);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setVeranstaltungAnlegenView() {
        veranstaltungController.setMainView(this);
        veranstaltungController.init(md);
    }

    public EditViewController getEditViewController() {
        return editViewController;
    }

    public TableViewController getTableViewController() {
        return tableViewController;
    }

    public TeilnehmerListeController getTeilnehmerListeController() {
        return teilnehmerListeController;
    }

    public MainData getMd() {
        return md;
    }

    public MainModel getMm() {
        return mm;
    }

}
