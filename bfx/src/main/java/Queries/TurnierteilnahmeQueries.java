/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Datenklassen.Turnierteilnahme;
import Model.Anmeldedaten;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
//        INSERT INTO <table> (field1, field2, field3, ...) 
//VALUES ('value1', 'value2','value3', ...)
//ON DUPLICATE KEY UPDATE
//field1='value1', field2='value2', field3='value3',
        String statement = "INSERT INTO tblTurnierteilnahme (FKTeilnehmer, FKVeranstaltung, FKGeschlecht, FKKlasse)"
                + "VALUES (" + t.getFKTeilnhemer() + ", " + t.getFKVeranstaltung() + ", "
                + t.getFKGeschlecht() + ", " + t.getFKKlasse() + ")"
                + " ON DUPLICATE KEY UPDATE "
                + "FKTeilnehmer = " + t.getFKTeilnhemer() + ", FKVeranstaltung = " + t.getFKVeranstaltung()
                + ", FKGeschlecht = " + t.getFKGeschlecht() + ", FKKlasse = " + t.getFKKlasse();

        mySqlConnect.MySQLConnection.execUpdate(statement);
    }

    public static ObservableList<Anmeldedaten> getTurnierTeilnehmerListe(int veranstaltung) throws SQLException {
        ObservableList<Anmeldedaten> results = FXCollections.observableArrayList();
        try {
            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT teil.IDTeilnehmer, turn.FKVeranstaltung, "
                    + "turn.FKGeschlecht, turn.FKKlasse, teil.Vorname,  teil.Nachname, teil.Email, "
                    + "teil.FKVerein, teil.GebDatum "
                    + "FROM tblturnierteilnahme as turn "
                    + "JOIN tblTeilnehmer as teil ON teil.IDTeilnehmer = turn.FKTeilnehmer"
                    + "WHERE turn.FKVeranstaltung = " + veranstaltung
                    + "ORDER BY teil.Nachname ASC, teil.Vorname ASC, teil.GebDatum ASC");

            while (rs.next()) {
                Anmeldedaten ad = new Anmeldedaten(
                        rs.getString("IDTeilnehmer") != null ? Integer.valueOf(rs.getString("IDTeilnehmer")) : 0,
                        rs.getString("Vorname") != null ? rs.getString("Vorname") : "",
                        rs.getString("Nachname") != null ? rs.getString("Nachname") : "",
                        rs.getString("Email") != null ? rs.getString("Email") : "",
                        rs.getDate("GebDatum") != null ? rs.getDate("GebDatum") : new Date(),
                        rs.getString("FKGeschlecht") != null ? Integer.valueOf(rs.getString("FKGeschlecht")) : 0,
                        rs.getString("FKKlasse") != null ? Integer.valueOf(rs.getString("FKKlasse")) : 0,
                        rs.getString("FKVerein") != null ? Integer.valueOf(rs.getString("FKVerein")) : 0, 0,
                        0, 0);
                results.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        // http://stackoverflow.com/questions/17576080/store-rows-of-resultset-in-array-of-strings

        return results;
    }

}
