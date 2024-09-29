package id.dojo.hospitalboard;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class JadwalOperasiController {

    @FXML
    private BorderPane jadwalOperasiBorderPane;
//    @FXML
//    private AnchorPane jadwalAnchor;

    private MainApplication mainApplication;
    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }
}
