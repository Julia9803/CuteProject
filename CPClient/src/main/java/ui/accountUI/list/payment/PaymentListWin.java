package ui.accountUI.list.payment;

import java.io.IOException;

import VO.accountVO.CollectionListVO;
import blservice.serviceFactory.AccountBLFactory;
import ui.accountUI.list.collection.CollectionListWinController;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListWin;

public class PaymentListWin{
	
	public PaymentListWin(CollectionListWinController controller) throws IOException{
		new CollectionAndPaymentListWin(controller);
	}
	
	public PaymentListWin(String listId) throws IOException{
		CollectionListVO vo = (CollectionListVO) AccountBLFactory.getPaymentListService().getList(listId);
		PaymentListWinApproveController controller = new PaymentListWinApproveController(vo);
		new CollectionAndPaymentListWin(controller);
	}
}
