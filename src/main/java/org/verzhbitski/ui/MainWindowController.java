package org.verzhbitski.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.verzhbitski.database.DataRetriever;
import org.verzhbitski.data.Data;
import org.verzhbitski.data.Note;

import java.io.IOException;

public class MainWindowController {
    @FXML
    private TableColumn tcDate;

    @FXML
    private TableColumn tcTime;

    @FXML
    private TableColumn tcNote;

    @FXML
    private TableView<Note> table;

    public void initialize() {
        tcNote.prefWidthProperty().bind(
                table.widthProperty()
                        .subtract(tcTime.widthProperty())
                        .subtract(tcDate.widthProperty())
                        .subtract(2)
        );
        table.setItems(Data.data);
        new DataRetriever().run();
    }

    public void newNote() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewNote.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("New note");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 500, 275));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
