package ui.accountUI.list.collection;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXML;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListWinApproveController;

public class CollectionListWinApproveController extends CollectionAndPaymentListWinApproveController{

	public CollectionListWinApproveController(CollectionListVO vo) {
		super(vo);
	}
	
	@FXML
	public void initialize(){
		titleLabel.setText("收款单");
	}
	
}
