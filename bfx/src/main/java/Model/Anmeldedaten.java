/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
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
//    private int plz;
    private StringProperty email;
    private ObjectProperty<Date> gebDatum;
    private SimpleIntegerProperty geschlecht;
    private SimpleIntegerProperty klasse;
//    private int geschlecht;
//    private int klasse;
    private int verein;
    private SimpleIntegerProperty tage;
    private SimpleIntegerProperty scoreTag1;
    private SimpleIntegerProperty scoreTag2;

    public Anmeldedaten(String s) {
        String[] array = s.split("\\;", -1);
        idTeilnehmer = Integer.valueOf(array[0]);
        vorname = new SimpleStringProperty(array[1]);
        nachname = new SimpleStringProperty(array[2]);
//        plz = Integer.valueOf(array[3]);
        email = new SimpleStringProperty(array[3]);
        gebDatum = new SimpleObjectProperty(array[4]);
        geschlecht = new SimpleIntegerProperty(Integer.valueOf(array[5]));
        klasse = new SimpleIntegerProperty(Integer.valueOf(array[6]));
        verein = Integer.valueOf(array[7]);
        tage = new SimpleIntegerProperty(Integer.valueOf(array[8]));
    }

    public Anmeldedaten(
            int idTeilnehmer,
            String vorname,
            String nachname,
//            int plz,
            String email,
            Date gebDatum,
            int geschlecht,
            int klasse,
            int verein,
            int tage,
            int scoreTag1,
            int scoreTag2) {
        this.idTeilnehmer = idTeilnehmer;
        this.vorname = new SimpleStringProperty(vorname);
        this.nachname = new SimpleStringProperty(nachname);
//        this.plz = plz;
        this.email = new SimpleStringProperty(email);
        this.gebDatum = new SimpleObjectProperty(gebDatum);
        this.geschlecht = new SimpleIntegerProperty(geschlecht);
        this.klasse = new SimpleIntegerProperty(klasse);
        this.verein = verein;
        this.tage = new SimpleIntegerProperty(tage);
        this.scoreTag1 = new SimpleIntegerProperty(scoreTag1);
        this.scoreTag2 = new SimpleIntegerProperty(scoreTag2);
    }

    @Override
    public String toString() {
        return "" + idTeilnehmer + ";" + vorname + ";" + nachname + ";" // + plz + ";"
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


    public int getKlasse() {
        return klasse.get();
    }

    public SimpleIntegerProperty klasseProperty() {
        return klasse;
    }

    public int getVerein() {
        return verein;
    }

    public Integer getScoreTag1() {
        return scoreTag1.get();
    }

    public void setScoreTag1(Integer scoreTag1) {
        this.scoreTag1.set(scoreTag1);
    }

    public Integer getScoreTag2() {
        return scoreTag2.get();
    }

    public void setScoreTag2(Integer scoreTag2) {
        this.scoreTag2.set(scoreTag2);
    }

    public SimpleIntegerProperty tageProperty() {
        return tage;
    }

    public SimpleIntegerProperty scoreTag1Property() {
        return scoreTag1;
    }

    public SimpleIntegerProperty scoreTag2Property() {
        return scoreTag2;
    }

    public int getIdTeilnehmer() {
        return idTeilnehmer;
    }

    public void setIdTeilnehmer(int idTeilnehmer) {
        this.idTeilnehmer = idTeilnehmer;
    }

}
