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
public class ScoreEingabe {

    private Turnierteilnahme turnierteilnahme;
    private Score score;

    public ScoreEingabe(Turnierteilnahme turnierteilnahme, Score score) {
        this.turnierteilnahme = turnierteilnahme;
        this.score = score;
    }

    public Turnierteilnahme getTurnierteilnahme() {
        return turnierteilnahme;
    }

    public Score getScore() {
        return score;
    }
}
