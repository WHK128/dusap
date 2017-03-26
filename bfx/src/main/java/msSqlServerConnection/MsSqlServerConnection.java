/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msSqlServerConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Werner
 */
public class MsSqlServerConnection {

    //http://stackoverflow.com/questions/25651641/javafx-mysql-connection-example-please
    static private String dbHost = "localhost"; // Hostname
    static private String dbPort = "1433";      // Port -- Standard: 3306
    static private String dbName = "dbbogen";   // Datenbankname
    static private String driverClassName ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static private String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=dbBogen";
    static private String dbUser = "werner";     // Datenbankuser
    static private String dbPass = "werner";      // Datenbankpasswort

    // in real life, use a connection pool....
    private static Connection connection;

    public MsSqlServerConnection() {
    }

    public MsSqlServerConnection(String driverClassName, String dbURL, String dbUser, String dbPass) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
    }

    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    private static Connection getInstance() {
        if (connection == null) {
            try {
                new MsSqlServerConnection(driverClassName, dbUrl, dbUser, dbPass);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(MsSqlServerConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    public static ResultSet execQuery(String statement) {
        connection = getInstance();
        if (connection != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = connection.createStatement();

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

    //Gebe Tabelle in die Konsole aus
    public static void printNameList() {
//        connection = getInstance();

        if (connection != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = connection.createStatement();

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
//
//    String connectionUrl;
//
//    public String getConnection(String connection) {
//        try {
//            if (connection == null
//                    || !connection.isValid(50)) {
//                connection = DriverManager.getConnection(connectionUrl);
//            }
//            return connection;
//        } catch (sqle SQLException
//            
//            
//                ) {
//            println("getConnection {sqle}");
//                return null;
//            }
//        }
//
//    
//
//    
//
//    public function open() 
//        : Boolean {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connectionUrl = "jdbc:sqlserver://{ip}:{port};databaseName={databaseName};";
//            connectionUrl += "user={user};";
//            connectionUrl += "password={password};";
//            connectionUrl += "selectMethod=direct";
//            println(connectionUrl);
//            connection = getConnection();
//            return connection != null
//        } catch (e  :Exception
//            
//            
//                ) {
//            logger("open", "{e}");
//                return false;
//            }
//        };
//
}
