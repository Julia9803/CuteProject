package ui.stockmanUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NoticeWin extends Stage{
	@FXML
	AnchorPane root;
	public NoticeWin() throws IOException{
		root = FXMLLoader.load(getClass().getResource("/fxml/stockmanUI/Notice.fxml"));
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("/css/stockmanUI/Stock.css").toExternalForm());
		scene.setFill(Color.TRANSPARENT);
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
	}
}