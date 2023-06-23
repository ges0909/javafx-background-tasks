package com.valantic.sti.tutorial;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class BackgroundController {

    @FXML
    private TextField inputTextField;

    @FXML
    private Label outputLabel;

    @FXML
    private ProgressBar progressBar;

    private LongRunningTask longRunningTask;

    @FXML
    private void handleButtonClick() {
        log.info("invoke counter background task");

        final String input = inputTextField.getText().replace(",", "");
        final long limit = Long.parseLong(input);

        if (Objects.nonNull(longRunningTask) && longRunningTask.isRunning()) {
            longRunningTask.cancel();
        }
        longRunningTask = new LongRunningTask(limit); // task to be run in thread
        longRunningTask.valueProperty().addListener(
                (observable, oldValue, newValue) -> outputLabel.setText(String.valueOf(newValue))
        );
        progressBar.progressProperty().bind(longRunningTask.progressProperty());

        final Thread counterThread = new Thread(longRunningTask);
        counterThread.setDaemon(true);
        counterThread.start();
    }
}
