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
public class Ort {

    private String IDOrt;
    private String Ort;
    private String Plz;

    public Ort(String IDOrt, String Ort, String Plz) {
        this.IDOrt = IDOrt;
        this.Ort = Ort;
        this.Plz = Plz;
    }

    public Object[] getValues() {
        return new Object[]{
            getIDOrt(),
            getOrt(),
            getPlz()
        };
    }

    public void setValues(String[] values) {
        setIDOrt(values[0]);
        setOrt(values[1]);
        setPlz(values[2]);
    }

    @Override
    public String toString() {
       return getPlz() + " " + getOrt();
    }

    public String getIDOrt() {
        return IDOrt;
    }

    public void setIDOrt(String IDOrt) {
        this.IDOrt = IDOrt;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String Ort) {
        this.Ort = Ort;
    }

    public String getPlz() {
        return Plz;
    }

    public void setPlz(String Plz) {
        this.Plz = Plz;
    }
}
