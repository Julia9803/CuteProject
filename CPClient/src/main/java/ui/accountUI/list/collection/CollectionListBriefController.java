package ui.accountUI.list.collection;

import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListBriefController;

public class CollectionListBriefController extends CollectionAndPaymentListBriefController{


	@Override
	public void init(){
		cpLookController = new CollectionListWinLookController();
		super.init();
	}
	
	

}
