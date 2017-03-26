/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Datenklassen.MainData;
import Datenklassen.Ort;
import Queries.OrtQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Werner
 */
public class PostleitzahlModel extends FxComboboxModel {

    MainData md;
    private final ComboBox<Ort> fxPlz;
    private ObservableList plzList = null;

    public PostleitzahlModel(ComboBox fxPlz, MainData md) {
        super(fxPlz, true);
        this.md = md;
        this.fxPlz = fxPlz;
        init();
    }

    private void init() {
        try {
            plzList = FXCollections.observableArrayList();
            plzList = md.getPlzList();
            plzList.add(0, "Postleitzahl bitte auswählen");
            fxPlz.setItems(plzList);
            fxPlz.getSelectionModel().select(0);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }

    public void setSelected(Object plz) {
        if (plz instanceof String) {
            fxPlz.getSelectionModel().select(md.getPlzList().filtered(o -> o.getPlz().equals(plz)).get(0));
        }
    }

    public boolean isPlzValid(String plz) {
        boolean result = false;
        try {
            result = OrtQueries.isPlzValid(plz);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public ComboBox<Ort> getFxPlz() {
        return fxPlz;
    }

    public String getSelectedOrt() {
        Object o = fxPlz.getSelectionModel().getSelectedItem();
        if (o != null && o instanceof Ort) {
            return ((Ort) o).getOrt();
        }
        return "";
    }

    public String getSelectedPlz() {
        Object o = fxPlz.getSelectionModel().getSelectedItem();
        if (o != null && o instanceof Ort) {
            return ((Ort) o).getPlz();
        }
        return "";
    }

    public String getSelectedIdOrt() {
        Object o = fxPlz.getSelectionModel().getSelectedItem();
        if (o != null && o instanceof Ort) {
            return ((Ort) o).getIDOrt();
        }
        return "";
    }
}
