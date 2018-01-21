package ui.salesmanUI.deprecated;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SaleWin extends Stage{
	@FXML
	AnchorPane root;
	public SaleWin() throws IOException{
		root = FXMLLoader.load(getClass().getResource("/fxml/salesmanUI/Sale.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/salesmanUI/Sale.css").toExternalForm());
		scene.setFill(Color.TRANSPARENT);
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
	}
}