package com.Quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Dashboard implements Initializable {
    public Label yourname = new Label();
    Login login = new Login();

    public Dashboard() throws SQLException {
        Database.create_database();
    }

    Connection connection = Database.create_database();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("username.txt");
        String uname;
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                uname = input.nextLine();
                String query = "select * from " + uname;
                Statement statement = connection.createStatement();
                statement.execute(query);
                ResultSet resultSet = statement.getResultSet();
                if (resultSet.next()) {
                    yourname.setText(resultSet.getString("username"));
                    System.out.println("Got it : " + resultSet.getString("username"));
                } else {
                    System.out.println("I can't Think About That");
                }
            }
            input.close();
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("fuck it");
        }
    }
}