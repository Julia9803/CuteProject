package ui.accountUI.list.cashExpense;

import java.io.IOException;
import java.util.List;

import VO.accountVO.CashExpenseListVO;
import javafx.fxml.FXMLLoader;
import ui.accountUI.list.finance.OpenFinanceListController;

public class OpenCashExpenseCommitedListController extends OpenFinanceListController{

	List<CashExpenseListVO> CashExpenseLists;
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		setTitle("现金费用单");
		CashExpenseLists = (List<CashExpenseListVO>) financeListService.openCommitted();
		if(CashExpenseLists == null || CashExpenseLists.size() == 0){
			this.searchTextField.setPromptText("没有已提交的现金费用单");
		}
		 for(CashExpenseListVO vo :CashExpenseLists){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/CashExpenseListBrief.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			CashExpenseListBriefController briefController = loader.getController();
			briefController.setCashExpenseListVO(vo);
			briefController.init();
			
			vBox.getChildren().add(loader.getRoot());

		 }
		
	}
	
	
	@Override
	public void onSearchBtnClicked() {
		//TODO
//		String input = searchTextField.getText();
	}

	
	

}
