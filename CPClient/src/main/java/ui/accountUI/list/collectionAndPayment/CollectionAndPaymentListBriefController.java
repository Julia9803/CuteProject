package ui.accountUI.list.collectionAndPayment;

import java.io.IOException;

import VO.accountVO.CollectionListVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ui.commonUI.ListWinController;

public class CollectionAndPaymentListBriefController extends ListWinController{

	@FXML Label VIPName;
	@FXML Label totalAmount;
	@FXML Label listState;
	
	CollectionListVO collectionListVO;
	protected CollectionAndPaymentListWinLookController cpLookController;

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
		cpLookController.setCollectionListVO(collectionListVO);
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	try {
	    			new CollectionAndPaymentListWin(cpLookController);
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        }
	   });
		
	}
}
