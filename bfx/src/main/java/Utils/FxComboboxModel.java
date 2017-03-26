/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javafx.scene.control.ComboBox;

/**
 *
 * @author Werner
 */
public class FxComboboxModel {

    private ComboBox cb;

    public FxComboboxModel(ComboBox cb) {
        this.cb = cb;
        installCustomListener();
    }

    public FxComboboxModel(ComboBox cb, boolean contains) {
        this.cb = cb;
        installCustomListener(contains);
    }

    private void installCustomListener() {
        new SelectKeyComboBoxListener(cb, false);
    }

    private void installCustomListener(boolean contains) {
        new SelectKeyComboBoxListener(cb, contains);
    }
}
