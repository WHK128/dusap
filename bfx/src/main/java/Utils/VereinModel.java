/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Datenklassen.MainData;
import Datenklassen.Verein;
import Queries.VereinQueries;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Werner
 */
public class VereinModel extends FxComboboxModel {

    private final ComboBox<Verein> fxCbVerein;
    private ObservableList vereinList = null;
    private final MainData md;

    public VereinModel(ComboBox fxCbVerein, MainData md) {
        super(fxCbVerein, true);
        this.md = md;
        this.fxCbVerein = fxCbVerein;
        init();
    }

    private void init() {
        try {
            vereinList = FXCollections.observableArrayList();
            vereinList = md.getVereineList();
            vereinList.add(0, new Verein(0, "Verein bitte auswählen", 0));
            fxCbVerein.setItems(vereinList);
            fxCbVerein.getSelectionModel().select(0);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }

    public void setSelected(Object verein) {
        if (verein instanceof Integer) {
            FilteredList<Verein> fl = md.getVereineList().filtered(o -> o.getIDVerein().equals(verein));
            if (fl.size() > 0) {
                fxCbVerein.getSelectionModel().select(fl.get(0));
            }
        }      
    }


public ComboBox<Verein> getCbVerein() {
        return fxCbVerein;
    }

    public String getSelectedVerein() {
        Object o = fxCbVerein.getSelectionModel().getSelectedItem();
        if (o != null && o instanceof Verein) {
            return ((Verein) o).getVerein();
        }
        return "";
    }

    public Integer getSelectedIdVerein() {
        Object o = fxCbVerein.getSelectionModel().getSelectedItem();
        if (o != null && o instanceof Verein) {
            return ((Verein) o).getIDVerein();
        }
        return 0;
    }
}
