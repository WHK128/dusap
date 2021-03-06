/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

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
public class TeilnehmerQueries {

    public static ObservableList<Anmeldedaten> getAnmeldedaten() throws SQLException {
        ObservableList<Anmeldedaten> results = FXCollections.observableArrayList();
        try {
            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT IDTeilnehmer, "
                    + "Vorname,  Nachname, Email, FKVerein, GebDatum, "
                    + "FKGeschlecht, FKKlasse"
                    + " FROM tblTeilnehmer "
                    + "ORDER BY Nachname ASC, Vorname ASC, GebDatum ASC");
//            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT IdTeilnehmer, "
////            ResultSet rs = msSqlServerConnection.MsSqlServerConnection.execQuery("SELECT IdTeilnehmer, "
//                    + "vorname,  nachname, email, plz, ort, verein, gebDatum, "
//                    + "geschlecht, klasse"
//                    + " FROM tblTeilnehmer "
//                    + "LEFT JOIN tblVerein on fkVerein = idVerein "
//                    + "LEFT JOIN tblOrt on tblTeilnehmer.fkOrt = idOrt "
//                    + "LEFT JOIN tblGeschlecht on fkGeschlecht = idGeschlecht "
//                    + "LEFT JOIN tblKlasse on fkKlasse = idKlasse "
//                    + "ORDER BY nachname ASC, vorname ASC, gebDatum ASC");

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

    public static ObservableList<Anmeldedaten> getTurnierTeilnehmerAnmeldedaten(int fkVeranstaltung) throws SQLException {
        ObservableList<Anmeldedaten> results = FXCollections.observableArrayList();
        try {
            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT t.IDTeilnehmer, "
                    + "t.Vorname, t.Nachname, t.Email, t.FKVerein, t.GebDatum, "
                    + "t.FKGeschlecht, t.FKKlasse, s.tage, s.PunkteTag1, s.PunkteTag2"
                    + " FROM tblTeilnehmer AS t"
                    + " LEFT JOIN tblscore AS s ON t.IDTeilnehmer = s.fkTeilnehmer"
                    + " LEFT JOIN tblturnierteilnahme AS tt ON t.IDTeilnehmer = tt.FKTeilnehmer"
                    + " WHERE tt.FKVeranstaltung = " + fkVeranstaltung
                    + " ORDER BY t.Nachname ASC, t.Vorname ASC, t.GebDatum ASC");
            
            while (rs.next()) {
                Anmeldedaten ad = new Anmeldedaten(
                        rs.getString("IDTeilnehmer") != null ? Integer.valueOf(rs.getString("IDTeilnehmer")) : 0,
                        rs.getString("Vorname") != null ? rs.getString("Vorname") : "",
                        rs.getString("Nachname") != null ? rs.getString("Nachname") : "",
                        rs.getString("Email") != null ? rs.getString("Email") : "",
                        rs.getDate("GebDatum") != null ? rs.getDate("GebDatum") : new Date(),
                        rs.getString("FKGeschlecht") != null ? Integer.valueOf(rs.getString("FKGeschlecht")) : 0,
                        rs.getString("FKKlasse") != null ? Integer.valueOf(rs.getString("FKKlasse")) : 0,
                        rs.getString("FKVerein") != null ? Integer.valueOf(rs.getString("FKVerein")) : 0,
                        rs.getString("s.tage") != null ? Integer.valueOf(rs.getString("s.tage")) : 0,
                        rs.getString("s.PunkteTag1") != null ? Integer.valueOf(rs.getString("s.PunkteTag1")) : 0,
                        rs.getString("s.PunkteTag2") != null ? Integer.valueOf(rs.getString("s.PunkteTag2")) : 0
                );
                results.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        // http://stackoverflow.com/questions/17576080/store-rows-of-resultset-in-array-of-strings

        return results;
    }

//    public class PersonDataAccessor {
//
//    // in real life, use a connection pool....
//    private Connection connection ;
//
//    public PersonDataAccessor(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
//        Class.forName(driverClassName);
//        connection = DriverManager.getConnection(dbURL, user, password);
//    }
//
//    public void shutdown() throws SQLException {
//        if (connection != null) {
//            connection.close();
//        }
//    }
//
//    public List<Person> getPersonList() throws SQLException {
//        try (
//            Statement stmnt = connection.createStatement();
//            ResultSet rs = stmnt.executeQuery("select * from person");
//        ){
//            List<Person> personList = new ArrayList<>();
//            while (rs.next()) {
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                String email = rs.getString("email_address");
//                Person person = new Person(firstName, lastName, email);
//                personList.add(person);
//            }
//            return personList ;
//        } 
//    }
//
//    // other methods, eg. addPerson(...) etc
//}
//    
}
