/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Datenklassen.Klasse;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Werner
 */
public class KlasseQueries {

    public static ObservableList<Klasse> getKlassen() throws SQLException {
        ObservableList<Klasse> results = FXCollections.observableArrayList();
        try {
            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT "
                    + "IdKlasse, Klasse "
                    + "FROM tblKlasse "
                    + "ORDER BY IDKlasse ASC");
            while (rs.next()) {
                Klasse klasse = new Klasse(rs.getInt("idKlasse"),
                        rs.getString("klasse"));

                results.add(klasse);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return results;
    }
}
