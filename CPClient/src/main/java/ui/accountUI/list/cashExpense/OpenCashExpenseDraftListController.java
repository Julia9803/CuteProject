package ui.accountUI.list.cashExpense;

import java.io.IOException;
import java.util.List;

import VO.accountVO.CashExpenseListVO;
import javafx.fxml.FXMLLoader;
import ui.accountUI.list.finance.OpenFinanceDraftListController;
import ui.mainUI.accountantUI.AccountantWinController;

public class OpenCashExpenseDraftListController extends OpenFinanceDraftListController{

	List<CashExpenseListVO> CashExpenseLists;
	
	public OpenCashExpenseDraftListController(AccountantWinController controller){
		accountantWinController = controller;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		setTitle("现金费用草稿单");
		CashExpenseLists = (List<CashExpenseListVO>) financeListService.openDraft();
		if(CashExpenseLists == null || CashExpenseLists.size() == 0){
			this.searchTextField.setPromptText("没有现金费用草稿单");
		}
		 for(CashExpenseListVO vo :CashExpenseLists){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/CashExpenseListBriefDraft.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			CashExpenseListBriefDraftController briefDraftController = loader.getController();
			briefDraftController.setVO(vo);
			briefDraftController.setAccountantWinController(accountantWinController);
			briefDraftController.init();
			
			vBox.getChildren().add(loader.getRoot());

		 }
		
	}
	
	
	@Override
	public void onSearchBtnClicked() {
		//TODO
//		String input = searchTextField.getText();
	}

	
	

}
