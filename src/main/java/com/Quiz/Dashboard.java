package com.Quiz;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Dashboard implements Initializable {
    public Label yourname;
    public JFXTextField login_name = new JFXTextField();

    public Dashboard() throws SQLException {
        Database.create_database();

    }

    Connection connection = Database.create_database();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String your_name = "select * from " + login_name.getText().toUpperCase();
        try {
            Statement statement = connection.createStatement();
            statement.execute(your_name);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                yourname.setText(resultSet.getString("username"));
            } else {
                System.out.println("I can't Think About That");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    };
}
