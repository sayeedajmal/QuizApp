package com.Quiz;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    public JFXTextField name;
    public JFXTextArea suggest;
    public JFXButton submit;
    public Label thank;

    public void submit(ActionEvent event) {
        thank.setText("Thanks For Giving FeedBack!");
        name.setText(null);
        suggest.setText(null);
    }
}
