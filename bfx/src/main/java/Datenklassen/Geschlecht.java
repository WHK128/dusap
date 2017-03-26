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
public class Geschlecht {

    private int idGeschlecht;
    private String geschlecht;

    public Geschlecht(int idGeschlecht, String geschlecht) {
        this.idGeschlecht = idGeschlecht;
        this.geschlecht = geschlecht;
    }

    @Override
    public String toString() {
        return geschlecht;
    }

    public int getIDGeschlecht() {
        return idGeschlecht;
    }

    public void setIDGeschlecht(int idGeschlecht) {
        this.idGeschlecht = idGeschlecht;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }
}
