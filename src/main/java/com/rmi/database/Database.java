/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TRUNG DUNG
 */
public class Database {
    public static Connection chatapp_data() {

        final String url = "jdbc:mysql://localhost:3306/chatapp_data";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }
    public static Connection chatapp_user() {

        final String url = "jdbc:mysql://localhost:3306/chatapp_user";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }
}
