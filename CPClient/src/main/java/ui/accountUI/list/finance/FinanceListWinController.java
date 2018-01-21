package ui.accountUI.list.finance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VO.accountVO.AccountVO;
import VO.accountVO.FinanceListVO;
import blservice.accountblservice.FinanceListService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import resultmessage.CommitListRM;
import resultmessage.SaveListRM;
import ui.commonUI.ListWinController;
import ui.commonUI.PromptWin;
import util.State;

public abstract class FinanceListWinController extends ListWinController{
	
	@FXML
	protected Label titleLabel;
	
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
	
	protected void prompt(String promptText){
		try {
			new PromptWin(promptText);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onCloseBtnClicked(){
		financeListService.endService();
		parentController.CloseSonWin();
	}	
	
	protected void saveList(){
		FinanceListVO vo = createListVO(State.IsDraft);
		
		SaveListRM saverm = financeListService.save(vo);
		switch(saverm){
		case SUCCESS:
			try {
				new PromptWin("保存成功！");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case NETWORK_ERROR:
			try {
				new PromptWin("网络异常，保存失败");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case SERVER_ERROR:
			try {
				new PromptWin("服务器异常，保存失败");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	protected void commitList(){
		FinanceListVO vo = createListVO(State.IsCommitted);
		CommitListRM commitrm = financeListService.commit(vo);
		switch(commitrm){
		case SUCCESS:
			prompt("提交成功！");
			parentController.CloseSonWin();		
			break;
		case NETWORK_ERROR:
			prompt("网络异常，提交失败");
			break;
		case SERVER_ERROR:
			prompt("服务器异常，提交失败");
			break;
		
		}
	}
	
	protected abstract FinanceListVO createListVO(State state);

}

