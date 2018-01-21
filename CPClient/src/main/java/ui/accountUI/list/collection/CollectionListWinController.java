package ui.accountUI.list.collection;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXML;
import ui.accountUI.list.collectionAndPayment.CollectionAndPaymentListWinController;

public class CollectionListWinController extends CollectionAndPaymentListWinController{
	
	
	public CollectionListWinController(){}
	public CollectionListWinController(CollectionListVO vo){super(vo);}

	@FXML
	public void initialize(){
		titleLabel.setText("收款单");
	}

}


