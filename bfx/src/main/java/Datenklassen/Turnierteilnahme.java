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
public class Turnierteilnahme {

    private String IDTurnierteilnahme;
    private String FKTeilnhemer;
    private String FKGeschlecht;
    private String FKKlasse;
    private String FKVeranstaltung;

    public Turnierteilnahme(String IDTurnierteilnahme, String FKTeilnhemer, String FKGeschlecht, String FKKlasse, String FKVeranstaltung) {
        this.IDTurnierteilnahme = IDTurnierteilnahme;
        this.FKTeilnhemer = FKTeilnhemer;
        this.FKGeschlecht = FKGeschlecht;
        this.FKKlasse = FKKlasse;
        this.FKVeranstaltung = FKVeranstaltung;
    }

    public String getIDTurnierteilnahme() {
        return IDTurnierteilnahme;
    }

    public void setIDTurnierteilnahme(String IDTurnierteilnahme) {
        this.IDTurnierteilnahme = IDTurnierteilnahme;
    }

    public String getFKTeilnhemer() {
        return FKTeilnhemer;
    }

    public void setFKTeilnhemer(String FKTeilnhemer) {
        this.FKTeilnhemer = FKTeilnhemer;
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

    public String getFKVeranstaltung() {
        return FKVeranstaltung;
    }

    public void setFKVeranstaltung(String FKVeranstaltung) {
        this.FKVeranstaltung = FKVeranstaltung;
    }
}
