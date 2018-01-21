package ui.accountUI.list.collection;

import java.io.IOException;

import VO.accountVO.CollectionListVO;
import blservice.serviceFactory.AccountBLFactory;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListWin;

public class CollectionListWin {
	
	public CollectionListWin(CollectionListWinController controller) throws IOException{
		new CollectionAndPaymentListWin(controller);
	}
	
	public CollectionListWin(String listId) throws IOException{
		CollectionListVO vo = (CollectionListVO) AccountBLFactory.getCollectionListService().getList(listId);
		CollectionListWinApproveController controller = new CollectionListWinApproveController(vo);
		new CollectionAndPaymentListWin(controller);
	}
}
