/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mySqlConnect;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 *
 * @author Werner
 */
public class NewClass {

    public static void main(String[] args) {

        MySQLConnection.printNameList();

        for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements();) {
            System.out.println(e.nextElement().getClass().getName());
        }

    }

}
