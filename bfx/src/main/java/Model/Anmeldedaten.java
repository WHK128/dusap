/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Werner
 */
public class Anmeldedaten {

    int idTeilnehmer;
    private StringProperty vorname;
    private StringProperty nachname;
    private int plz;
    private StringProperty email;
    private ObjectProperty<Date> gebDatum;
    private SimpleIntegerProperty geschlecht;
    private SimpleIntegerProperty klasse;
//    private int geschlecht;
//    private int klasse;
    private int verein;
    private SimpleIntegerProperty tage;

    public Anmeldedaten(String s) {
        String[] array = s.split("\\;", -1);
        idTeilnehmer = Integer.valueOf(array[0]);
        vorname = new SimpleStringProperty(array[1]);
        nachname = new SimpleStringProperty(array[2]);
        plz = Integer.valueOf(array[3]);
        email = new SimpleStringProperty(array[4]);
        gebDatum = new SimpleObjectProperty(array[5]);
        geschlecht = new SimpleIntegerProperty(Integer.valueOf(array[6]));
        klasse = new SimpleIntegerProperty(Integer.valueOf(array[7]));
        verein = Integer.valueOf(array[8]);
        tage = new SimpleIntegerProperty(Integer.valueOf(array[9]));
    }

    public Anmeldedaten(
            int idTeilnehmer,
            String vorname,
            String nachname,
            int plz,
            String email,
            Date gebDatum,
            int geschlecht,
            int klasse,
            int verein,
            int tage) {
        this.idTeilnehmer = idTeilnehmer;
        this.vorname = new SimpleStringProperty(vorname);
        this.nachname = new SimpleStringProperty(nachname);
        this.plz = plz;
        this.email = new SimpleStringProperty(email);
        this.gebDatum = new SimpleObjectProperty(gebDatum);
        this.geschlecht = new SimpleIntegerProperty(geschlecht);
        this.klasse = new SimpleIntegerProperty(klasse);
        this.verein = verein;
        this.tage = new SimpleIntegerProperty(tage);
    }

    @Override
    public String toString() {
        return "" + idTeilnehmer + ";" + vorname + ";" + nachname + ";" + plz + ";"
                + email + ";" + gebDatum + ";" + geschlecht + ";" + klasse + ";" + verein + ";" + tage;
    }

    public StringProperty vornameProperty() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname.set(vorname);
    }

    public String getVorname() {
        return vorname.get();
    }

    public StringProperty nachnameProperty() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname.set(nachname);
    }

    public String getNachname() {
        return nachname.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public ObjectProperty<Date> gebDatumProperty() {
        return gebDatum;
    }

    public Date getGebDatum() {
        return gebDatum.get();
    }

    public void setGebDatum(Date gebDatum) {
        this.gebDatum.set(gebDatum);
    }

    public int getGeschlecht() {
        return geschlecht.get();
    }

    public void setGeschlecht(int geschlecht) {
        this.geschlecht.set(geschlecht);
    }

    public SimpleIntegerProperty geschlechtProperty() {
        return geschlecht;
    }

    public int getPlz() {
        return plz;
    }

    public int getKlasse() {
        return klasse.get();
    }

    public SimpleIntegerProperty klasseProperty() {
        return klasse;
    }

    public int getVerein() {
        return verein;
    }

    public SimpleIntegerProperty tageProperty() {
        return tage;
    }

}
