package ui.mainUI.administratorUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdministratorWin extends Stage{
	@FXML
	AnchorPane root;
	public AdministratorWin() throws IOException{
		root = FXMLLoader.load(getClass().getResource("/fxml/mainUI/Administrator.fxml"));
		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
	}
	
}