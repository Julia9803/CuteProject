package ui.salesmanUI.vip;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by julia98 on 2017/12/22.
 */
public class VIPWin extends Stage {
    @FXML
    AnchorPane root;
    VIPWin vipWin;

    public VIPWin() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/salesmanUI/VIP.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/stockmanUI/Stock.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);

        this.setFullScreen(false);
        this.setScene(scene);
        this.initStyle(StageStyle.DECORATED);
        this.show();
        //new LoadingFXWin(vipWin);
    }
}