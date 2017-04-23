/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Datenklassen.Score;

/**
 *
 * @author Werner
 */
public class ScoreEingabeQueries {

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
//  5erTag2tag1
    public static void saveScore(int fkTeilnehmer, int fkVeranstaltung,
            int punkteTag1, int zehnErTag1, int achtErTag1, int fuenfErTag1,
            int punkteTag2, int zehnErTag2, int achtErTag2, int fuenfErTag2) {
        String statement = "INSERT INTO tblScore(fkTeilnehmer, fkVeranstaltung, PunkteTag1, "
                + "10erTag1, 8erTag1, 5erTag1, PunkteTag2, 10erTag2, 8erTag2, 5erTag2) "
                + "VALUES (" + fkTeilnehmer + ", " + fkVeranstaltung
                + ", " + punkteTag1 + ", " + zehnErTag1 + ", " + achtErTag1 + ", " + fuenfErTag1
                + ", " + punkteTag2 + ", " + zehnErTag2 + ", " + achtErTag2 + ", " + fuenfErTag2 + ") "
                + " ON DUPLICATE KEY UPDATE "
                + "fkTeilnehmer = " + fkTeilnehmer + ", fkVeranstaltung = " + fkVeranstaltung; // + ", "
//                + "Punkte = " + punkte + ", 10er = " + zehnEr + ", 8er = " + achtEr + ", 5er = " + fuenfEr;

        mySqlConnect.MySQLConnection.execUpdate(statement);
    }
    public static void saveScore(Score score) {
        String statement = "INSERT INTO tblScore(fkTeilnehmer, fkVeranstaltung, tage, PunkteTag1, "
                + "10erTag1, 8erTag1, 5erTag1, PunkteTag2, 10erTag2, 8erTag2, 5erTag2) "
                + "VALUES (" + score.getFKTeilnhemer() + ", " + score.getFKVeranstaltung() + ", " + score.getTage()
                + ", " + score.getPunkteTag1() + ", " + score.getCol10erTag1() + ", " + score.getCol8erTag1() + ", " + score.getCol5erTag1()
                + ", " + score.getPunkteTag2() + ", " + score.getCol10erTag2() + ", " + score.getCol8erTag2() + ", " + score.getCol5erTag2() + ") "
                + " ON DUPLICATE KEY UPDATE "
                + "fkTeilnehmer = " + score.getFKTeilnhemer() + ", fkVeranstaltung = " + score.getFKVeranstaltung();
        mySqlConnect.MySQLConnection.execUpdate(statement);
    }
}
