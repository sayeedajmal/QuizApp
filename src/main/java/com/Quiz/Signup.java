package com.Quiz;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Signup implements Initializable {
    public JFXTextField signup_name = new JFXTextField();
    public JFXPasswordField signup_password = new JFXPasswordField();

    /* Calling the Database */
    public Signup() throws SQLException {
        Database.create_database();
    }

    Connection connection = Database.create_database();

    public void Creating_user() throws SQLException {
        String create_user = "create table " + signup_name.getText().toUpperCase() + " ( "
                + "username varchar(20) not null, password varchar(12) not null, primary key(username)" + " )";
        Statement statement = connection.createStatement();
        statement.execute(create_user);
        String insert_name = signup_name.getText().toString();
        String insert_password = signup_password.getText().toString();
        String insert_user = "insert into " + signup_name.getText().toUpperCase() + " values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert_user);
        preparedStatement.setString(1, insert_name);
        preparedStatement.setString(2, insert_password);
        if (!insert_name.isBlank() && !insert_password.isBlank()) {
            preparedStatement.executeUpdate();
        } else {
            System.out.println("Fill All Fields");
        }
    }

    /* <<=================FOR-SIGNIN======================>> */
    public void gotSingup(ActionEvent event) throws IOException, InterruptedException, SQLException {
        Creating_user();
        Thread.sleep(100);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.setFullScreen(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setFullScreenExitHint("");
        stage.setMaximized(true);
        stage.show();
        /* CLOSING THE Login WINDOW */
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
        System.out.println("Done.. Sign IN");
    }

    /* FOR EXIT */
    @FXML
    public void exit(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}
