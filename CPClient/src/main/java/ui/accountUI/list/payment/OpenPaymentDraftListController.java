package ui.accountUI.list.payment;

import java.io.IOException;
import java.util.List;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXMLLoader;
import ui.accountUI.list.finance.OpenFinanceDraftListController;
import ui.mainUI.accountantUI.AccountantWinController;

public class OpenPaymentDraftListController extends OpenFinanceDraftListController{

	List<CollectionListVO> PaymentLists;
	
	public OpenPaymentDraftListController(AccountantWinController controller){
		accountantWinController = controller;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		setTitle("付款草稿单");
		PaymentLists = (List<CollectionListVO>) financeListService.openDraft();
		if(PaymentLists == null || PaymentLists.size() == 0){
			this.searchTextField.setPromptText("没有付款草稿单");
		}
		 for(CollectionListVO vo :PaymentLists){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/PaymentListBriefDraft.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			PaymentListBriefDraftController briefDraftController = loader.getController();
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
