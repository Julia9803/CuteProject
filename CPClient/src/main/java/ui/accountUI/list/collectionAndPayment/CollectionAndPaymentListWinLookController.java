package ui.accountUI.list.collectionAndPayment;

import VO.accountVO.CollectionListVO;
import VO.accountVO.TransferItemVO;
import javafx.application.Platform;

public class CollectionAndPaymentListWinLookController extends CollectionAndPaymentListWinController{

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
		TransferListTableView.setEditable(false);
		AccountComboBox.setVisible(false);
		commitBtn.setText("关闭");
		saveBtn.setVisible(false);
		closeBtn.setVisible(false);
		
		
	}

	public void setCollectionListVO(CollectionListVO vo) {
		this.vo = vo;
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
