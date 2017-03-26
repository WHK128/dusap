/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Datenklassen.Ort;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author Werner
 */
public class OrtQueries {

    private static ObservableList<Ort> ortList = null;

    public static void loadPlzOrt() throws SQLException {
        ortList = FXCollections.observableArrayList();
        try {
            ResultSet rs = mySqlConnect.MySQLConnection.execQuery("SELECT "
                    + "IdOrt, Ort, Plz "
                    + "FROM tblOrt "
                    + "ORDER BY IDOrt ASC");
            while (rs.next()) {
                Ort klasse = new Ort(rs.getString("IDOrt"),
                        rs.getString("Ort"),
                        rs.getString("Plz"));

                ortList.add(klasse);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static ObservableList<Ort> getPlzOrt() {
        return ortList;
    }

    public static boolean isPlzValid(String plz) {
        FilteredList<Ort> filtered = getPlzOrt().filtered(o
                -> o.getPlz().equals(plz)
        );
        return filtered.size() > 0;
    }
}
