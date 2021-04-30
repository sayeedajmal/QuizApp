package com.Quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simle JavaFx");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/style.css");
        Image icon = new Image("/images/hotline.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}