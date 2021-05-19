package com.Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static Connection create_database() throws SQLException {
        String databaseurl = "jdbc:derby:database;create=true";
        Connection connection = DriverManager.getConnection(databaseurl);
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = Database.create_database();
        String record = "select * from SAYEED";
        Statement statement = connection.createStatement();
        statement.executeQuery(record);
        ResultSet resultSet = statement.getResultSet();
        if (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
        } else {

        }
    }
}
