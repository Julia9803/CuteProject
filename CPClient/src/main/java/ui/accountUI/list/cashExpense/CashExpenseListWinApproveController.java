package ui.accountUI.list.cashExpense;

import VO.accountVO.CashExpenseListVO;
import VO.accountVO.EntryItemVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import resultmessage.ApproveRM;
import util.State;

public class CashExpenseListWinApproveController extends CashExpenseListWinController{
	
	public CashExpenseListWinApproveController(CashExpenseListVO vo){
		super(vo);
	}
	
	@Override
	public void init(){
		
		operator.setText(vo.getOperator());
		listID.setText(vo.getId());
		totalAmount.setText(String.valueOf(vo.getTotalAmount()));
		for(EntryItemVO item : vo.getEntryItem()){
			entryItem.add(new EntryItem(item));
		}
		entryNameLabel.setVisible(false);
		entryNameTextField.setVisible(false);
		addEntryBtn.setVisible(false);
		super.initTableView();
		AccountComboBox.setValue(vo.getAccount());
		AccountComboBox.setDisable(true);	
	
		commitBtn.setText("通过");
		saveBtn.setText("拒绝");		
		
	}
	
	@FXML
	@Override
	public void onCloseBtnClicked() {
		 Platform.runLater(()-> {
            try {
                root.getScene().getWindow().hide();
            } catch (Exception e) {
                e.printStackTrace();
            }
		 });
	}
	
	@FXML
	@Override
	public void onSaveBtnClicked() {
		vo = this.createListVO(State.IsRefused);
		this.financeListService.reject(vo);
		prompt("操作成功！");
		onCloseBtnClicked();
	}
	
	@FXML
	@Override
	public void onCommitBtnClicked() {
		vo = this.createListVO(State.IsCommitted);
		ApproveRM rm = this.financeListService.approve(vo);
		switch(rm){
		case NETWORK_ERROR:
			prompt("网络异常！");
			break;
		case SERVER_ERROR:
			prompt("服务器异常！");
			break;
		case VIP_EXCEPTION:
			prompt("客户数据异常！");
			break;
		case OK:
			prompt("操作成功！");
			onCloseBtnClicked();
			break;
		default:
			prompt("未知错误！");
			break;
		}
	}
}
