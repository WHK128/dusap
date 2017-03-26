/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Datenklassen.Klasse;
import Datenklassen.MainData;
import Queries.KlasseQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Werner
 */
public class KlasseModel extends FxComboboxModel {

    private final ComboBox<Klasse> fxKlasse;
    private ObservableList klasseList = null;
    private final MainData md;

    public KlasseModel(ComboBox fxKlasse, MainData md) {
        super(fxKlasse, true);
        this.md = md;
        this.fxKlasse = fxKlasse;
        init();
    }

    private void init() {
        try {
            klasseList = FXCollections.observableArrayList();
            klasseList = md.getKlassenListe();
            klasseList.add(new Klasse(0, "Klasse bitte auswählen"));
            fxKlasse.setItems(klasseList);
            fxKlasse.getSelectionModel().select(0);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }

    public void setSelected(Object klasse) {
        if (klasse instanceof Integer) {
            fxKlasse.getSelectionModel().select(md.getKlassenListe().filtered(o->o.getIDKlasse().equals(klasse)).get(0));
        }
    }

    public ComboBox<Klasse> getCbKlasse() {
        return fxKlasse;
    }

    public String getSelectedKlasse() {
        Object o = fxKlasse.getSelectionModel().getSelectedItem();
        if (o != null && o instanceof Klasse) {
            return ((Klasse) o).getKlasse();
        }
        return "";
    }

    public int getSelectedIdKlasse() {
        Object o = fxKlasse.getSelectionModel().getSelectedItem();
        if (o != null && o instanceof Klasse) {
            return ((Klasse) o).getIDKlasse();
        }
        return 0;
    }
}
