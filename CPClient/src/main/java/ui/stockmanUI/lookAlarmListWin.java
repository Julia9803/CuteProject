package ui.stockmanUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class lookAlarmListWin extends Stage {
    @FXML
    AnchorPane root;

    public lookAlarmListWin() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/stockmanUI/lookAlarmList.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/stockmanUI/Stock.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);


        this.setScene(scene);
        this.initStyle(StageStyle.DECORATED);
        this.show();
    }
}
