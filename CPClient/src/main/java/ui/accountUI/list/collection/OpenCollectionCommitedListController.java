package ui.accountUI.list.collection;

import java.io.IOException;
import java.util.List;

import VO.accountVO.CollectionListVO;
import javafx.fxml.FXMLLoader;
import ui.accountUI.list.finance.OpenFinanceListController;

public class OpenCollectionCommitedListController extends OpenFinanceListController{

	List<CollectionListVO> CollectionLists;
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		setTitle("收款单");
		CollectionLists = (List<CollectionListVO>) financeListService.openCommitted();
		if(CollectionLists == null || CollectionLists.size() == 0){
			this.searchTextField.setPromptText("没有已提交的收款单");
		}
		 for(CollectionListVO vo :CollectionLists){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/CollectionListBrief.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			CollectionListBriefController briefController = loader.getController();
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
