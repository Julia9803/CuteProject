package ui.accountUI.list.payment;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXML;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListWinController;

public class PaymentListWinController extends CollectionAndPaymentListWinController{
	
	
	public PaymentListWinController(){}
	public PaymentListWinController(CollectionListVO vo){super(vo);}

	@FXML
	public void initialize(){
		titleLabel.setText("付款单");
	}

}


