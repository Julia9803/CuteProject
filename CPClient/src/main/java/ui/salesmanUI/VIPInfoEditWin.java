package ui.salesmanUI;

/**
 * Created by julia98 on 2017/12/22.
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class VIPInfoEditWin extends Stage {
    @FXML
    AnchorPane root;
    public String vip;

    public VIPInfoEditWin(String vip) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/salesmanUI/VIPInfoEdit.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/stockmanUI/Stock.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);
        //VIPInfoEditController vipInfoEditController = new VIPInfoEditController();
        //vipInfoEditController.init(vip);

        this.setScene(scene);
        this.initStyle(StageStyle.DECORATED);
        this.show();
    }
}