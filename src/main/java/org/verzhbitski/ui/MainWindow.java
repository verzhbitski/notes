package org.verzhbitski.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Notes");
        primaryStage.setScene(new Scene(root, 850, 450));
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
