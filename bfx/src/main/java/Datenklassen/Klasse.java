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
public class Klasse {

    private int iDKlasse;
    private String klasse;

    public Klasse(int iDKlasse, String klasse) {
        this.iDKlasse = iDKlasse;
        this.klasse = klasse;
    }

    @Override
    public String toString() {
        return klasse;
    }

    public Integer getIDKlasse() {
        return iDKlasse;
    }

    public void setIDKlasse(int iDKlasse) {
        this.iDKlasse = iDKlasse;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }
}
