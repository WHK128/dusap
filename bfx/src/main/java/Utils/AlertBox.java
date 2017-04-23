/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javafx.scene.control.Alert;

/**
 *
 * @author Werner
 */
public class AlertBox extends Alert {

    Alert alert = new Alert(AlertType.ERROR);

    public AlertBox(AlertType alertType, String titel, String header, String content) {
        super(alertType);

        alert.setTitle(titel);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
