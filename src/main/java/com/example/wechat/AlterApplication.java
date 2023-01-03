package com.example.wechat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AlterApplication {

    public void Alter()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AlertPerson.fxml"));
        AnchorPane borderPane = fxmlLoader.load();
        Scene scene=new Scene(borderPane);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AlertPerson.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("change");
        stage.setScene(scene);
        stage.show();
    }
}
