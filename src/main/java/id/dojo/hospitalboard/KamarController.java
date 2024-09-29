package id.dojo.hospitalboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class KamarController implements Initializable {
    @FXML
    private BorderPane kamarBorederPane;
    @FXML
    private VBox backKamar;

    @FXML
    private Button bDetailKamar;

    static String type= "Kamar";

    private MainApplication mainApplication;
    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backKamar = (VBox) kamarBorederPane.getCenter();
        bDetailKamar.setOnAction(event -> {
            pageDetailKamar();
            if (type.equals("Kamar")) {
                type = "Detail";
                bDetailKamar.setText("Kembali");
            } else {
                pageBacklKamar();
                type = "Kamar";
                bDetailKamar.setText("Detail");
            }
        });
    }


    public void pageDetailKamar() {
        kamarBorederPane.setCenter(null);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("detail-kamar.fxml"));
        Node node = null;
        try {
            node = loader.load();
            kamarBorederPane.setCenter(node);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void pageBacklKamar() {
        kamarBorederPane.setCenter(backKamar);
    }
}
