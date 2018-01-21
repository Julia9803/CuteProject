package ui.accountUI.list.collectionAndPayment;

import VO.accountVO.CollectionListVO;
import ui.commonUI.ListWinController;
import ui.mainUI.accountantUI.AccountantWinController;

public class CollectionAndPaymentListBriefDraftController extends ListWinController{

	protected AccountantWinController accountantWinController;
	
	protected CollectionListVO vo;

	@Override
	public void init() {
		setListID(vo.getId());
		setOperator(vo.getOperator());
		
	}
	
	public void setVO(CollectionListVO vo){
		this.vo = vo;
	}
	
	public void setAccountantWinController(AccountantWinController  accountantWinController){
		this.accountantWinController =  accountantWinController;
	}	
}
