package com.example.spil;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
Til SpilApplicationen er der ikke så meget at sige.
Den sørger for at vores spil bliver startet, og at vores view bliver sat, samt vores navn på spil bliver sat.
 */

public class SpilApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SpilApplication.class.getResource("spil-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Kryds og bolle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}