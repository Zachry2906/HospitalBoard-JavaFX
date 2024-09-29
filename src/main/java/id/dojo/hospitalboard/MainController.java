package id.dojo.hospitalboard;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    private MainApplication mainApplication;
    @FXML
    private Label welcomeText;
    @FXML
    private BorderPane outerBorderPane;
    @FXML
    private BorderPane innerBorderPane;
    @FXML
    private Button bHome;
    @FXML    private Button bJadwalDokter;
    @FXML
    private Button bKamarTersedia;
    @FXML
    private Button bJadwalOperasi;
    @FXML
    private Button bAntrian;
    @FXML
    private Button bKritiknSaran;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InvalidationListener resizeComponentView = new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                // TODO Auto-generated method stub
//                resizeComponent();
                System.out.println("ResizeComponentView");
            }
        };

        outerBorderPane.heightProperty().addListener(resizeComponentView);
        outerBorderPane.widthProperty().addListener(resizeComponentView);
//        this.mainApplication.getStage().setFullScreen(true);


        try {
            bKamarTersedia.setOnAction(e -> {
                resetColorNavbar();
                bKamarTersedia.setStyle("-fx-background-color:   #D6AE19");
                pageKamar();
            });
            bHome.setOnAction(e -> {
                resetColorNavbar();
                bHome.setStyle("-fx-background-color:   #D6AE19");
                pageHome();
            });
            bJadwalOperasi.setOnAction(e -> {
                resetColorNavbar();
                bJadwalOperasi.setStyle("-fx-background-color:   #D6AE19");
                pageOperasi();
            });
            bKritiknSaran.setOnAction(e -> {
                resetColorNavbar();
                bKritiknSaran.setStyle("-fx-background-color:   #D6AE19");
                pageSaran();
            });

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("home.fxml"));
            Node node = loader.load();
            innerBorderPane.setCenter(node);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void pageKamar() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("kamar-satu.fxml"));
        Node node = null;
        try {
            node = loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        animation(node);
    }

    public void pageHome() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("home.fxml"));
        Node node = null;
        try {
            node = loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        animation(node);
    }

    public void pageOperasi() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("jadwal-operasi2.fxml"));
        Node node = null;
        try {
            node = loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        animation(node);
    }

    public void pageSaran() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("saran.fxml"));
        Node node = null;
        try {
            node = loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        animation(node);
    }

    public void resetColorNavbar(){
        bKamarTersedia.setStyle("-fx-background-color:  #163D82");
        bHome.setStyle("-fx-background-color:  #163D82");
        bJadwalOperasi.setStyle("-fx-background-color:  #163D82");
        bKritiknSaran.setStyle("-fx-background-color:  #163D82");
        bAntrian.setStyle("-fx-background-color:  #163D82");
        bJadwalDokter.setStyle("-fx-background-color:  #163D82");
    }

    public void animation(Node node){
        // Fade out animation
        Timeline fadeOut = new Timeline();
        KeyValue kvOut = new KeyValue(innerBorderPane.opacityProperty(), 0);
        KeyFrame kfOut = new KeyFrame(Duration.millis(350), kvOut);
        fadeOut.getKeyFrames().add(kfOut);

        Timeline fadeIn = new Timeline();
        KeyValue kvIn = new KeyValue(innerBorderPane.opacityProperty(), 1);
        KeyFrame kfIn = new KeyFrame(Duration.millis(350), kvIn);
        fadeIn.getKeyFrames().add(kfIn);

        Node finalNode = node;
        fadeOut.setOnFinished(event -> {
            innerBorderPane.setCenter(null);
            innerBorderPane.setCenter(finalNode);
            fadeIn.play();
        });

        fadeOut.play();
    }
}