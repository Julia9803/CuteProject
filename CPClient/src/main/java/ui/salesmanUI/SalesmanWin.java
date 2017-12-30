package ui.salesmanUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SalesmanWin extends Stage{
	@FXML AnchorPane root;
	
	public SalesmanWin() throws IOException{
		root = FXMLLoader.load(getClass().getResource("/fxml/salesmanUI/Salesman.fxml"));

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/managerUI/Manager.css").toExternalForm());
		scene.setFill(Color.TRANSPARENT);
	
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		
		this.setFullScreen(true);
		this.show();
	}
	
}
