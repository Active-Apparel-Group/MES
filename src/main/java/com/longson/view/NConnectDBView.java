package com.longson.view;

import javafx.scene.control.Alert;

public class NConnectDBView {

    public static void inforDialog() {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }
}
