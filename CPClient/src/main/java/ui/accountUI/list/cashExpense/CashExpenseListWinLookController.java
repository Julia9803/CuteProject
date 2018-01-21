package ui.accountUI.list.cashExpense;

import VO.accountVO.CashExpenseListVO;
import VO.accountVO.EntryItemVO;
import javafx.application.Platform;

public class CashExpenseListWinLookController extends CashExpenseListWinController{
	private CashExpenseListVO cashExpenseListVO;

	@Override
	public void init(){
		
		operator.setText(cashExpenseListVO.getOperator());
		listID.setText(cashExpenseListVO.getId());
		totalAmount.setText(String.valueOf(cashExpenseListVO.getTotalAmount()));
		for(EntryItemVO item : cashExpenseListVO.getEntryItem()){
			entryItem.add(new EntryItem(item));
		}
		entryNameLabel.setVisible(false);
		entryNameTextField.setVisible(false);
		addEntryBtn.setVisible(false);
		super.initTableView();
		EntryListTableView.setEditable(false);
		AccountComboBox.setValue(cashExpenseListVO.getAccount());
		AccountComboBox.setDisable(true);	
		commitBtn.setText("关闭");
		saveBtn.setVisible(false);
		closeBtn.setVisible(false);
		
	}

	public void setCashExpenseListVO(CashExpenseListVO cashExpenseListVO) {
		this.cashExpenseListVO = cashExpenseListVO;
	}
	
	
	@Override
	public void onCommitBtnClicked() {
		 Platform.runLater(()-> {
             try {
                 root.getScene().getWindow().hide();
             } catch (Exception e) {
                 e.printStackTrace();
             }
     });
		
	}
	
	
}
