package ui.stockmanUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//库存类单据通用，包括库存报溢单、报损单、报警单、赠送单
public class StoreListWin extends Stage{
	@FXML
    AnchorPane root;
	
	StoreListController controller;
    public StoreListWin() throws IOException {
    	FXMLLoader loader =new FXMLLoader(getClass().getResource("/fxml/stockmanUI/StoreList.fxml"));
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
