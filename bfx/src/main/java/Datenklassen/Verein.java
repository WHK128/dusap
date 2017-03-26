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
public class Verein {

    private int idVerein;
    private String verein;
    private int fkOrt;

    public Verein(int idVerein, String verein, int fkOrt) {
        this.idVerein = idVerein;
        this.verein = verein;
        this.fkOrt = fkOrt;
    }

    @Override
    public String toString() {
        return verein;
    }

    public Integer getIDVerein() {
        return idVerein;
    }

    public void setIDVerein(int idVerein) {
        this.idVerein = idVerein;
    }

    public String getVerein() {
        return verein;
    }

    public void setVerein(String verein) {
        this.verein = verein;
    }

    public Integer getFKOrt() {
        return fkOrt;
    }

    public void setFKOrt(int fkOrt) {
        this.fkOrt = fkOrt;
    }
}
