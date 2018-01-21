package ui.accountUI.list.payment;

import javafx.fxml.FXML;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListWinLookController;

public class PaymentListWinLookController extends CollectionAndPaymentListWinLookController{

	@FXML
	public void initialize(){
		titleLabel.setText("付款单");
	}
	
	
}
