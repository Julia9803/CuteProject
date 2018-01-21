package ui.commonUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LookListWin extends Stage {
    //单据的查看与审批通用的界面
    @FXML
    AnchorPane root;

    LookListController controller;
    public LookListWin() throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/fxml/commonUI/LookList.fxml"));
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
