module id.dojo.hospitalboard {
    requires javafx.controls;
    requires javafx.fxml;


    opens id.dojo.hospitalboard to javafx.fxml;
    exports id.dojo.hospitalboard;
}