package com.valantic.sti.tutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;

@Slf4j
public class Main extends Application {

    private Stage window;

    public static void main(final String... args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws IOException {
        window = stage;
        window.setTitle("JavaFX Background Tasks");

        final URL location = getClass().getResource("background-view.fxml");
        final FXMLLoader loader = new FXMLLoader(location);
        final VBox parent = loader.load();

        final Scene scene = new Scene(parent, 350, 250);
        stage.setScene(scene);
        stage.show();
    }
}
