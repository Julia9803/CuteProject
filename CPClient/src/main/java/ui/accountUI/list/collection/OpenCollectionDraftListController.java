package ui.accountUI.list.collection;

import java.io.IOException;
import java.util.List;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXMLLoader;
import ui.accountUI.list.finance.OpenFinanceDraftListController;
import ui.mainUI.accountantUI.AccountantWinController;

public class OpenCollectionDraftListController extends OpenFinanceDraftListController{

	List<CollectionListVO> CollectionLists;
	
	public OpenCollectionDraftListController(AccountantWinController controller){
		accountantWinController = controller;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		setTitle("收款草稿单");
		CollectionLists = (List<CollectionListVO>) financeListService.openDraft();
		if(CollectionLists == null || CollectionLists.size() == 0){
			this.searchTextField.setPromptText("没有收款草稿单");
		}
		 for(CollectionListVO vo :CollectionLists){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/CollectionListBriefDraft.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			CollectionListBriefDraftController briefDraftController = loader.getController();
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
