package ui.accountUI.list.payment;

import javafx.fxml.FXML;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListBriefDraftController;

public class PaymentListBriefDraftController extends CollectionAndPaymentListBriefDraftController{


	@FXML public void onOpenListBtnClicked() {
		accountantWinController.loadPaymentDraftList(vo);
	}

}
