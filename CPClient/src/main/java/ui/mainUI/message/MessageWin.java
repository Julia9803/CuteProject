package ui.mainUI.message;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MessageWin extends Stage{
	@FXML
	AnchorPane root;
	public MessageWin() throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainUI/MessageList.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
	}
}
