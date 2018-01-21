package ui.accountUI.list.collectionAndPayment;

import VO.accountVO.CollectionListVO;
import VO.accountVO.TransferItemVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import resultmessage.ApproveRM;
import util.State;

public class CollectionAndPaymentListWinApproveController extends CollectionAndPaymentListWinController{
	public CollectionAndPaymentListWinApproveController(CollectionListVO vo){
		super(vo);
	}
	
	@Override
	public void init(){
		VIPName.setText(vo.getVIPName());
		VIPID.setText(vo.getVIPID());
		searchVIPTextField.setVisible(false);
		searchVIPBtn.setVisible(false);
		operator.setText(vo.getOperator());
		listID.setText(vo.getId());
		totalAmount.setText(String.valueOf(vo.getTotalAmount()));
		for(TransferItemVO item : vo.getTransferItem()){
			transferItem.add(new TransferItem(item));
		}
		super.initTableView();
		AccountComboBox.setVisible(false);
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
