package com.Quiz;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
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

public class Login implements Initializable {
    @FXML
    public JFXTextField login_name;
    public JFXPasswordField login_password;
    public JFXButton login;

    /* Calling Database Connection */
    public Login() throws SQLException {
        Database.create_database();
    }

    Connection connection = Database.create_database();

    /* Accessing login */
    public void login(ActionEvent event) throws IOException {
        String Query_for_login = "select * from " + login_name.getText().toUpperCase()
                + " where username=? and password=?";
        try {
            String username = login_name.getText();
            String password = login_password.getText();
            PreparedStatement preparedStatement = connection.prepareStatement(Query_for_login);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            if (!username.isBlank() && !password.isBlank()) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    scene.getStylesheets().add("/styles/style.css");
                    stage.setTitle("Login");
                    stage.setFullScreen(true);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setFullScreenExitHint("");
                    stage.setMaximized(true);
                    stage.show();
                    System.out.println("Login Sucessfully");
                    ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
                } else {
                    System.out.println("Username or Password is Invalid");
                }
            } else {
                System.out.println("Fill out All Fields");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* link for returning into Signup Page */
    public void signup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Signup.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        scene.getStylesheets().add("/styles/style.css");
        stage.setTitle("SignUp");
        stage.setFullScreen(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setFullScreenExitHint("");
        stage.setMaximized(true);
        stage.show();

        /* CLOSING THE SIGNIN WINDOW */
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
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
