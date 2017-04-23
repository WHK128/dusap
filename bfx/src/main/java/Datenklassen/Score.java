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
public class Score {

//  fkTeilnehmer int(11) PK 
//  fkVeranstaltung int(11) PK 
//  tage int(11) 
//  PunkteTag1 int(11) 
//  10erTag1 int(11) 
//  8erTag1 int(11) 
//  5erTag1 int(11) 
//  PunkteTag2 int(11) 
//  10erTag2 int(11) 
//  8erTag2 int(11) 
//  5erTag2
    private int FKTeilnhemer;
    private int FKVeranstaltung;
    private int tage;
    private int punkteTag1;
    private int col10erTag1;
    private int col8erTag1;
    private int col5erTag1;
    private int punkteTag2;
    private int col10erTag2;
    private int col8erTag2;
    private int col5erTag2;

    public Score() {
    }

    public Score(int FKTeilnhemer, int FKVeranstaltung, int tage,
            int punkteTag1, int col10erTag1, int col8erTag1, int col5erTag1,
            int punkteTag2, int col10erTag2, int col8erTag2, int col5erTag2) {
        this.FKTeilnhemer = FKTeilnhemer;
        this.FKVeranstaltung = FKVeranstaltung;
        this.tage = tage;
        this.punkteTag1 = punkteTag1;
        this.col10erTag1 = col10erTag1;
        this.col8erTag1 = col8erTag1;
        this.col5erTag1 = col5erTag1;
        this.punkteTag2 = punkteTag2;
        this.col10erTag2 = col10erTag2;
        this.col8erTag2 = col8erTag2;
        this.col5erTag2 = col5erTag2;
    }

    public int getFKTeilnhemer() {
        return FKTeilnhemer;
    }

    public void setFKTeilnhemer(int FKTeilnhemer) {
        this.FKTeilnhemer = FKTeilnhemer;
    }

    public int getFKVeranstaltung() {
        return FKVeranstaltung;
    }

    public void setFKVeranstaltung(int FKVeranstaltung) {
        this.FKVeranstaltung = FKVeranstaltung;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    public int getPunkteTag1() {
        return punkteTag1;
    }

    public void setPunkteTag1(int punkteTag1) {
        this.punkteTag1 = punkteTag1;
    }

    public int getCol10erTag1() {
        return col10erTag1;
    }

    public void setCol10erTag1(int col10erTag1) {
        this.col10erTag1 = col10erTag1;
    }

    public int getCol8erTag1() {
        return col8erTag1;
    }

    public void setCol8erTag1(int col8erTag1) {
        this.col8erTag1 = col8erTag1;
    }

    public int getCol5erTag1() {
        return col5erTag1;
    }

    public void setCol5erTag1(int col5erTag1) {
        this.col5erTag1 = col5erTag1;
    }

    public int getPunkteTag2() {
        return punkteTag2;
    }

    public void setPunkteTag2(int punkteTag2) {
        this.punkteTag2 = punkteTag2;
    }

    public int getCol10erTag2() {
        return col10erTag2;
    }

    public void setCol10erTag2(int col10erTag2) {
        this.col10erTag2 = col10erTag2;
    }

    public int getCol8erTag2() {
        return col8erTag2;
    }

    public void setCol8erTag2(int col8erTag2) {
        this.col8erTag2 = col8erTag2;
    }

    public int getCol5erTag2() {
        return col5erTag2;
    }

    public void setCol5erTag2(int col5erTag2) {
        this.col5erTag2 = col5erTag2;
    }

}
