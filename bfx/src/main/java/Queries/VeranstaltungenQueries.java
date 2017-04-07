/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Datenklassen.Veranstaltung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Werner
 */
public class VeranstaltungenQueries {

    public static Veranstaltung getletzteVeranstaltung() throws SQLException {
        try {
            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT "
                    + "IDVeranstaltung, Veranstaltung, Veranstaltungsdatum "
                    + "FROM tblVeranstaltung "
                    + "ORDER BY IDVeranstaltung DESC LIMIT 1");
            while (rs.next()) {
                return new Veranstaltung(
                        rs.getString("IDVeranstaltung") != null ? Integer.valueOf(rs.getString("IDVeranstaltung")) : 0,
                        rs.getString("Veranstaltung") != null ? rs.getString("Veranstaltung") : "",
                        rs.getDate("Veranstaltungsdatum") != null ? rs.getDate("Veranstaltungsdatum") : new Date());
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void saveNeueVeranstaltung(String veranstaltung, LocalDate datum) {
        String statement = "INSERT INTO tblveranstaltung (Veranstaltung, Veranstaltungsdatum)"
                + "VALUES (" + veranstaltung + ", " + datum + ")";

        mySqlConnect.MySQLConnection.execUpdate(statement);
    }
}
