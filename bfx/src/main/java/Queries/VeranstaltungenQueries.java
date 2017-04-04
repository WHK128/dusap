/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Datenklassen.Veranstaltung;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Werner
 */
public class VeranstaltungenQueries {

    public static Veranstaltung getletzteVeranstaltung() throws SQLException {
        try {
            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT "
                    + "IdVeranstaltung, Veranstaltung, Veranstaltungsdatum "
                    + "FROM tblVeranstaltung "
                    + "ORDER BY IDVeranstaltung DESC LIMIT 1");

            return new Veranstaltung(rs.getInt("idVeranstaltung"),
                    rs.getString("Veranstaltung"),
                    rs.getDate("VeranstaltungsDatum"));

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
