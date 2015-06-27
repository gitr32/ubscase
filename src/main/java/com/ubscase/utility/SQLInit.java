/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.utility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author r128
 */
public class SQLInit {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:8889/ubscase";

    private static final String USER = "root";
    private static final String PASS = "root";


    public static Connection initialise() {

        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            return null;
        }
        return conn;
    }
}
