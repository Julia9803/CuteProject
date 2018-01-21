package ui.accountUI.list.cashExpense;

import java.io.IOException;

import VO.accountVO.CashExpenseListVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ui.commonUI.ListWinController;

public class CashExpenseListBriefController extends ListWinController{

	@FXML Label accountNameLabel;
	@FXML Label totalAmount;
	@FXML Label listState;
	
	CashExpenseListVO vo;

	@Override
	public void init() {
		listID.setText(vo.getId());
		operator.setText(vo.getOperator());
		accountNameLabel.setText(vo.getAccount());
		totalAmount.setText(String.valueOf(vo.getTotalAmount()));
		listState.setText(vo.getState().toString());
		
	}
	
	public void setCashExpenseListVO(CashExpenseListVO vo){
		this.vo = vo;
	}

	@FXML public void onOpenListBtnClicked() {
		CashExpenseListWinLookController controller = new CashExpenseListWinLookController();
		controller.setCashExpenseListVO(vo);
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	try {
	    			new CashExpenseListWin(controller);
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        }
	   });
		
	}

}
