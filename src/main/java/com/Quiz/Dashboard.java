package com.Quiz;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class Dashboard implements Initializable {
    public Text yourname;
    public JFXTextField login_name = new JFXTextField();
    public JFXPasswordField signup_password = new JFXPasswordField();

    public Dashboard() throws SQLException {
        Database.create_database();
    }

    Connection connection = Database.create_database();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
         * String your_name = "select * from " + login_name.getText().toUpperCase(); try
         * { Statement statement = connection.createStatement();
         * statement.execute(your_name); ResultSet resultSet = statement.getResultSet();
         * if (resultSet.next()) { yourname.setText(resultSet.getString("username"));
         * System.out.println(resultSet.getString("username")); } else {
         * System.out.println("I can't Think About That"); } } catch (SQLException e) {
         * e.printStackTrace(); }
         */
        
    };
}
