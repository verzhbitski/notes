package org.verzhbitski.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import org.verzhbitski.database.DataAdder;
import org.verzhbitski.data.Data;
import org.verzhbitski.data.Note;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewNoteController {
    private String date;
    private String time;
    private String text;

    @FXML
    private TextField dateField;

    @FXML
    private TextField timeField;

    @FXML
    private TextArea textArea;

    public void initialize() {
        textArea.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= 100 ? change : null));

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        date = dateFormat.format(currentDate);
        time = timeFormat.format(currentDate);

        dateField.setText(date);
        timeField.setText(time);
    }

    public void addNote() {
        text = textArea.getText();
        if (text.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty note");
            alert.setContentText("Cannot create empty note");

            alert.showAndWait();

            return;
        }
        Note note = new Note(date, time, text);
        new DataAdder(note).run();
        Data.data.add(note);

        ((Stage) textArea.getScene().getWindow()).close();
    }
}
