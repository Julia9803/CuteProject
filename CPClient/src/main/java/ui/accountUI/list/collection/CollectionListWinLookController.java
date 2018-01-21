package ui.accountUI.list.collection;

import javafx.fxml.FXML;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListWinLookController;

public class CollectionListWinLookController extends CollectionAndPaymentListWinLookController{

	@FXML
	public void initialize(){
		titleLabel.setText("收款单");
	}
	
	
}
