package com.Quiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller implements Initializable {
    @FXML
    public GridPane gridpane = new GridPane();

    /* <<=================FOR-SIGNIn======================>> */
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
    }

    /* <<=================FOR-SIGNUP======================>> */
    public void signup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Signup.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
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
    public void initialize(URL location, ResourceBundle resources) {

    }

}
