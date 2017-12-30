package ui.mainUI.accountantUI;

import java.io.IOException;

import blservice.accountblservice.FinanceListService;
import blservice.serviceFactory.AccountBLFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import ui.accountUI.CashExpenseListWinController;
import ui.accountUI.CollectionListWinController;
import ui.accountUI.FinanceListWinController;
import ui.accountUI.OpenCollectionCommitedListController;
import ui.accountUI.OpenFinanceListController;
import ui.accountUI.PaymentListWinController;
import ui.commonUI.ParentController;
import ui.mainUI.loginUI.User;

public class AccountantWinController implements ParentController{
	
	@FXML AnchorPane root;

	
	@FXML MenuItem newCollectionList;
	@FXML MenuItem newPaymentList;
	@FXML MenuItem newCashExpenseList;
	@FXML MenuItem openCollectionCommitted;
	@FXML MenuItem openPaymentCommitted;
	@FXML MenuItem openCashExpenseCommitted;
	@FXML MenuItem openCollectionDraft;
	@FXML MenuItem openPaymentDraft;
	@FXML MenuItem openCashExpenseDraft;
	
	@FXML BorderPane centerPane;
	
	
	private static final String OPEN_LIST_OF_FORM_FXML =  "/fxml/commonUI/OpenListOfForms.fxml";
	private static final String COLLECTION_LIST_FXML = "/fxml/accountUI/CollectionList.fxml";
	private static final String PAYMENT_LIST_FXML = "/fxml/accountUI/PaymentList.fxml";
	private static final String CASH_EXPENSE_LIST_FXML = "/fxml/accountUI/CashExpenseList.fxml";
	

	@FXML public void onNewCollectionListBtnClicked() {
		loadNewList(AccountBLFactory.getCollectionListService(),new CollectionListWinController(),COLLECTION_LIST_FXML);
	}




	@FXML public void onNewPaymentListBtnClicked() {
		loadNewList(AccountBLFactory.getPaymentListService(),new PaymentListWinController(),PAYMENT_LIST_FXML);
	}



	@FXML public void onNewCashExpenseListBtnClicked() {
		loadNewList(AccountBLFactory.getCashExpenseListService(),new CashExpenseListWinController(),CASH_EXPENSE_LIST_FXML);
	}




	@FXML public void onOpenCollectionCommittedBtnClicked() {
		loadOpenList(AccountBLFactory.getCollectionListService(),new OpenCollectionCommitedListController());
		
	}




	@FXML public void onOpenPaymentCommittedBtnClicked() {
		//TODO
	}




	@FXML public void onOpenCashExpenseCommittedBtnClicked() {
		//TODO
	}




	@FXML public void onOpenCollectionDraftBtnClicked() {
		//TODO
	}




	@FXML public void onOpenPaymentDraftBtnClicked() {
		//TODO
	}




	@FXML public void onOpenCashExpenseDraftBtnClicked() {
		//TODO
	}




	@Override
	public void CloseSonWin() {
		centerPane.setCenter(null);
//		centerPane.getChildren().removeAll();		
	}
	
	
	
	private void loadNewList(FinanceListService financeListService,FinanceListWinController ListWinController, String fxmlPath){
		String id = financeListService.newList();
		if(id == null){
			//TODO 提示网络异常，请稍后再试的界面
			return;
		}
		if(id == global.ListGlobalVariables.LIST_FULL){
			//TODO 提示单据已满的界面
			return;
		}
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

			loader.setController(ListWinController);
			loader.load();
			
			ListWinController.setParentController(this);
			ListWinController.setListID(id);
			ListWinController.setOperator(User.getInstance().getUserName());
			ListWinController.setService(financeListService);
			ListWinController.init();

			AnchorPane ListRoot;
			ListRoot = loader.getRoot();
			
			centerPane.setCenter(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadOpenList(FinanceListService financeListService,OpenFinanceListController openfinanceListController){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(OPEN_LIST_OF_FORM_FXML));
			loader.setController(openfinanceListController);
			loader.load();

			openfinanceListController.setParentController(this);
			openfinanceListController.setService(financeListService);
			openfinanceListController.init();
			
			AnchorPane ListRoot = loader.getRoot();
			
			centerPane.getChildren().removeAll();
			centerPane.getChildren().add(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
