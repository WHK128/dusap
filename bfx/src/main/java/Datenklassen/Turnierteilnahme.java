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

    private int FKTeilnhemer;
    private int FKVeranstaltung;
    private int FKGeschlecht;
    private int FKKlasse;

    public Turnierteilnahme(int FKTeilnhemer, int FKVeranstaltung, int FKGeschlecht, int FKKlasse) {
        this.FKTeilnhemer = FKTeilnhemer;
        this.FKVeranstaltung = FKVeranstaltung;
        this.FKGeschlecht = FKGeschlecht;
        this.FKKlasse = FKKlasse;
    }

    public int getFKTeilnhemer() {
        return FKTeilnhemer;
    }

    public void setFKTeilnhemer(int FKTeilnhemer) {
        this.FKTeilnhemer = FKTeilnhemer;
    }

    public int getFKGeschlecht() {
        return FKGeschlecht;
    }

    public void setFKGeschlecht(int FKGeschlecht) {
        this.FKGeschlecht = FKGeschlecht;
    }

    public int getFKKlasse() {
        return FKKlasse;
    }

    public void setFKKlasse(int FKKlasse) {
        this.FKKlasse = FKKlasse;
    }

    public int getFKVeranstaltung() {
        return FKVeranstaltung;
    }

    public void setFKVeranstaltung(int FKVeranstaltung) {
        this.FKVeranstaltung = FKVeranstaltung;
    }
}
