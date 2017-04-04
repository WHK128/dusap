/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mySqlConnect;

/**
 *
 * @author Werner
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

    private static Connection con = null;
    private static String dbHost = "localhost"; // Hostname
    private static String dbPort = "3306";      // Port -- Standard: 3306
    private static String dbName = "dbbogen";   // Datenbankname
    private static String dbUser = "root";     // Datenbankuser
    private static String dbPass = "werner";      // Datenbankpasswort

    private MySQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.

            // Verbindung zur JDBC-Datenbank herstellen.
            con = DriverManager.getConnection("jdbc:mysql://" +
                    dbHost + ":" + dbPort + "/" + dbName + "?" + "user=" + 
                    dbUser + "&" + "password=" + dbPass);
        } catch (ClassNotFoundException e) {
            System.out.println("Treiber nicht gefunden");
        } catch (SQLException e) {
            System.out.println("Verbindung nicht moglich");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    private static Connection getInstance() {
        if (con == null) {
            new MySQLConnection();
        }
        return con;
    }

    public static ResultSet execQuery(String statement) {
        System.out.println(statement);
        con = getInstance();
        if (con != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = con.createStatement();

                // Tabelle anzeigen
                String sql = statement;

                ResultSet result = query.executeQuery(sql);
                return result;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    // Das Update kann auch für Insert und Delete verwendet werden
    public static void execUpdate(String statement) {
        System.out.println(statement);
        con = getInstance();
        if (con != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = con.createStatement();

                // Tabelle anzeigen
                String sql = statement;

                query.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Gebe Tabelle in die Konsole aus
    public static void printNameList() {
        con = getInstance();

        if (con != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = con.createStatement();

                // Tabelle anzeigen
                String sql
                        = "SELECT * from tblteilnehmer";
                ResultSet result = query.executeQuery(sql);

                // Ergebnisstabelle durchforsten
                while (result.next()) {
                    String kundeid = result.getString("idteilnehmer");
                    String vorname = result.getString("vorname");
                    String nachname = result.getString("nachname");
                    String email = result.getString("email");
                    String info = kundeid + ", " + vorname + ", " + nachname + ", " + email;

                    System.out.println(info);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
