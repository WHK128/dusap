/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenklassen;
import java.util.Date;
/**
 *
 * @author Werner
 */
public class Veranstaltung {

    private int IDVeranstaltung;
    private String Veranstalung;
    private Date VeranstalungsDatum;

    public Veranstaltung(int IDVeranstaltung, String Veranstalung, Date VeranstalungsDatum) {
        this.IDVeranstaltung = IDVeranstaltung;
        this.Veranstalung = Veranstalung;
        this.VeranstalungsDatum = VeranstalungsDatum;
    }

    public int getIDVeranstaltung() {
        return IDVeranstaltung;
    }

    public void setIDVeranstaltung(int IDVeranstaltung) {
        this.IDVeranstaltung = IDVeranstaltung;
    }

    public String getVeranstalung() {
        return Veranstalung;
    }

    public void setVeranstalung(String Veranstalung) {
        this.Veranstalung = Veranstalung;
    }

    public Date getVeranstalungsDatum() {
        return VeranstalungsDatum;
    }

    public void setVeranstalungsDatum(Date VeranstalungsDatum) {
        this.VeranstalungsDatum = VeranstalungsDatum;
    }
}
