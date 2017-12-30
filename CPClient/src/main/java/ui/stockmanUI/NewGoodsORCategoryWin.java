package ui.stockmanUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class NewGoodsORCategoryWin extends Stage {
    @FXML
    AnchorPane root;
    public NewGoodsORCategoryWin() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/stockmanUI/NewGoodsORCategory.fxml"));
        Scene scene = new Scene(root,600,400);
        scene.getStylesheets().add(getClass().getResource("/css/stockmanUI/Stock.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);
        this.setScene(scene);
        this.initStyle(StageStyle.UNDECORATED);
        this.show();
    }
}
