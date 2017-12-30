package ui.stockmanUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by julia98 on 2017/12/11.
 */
public class GoodsInfoEditWin extends Stage {
    @FXML AnchorPane root;
    public String goods;

    public GoodsInfoEditWin(String goods) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/stockmanUI/GoodsInfoEdit.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/stockmanUI/Stock.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);
        this.goods = goods;
        System.out.println("GoodsInfoEditWin：" + goods);
/*
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "GoodsInfoEdit.fxml"
                )
        );

        GoodsInfoEditController controller = loader.getController();
        controller.init(goods);
*/
        //GoodsInfoEditController goodsInfoEditController = new GoodsInfoEditController();
        //goodsInfoEditController.init(goods);
        this.setScene(scene);
        this.initStyle(StageStyle.DECORATED);
        this.show();
    }
}
