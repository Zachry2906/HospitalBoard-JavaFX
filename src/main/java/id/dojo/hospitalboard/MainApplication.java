package id.dojo.hospitalboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    double x,y = 0;
    Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-board.fxml"));
        stage.setScene(new Scene(root));

        root.setOnMousePressed(evt->{
            x = evt.getSceneX();
            y = evt.getSceneY();
        });
        root.setOnMouseDragged(evt->{
            stage.setX(evt.getScreenX() - x);
            stage.setY(evt.getScreenY() - y);
        });
        stage.show();
        primaryStage = stage;
    }

    public Stage getStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}