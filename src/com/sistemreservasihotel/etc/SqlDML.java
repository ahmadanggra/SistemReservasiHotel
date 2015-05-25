/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemreservasihotel.etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author anggra
 */
public class SqlDML {

    protected ResultSet resultSet;
    protected Connection connection;
    protected Statement statement;
    protected final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    protected final String DB_URL = "jdbc:mysql://localhost:3306/hotel_java";
    protected final String SQL_USERNAME = "root";
    protected final String SQL_PASSWORD = "";

    // Make connection into database
    protected void makeConnection() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, SQL_USERNAME, SQL_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Terminate connection from database
    protected void terminateConnection() {
        try {
            connection.close();
        } catch (Exception e) {

        }
    }

    // Method for querying table
    protected ResultSet queryDataBase(String str) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Method for insert table
    protected void insertDataBase(String str) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method for delete table
    protected void deleteDatabase(String str) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method for update table
    protected void updateDatabase(String str) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
