/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenklassen;

/**
 *
 * @author Werner
 */
public class Teilnehmer {

    private String IDTeilnehmer;
    private String Vorname;
    private String Nachname;
    private String Email;
    private String FKOrt;
    private String Verein;
    private String GebDatum;
    private String FKGeschlecht;
    private String FKKlasse;

    public Teilnehmer(String IDTeilnehmer,
            String Vorname,
            String Nachname,
            String Email,
            String FKOrt,
            String Verein,
            String GebDatum,
            String FKGeschlecht,
            String FKKlasse) {
        this.IDTeilnehmer = IDTeilnehmer;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Email = Email;
        this.FKOrt = FKOrt;
        this.Verein = Verein;
        this.GebDatum = GebDatum;
        this.FKGeschlecht = FKGeschlecht;
        this.FKKlasse = FKKlasse;
    }

    public Object[] getValues() {
        return new Object[]{
            getIDTeilnehmer(),
            getVorname(),
            getNachname(),
            getEmail(),
            getFKOrt(),
            getVerein(),
            getGebDatum(),
            getFKGeschlecht(),
            getFKKlasse()
        };
    }

    public void setValues(String[] values) {
        setIDTeilnehmer(values[0]);
        setVorname(values[1]);
        setNachname(values[2]);
        setEmail(values[3]);
        setFKOrt(values[4]);
        setVerein(values[5]);
        setGebDatum(values[6]);
        setFKGeschlecht(values[7]);
        setFKKlasse(values[8]);
    }

    public String getIDTeilnehmer() {
        return IDTeilnehmer;
    }

    public void setIDTeilnehmer(String IDTeilnehmer) {
        this.IDTeilnehmer = IDTeilnehmer;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String Nachname) {
        this.Nachname = Nachname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFKOrt() {
        return FKOrt;
    }

    public void setFKOrt(String FKOrt) {
        this.FKOrt = FKOrt;
    }

    public String getVerein() {
        return Verein;
    }

    public void setVerein(String Verein) {
        this.Verein = Verein;
    }

    public String getGebDatum() {
        return GebDatum;
    }

    public void setGebDatum(String GebDatum) {
        this.GebDatum = GebDatum;
    }

    public String getFKGeschlecht() {
        return FKGeschlecht;
    }

    public void setFKGeschlecht(String FKGeschlecht) {
        this.FKGeschlecht = FKGeschlecht;
    }

    public String getFKKlasse() {
        return FKKlasse;
    }

    public void setFKKlasse(String FKKlasse) {
        this.FKKlasse = FKKlasse;
    }
}
