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
    
    private int fkTurnierteilnahme;
    private int punkte;
    private int col10er;
    private int col8er;
    private int col5er;
    private int scheibe; // wird nicht verwendet

    public Score() {
    }

    public Score(int fkTurnierteilnahme, int punkte, int col10er, int col8er, int col5er) {
        this.fkTurnierteilnahme = fkTurnierteilnahme;
        this.punkte = punkte;
        this.col10er = col10er;
        this.col8er = col8er;
        this.col5er = col5er;
    }

    public int getFkTurnierteilnahme() {
        return fkTurnierteilnahme;
    }

    public void setFkTurnierteilnahme(int fkTurnierteilnahme) {
        this.fkTurnierteilnahme = fkTurnierteilnahme;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public int getCol10er() {
        return col10er;
    }

    public void setCol10er(int col10er) {
        this.col10er = col10er;
    }

    public int getCol8er() {
        return col8er;
    }

    public void setCol8er(int col8er) {
        this.col8er = col8er;
    }

    public int getCol5er() {
        return col5er;
    }

    public void setCol5er(int col5er) {
        this.col5er = col5er;
    }
}