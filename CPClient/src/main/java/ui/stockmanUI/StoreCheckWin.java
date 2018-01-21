package ui.stockmanUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StoreCheckWin extends Stage {
    @FXML
    AnchorPane root;

    StoreCheckController controller;
    public StoreCheckWin() throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/fxml/stockmanUI/StoreCheck.fxml"));
        root =loader.load();
        this.controller=loader.getController();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/stockmanUI/Stock.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);
        this.setScene(scene);
        this.initStyle(StageStyle.UNDECORATED);
        this.show();
    }
}
