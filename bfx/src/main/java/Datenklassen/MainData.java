/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenklassen;

import Model.Anmeldedaten;
import Queries.VeranstaltungenQueries;
import java.sql.SQLException;
import java.util.HashMap;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author Werner
 */
public class MainData {

    ObservableList<Klasse> klassenListe;
    ObservableList<Anmeldedaten> anmeldeDatenListe;
    ObservableList<Geschlecht> geschlechtList;
    ObservableList<Ort> plzList;
    ObservableList<Verein> vereineList;
    Veranstaltung aktuelleVeranstaltung;

    public ObservableList<Verein> getVereineList() {
        return vereineList;
    }

    public void setVereineList(ObservableList<Verein> vereineList) {
        this.vereineList = vereineList;
    }

    public ObservableList<Ort> getPlzList() {
        return plzList;
    }

    public void setPlzList(ObservableList<Ort> plzList) {
        this.plzList = plzList;
    }

    public ObservableList<Klasse> getKlassenListe() {
        return klassenListe;
    }

    public void setKlassenListe(ObservableList<Klasse> klassenListe) {
        this.klassenListe = klassenListe;
    }

    public ObservableList<Anmeldedaten> getAnmeldeDatenListe() {
        return anmeldeDatenListe;
    }

    public void setAnmeldeDatenListe(ObservableList<Anmeldedaten> anmeldeDatenListe) {
        this.anmeldeDatenListe = anmeldeDatenListe;
    }

    public ObservableList<Geschlecht> getGeschlechtList() {
        return geschlechtList;
    }

    public void setGeschlechtList(ObservableList<Geschlecht> geschlechtList) {
        this.geschlechtList = geschlechtList;
    }

    public String getKlasse(Integer id) {
        if (id > 0) {
            FilteredList<Klasse> kl = getKlassenListe().filtered(o
                    -> o.getIDKlasse().equals(id)
            );
            return kl.size() > 0 ? kl.get(0).getKlasse() : "";
        }
        return "";
    }

    public String getGeschlecht(Integer id) {
        FilteredList<Geschlecht> kl = getGeschlechtList().filtered(o
                -> o.getIDGeschlecht() == id
        );
        return kl.size() > 0 ? kl.get(0).getGeschlecht() : "";
    }

    public Veranstaltung getAktuelleVeranstaltung() {

        return aktuelleVeranstaltung;
    }

    public void setAktuelleVeranstaltung(Veranstaltung aktuelleVeranstaltung) {
        this.aktuelleVeranstaltung = aktuelleVeranstaltung;
    }

}
