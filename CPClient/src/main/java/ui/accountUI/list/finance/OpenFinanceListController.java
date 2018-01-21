package ui.accountUI.list.finance;

import blservice.accountblservice.FinanceListService;
import ui.commonUI.OpenListWinController;

public abstract class OpenFinanceListController extends OpenListWinController{
	protected FinanceListService financeListService;
	
	public void setService(FinanceListService FListService){
		financeListService = FListService;
	}
	
}
