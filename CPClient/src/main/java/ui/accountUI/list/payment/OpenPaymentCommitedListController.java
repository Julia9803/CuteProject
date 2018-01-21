package ui.accountUI.list.payment;

import java.io.IOException;
import java.util.List;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXMLLoader;
import ui.accountUI.list.finance.OpenFinanceListController;

public class OpenPaymentCommitedListController extends OpenFinanceListController{

	List<CollectionListVO> PaymentLists;
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		setTitle("付款单");
		PaymentLists = (List<CollectionListVO>) financeListService.openCommitted();
		if(PaymentLists == null || PaymentLists.size() == 0){
			this.searchTextField.setPromptText("没有已提交的付款单");
		}
		 for(CollectionListVO vo :PaymentLists){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/PaymentListBrief.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			PaymentListBriefController briefController = loader.getController();
			briefController.setCollectionListVO(vo);
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
