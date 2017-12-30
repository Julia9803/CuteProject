package ui.accountUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VO.accountVO.AccountVO;
import blservice.accountblservice.FinanceListService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import ui.commonUI.ListWinController;
import ui.commonUI.PromptWin;

public abstract class FinanceListWinController extends ListWinController{
	
	@FXML protected Label accountLabel;
	@FXML protected ComboBox<String> AccountComboBox;
	protected List<String> accountList = new ArrayList<String>();


	@FXML protected Label totalAmount;

	@FXML protected Button closeBtn;
	@FXML protected Button saveBtn;
	@FXML protected Button commitBtn;
	
	protected FinanceListService financeListService;
	
	public void setService(FinanceListService FListService){
		financeListService = FListService;
	}
	
	@Override
	public void init(){
		initComboBox();
	}
	
	protected void initComboBox(){
		List<AccountVO> accountvo = financeListService.findAccount();
		for(AccountVO vo :accountvo){
			accountList.add(vo.getAccountName());
		}
		AccountComboBox.getItems().addAll(accountList);
		
	}
	
	protected void prompt(String promptText) throws IOException{
		new PromptWin(promptText);
	}
	
	@FXML
	public void onCloseBtnClicked(){
		parentController.CloseSonWin();
	}
	
}

