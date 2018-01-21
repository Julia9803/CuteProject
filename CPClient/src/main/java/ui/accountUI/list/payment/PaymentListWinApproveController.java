package ui.accountUI.list.payment;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXML;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListWinApproveController;

public class PaymentListWinApproveController extends CollectionAndPaymentListWinApproveController{

	public PaymentListWinApproveController(CollectionListVO vo) {
		super(vo);
	}
	
	@FXML
	public void initialize(){
		titleLabel.setText("付款单");
	}
	
}
