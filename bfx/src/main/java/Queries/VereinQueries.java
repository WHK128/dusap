/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Datenklassen.Verein;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Werner
 */
public class VereinQueries {

    public static ObservableList<Verein> getVereine() throws SQLException {
        ObservableList<Verein> results = FXCollections.observableArrayList();
        try {
            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT "
                    + "IdVerein, Verein, FKOrt "
                    + "FROM tblVerein "
                    + "ORDER BY IDVerein ASC");
            while (rs.next()) {
                Verein verein = new Verein(rs.getInt("idVerein"),
                        rs.getString("verein"),
                        rs.getInt("FKOrt"));

                results.add(verein);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return results;
    }
}
