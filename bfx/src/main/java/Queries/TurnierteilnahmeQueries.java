/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Datenklassen.Turnierteilnahme;

/**
 *
 * @author Werner
 */
public class TurnierteilnahmeQueries {

//     private int IDTurnierteilnahme;
//    private int FKTeilnhemer;
//    private int FKGeschlecht;
//    private int FKKlasse;
//    private int FKVeranstaltung;
    public static void saveTurnierTeilnahme(Turnierteilnahme t) {

        String statement = "INSERT INTO tblTurnierteilnahme (FKTeilnehmer, FKGeschlecht, FKKlasse, FKVeranstaltung)"
                + "VALUES (" + t.getFKTeilnhemer() + ", " + t.getFKGeschlecht() + ", " + t.getFKKlasse() + ", " + t.getFKVeranstaltung() + ")";

        mySqlConnect.MySQLConnection.execUpdate(statement);
    }
}
