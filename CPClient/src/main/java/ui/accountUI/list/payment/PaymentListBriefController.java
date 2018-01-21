package ui.accountUI.list.payment;

import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListBriefController;

public class PaymentListBriefController extends CollectionAndPaymentListBriefController{


	@Override
	public void init(){
		cpLookController = new PaymentListWinLookController();
		super.init();
	}
	
	

}
