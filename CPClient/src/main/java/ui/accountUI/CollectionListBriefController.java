package ui.accountUI;

import java.io.IOException;

import VO.accountVO.CollectionListVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ui.commonUI.ListWinController;

public class CollectionListBriefController extends ListWinController{

	@FXML Label VIPName;
	@FXML Label totalAmount;
	@FXML Label listState;
	
	CollectionListVO collectionListVO;

	@Override
	public void init() {
		listID.setText(collectionListVO.getId());
		

		operator.setText(collectionListVO.getOperator());
		VIPName.setText(collectionListVO.getVIPName());
		totalAmount.setText(String.valueOf(collectionListVO.getTotalAmount()));
		listState.setText(collectionListVO.getState().toString());
		
	}
	
	public void setCollectionListVO(CollectionListVO vo){
		collectionListVO = vo;
	}

	@FXML public void onOpenListBtnClicked() {
		CollectionListWinLookController controller = new CollectionListWinLookController();
		controller.setCollectionListVO(collectionListVO);
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	try {
	    			new CollectionListWin(controller);
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        }
	   });
		
	}

}
