package ui.accountUI.list.collection;

import javafx.fxml.FXML;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListBriefDraftController;

public class CollectionListBriefDraftController extends CollectionAndPaymentListBriefDraftController{


	@FXML public void onOpenListBtnClicked() {
		accountantWinController.loadCollectionDraftList(vo);
	}

}
