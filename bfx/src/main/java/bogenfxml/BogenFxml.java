/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bogenfxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Werner
 */
public class BogenFxml extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));    
        Parent root = (Parent) loader.load();
        MainViewController controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/bow.png"));
        stage.setTitle("Das Ultimative Super Auswertungsprogramm - DUSAP");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
