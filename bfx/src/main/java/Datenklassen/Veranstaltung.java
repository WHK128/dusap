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
public class Veranstaltung {

    private String IDVeranstaltung;
    private String Veranstalung;
    private String VeranstalungsDatum;

    public Veranstaltung(String IDVeranstaltung, String Veranstalung, String VeranstalungsDatum) {
        this.IDVeranstaltung = IDVeranstaltung;
        this.Veranstalung = Veranstalung;
        this.VeranstalungsDatum = VeranstalungsDatum;
    }

    public String getIDVeranstaltung() {
        return IDVeranstaltung;
    }

    public void setIDVeranstaltung(String IDVeranstaltung) {
        this.IDVeranstaltung = IDVeranstaltung;
    }

    public String getVeranstalung() {
        return Veranstalung;
    }

    public void setVeranstalung(String Veranstalung) {
        this.Veranstalung = Veranstalung;
    }

    public String getVeranstalungsDatum() {
        return VeranstalungsDatum;
    }

    public void setVeranstalungsDatum(String VeranstalungsDatum) {
        this.VeranstalungsDatum = VeranstalungsDatum;
    }
}
