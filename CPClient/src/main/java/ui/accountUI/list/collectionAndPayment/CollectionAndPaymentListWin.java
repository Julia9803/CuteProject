package ui.accountUI.list.collectionAndPayment;

import java.io.IOException;

import blservice.serviceFactory.AccountBLFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CollectionAndPaymentListWin extends Stage{
	@FXML
	AnchorPane root;
	public CollectionAndPaymentListWin(CollectionAndPaymentListWinController controller) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/CollectionList.fxml"));
		loader.setController(controller);
		controller.setService(AccountBLFactory.getCollectionListService());
		root = loader.load();
		controller.init();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/forms/Forms.css").toExternalForm());
		scene.setFill(Color.TRANSPARENT);
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
	}
}
