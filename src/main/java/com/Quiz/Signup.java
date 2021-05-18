package com.Quiz;

import java.io.IOException;
import java.net.URL;
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
    public JFXTextField signup_name;
    public JFXPasswordField signup_password;

    /* <<=================FOR-SIGNIN======================>> */
    public void gotSingup(ActionEvent event) throws IOException {
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
        System.out.println(signup_name.getText().toString());
        System.out.println(signup_password.getText().toString());
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
