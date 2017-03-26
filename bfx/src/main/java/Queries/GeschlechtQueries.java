/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Datenklassen.Geschlecht;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Werner
 */
public class GeschlechtQueries {
    
    public static ObservableList<Geschlecht> getGeschlecht() throws SQLException {
        ObservableList<Geschlecht> results = FXCollections.observableArrayList();
        try {
            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT "
                    + "idGeschlecht, Geschlecht "
                    + "FROM tblGeschlecht "
                    + "ORDER BY idGeschlecht ASC");
            while (rs.next()) {
                Geschlecht geschlecht = new Geschlecht(rs.getInt("idGeschlecht"),
                        rs.getString("geschlecht"));

                results.add(geschlecht);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return results;
    }
}
