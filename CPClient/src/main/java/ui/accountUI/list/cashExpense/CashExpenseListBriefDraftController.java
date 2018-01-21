package ui.accountUI.list.cashExpense;

import VO.accountVO.CashExpenseListVO;
import javafx.fxml.FXML;
import ui.commonUI.ListWinController;
import ui.mainUI.accountantUI.AccountantWinController;

public class CashExpenseListBriefDraftController extends ListWinController{

	AccountantWinController accountantWinController;
	
	CashExpenseListVO vo;

	@Override
	public void init() {
		setListID(vo.getId());
		setOperator(vo.getOperator());
		
	}
	
	public void setVO(CashExpenseListVO vo){
		this.vo = vo;
	}
	
	public void setAccountantWinController(AccountantWinController  accountantWinController){
		this.accountantWinController =  accountantWinController;
	}

	@FXML public void onOpenListBtnClicked() {
		accountantWinController.loadCashExpenseDraftList(vo);
	}

}
