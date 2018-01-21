package ui.mainUI.accountantUI;

import java.io.IOException;

import VO.accountVO.CashExpenseListVO;
import VO.accountVO.CollectionListVO;
import blservice.accountblservice.FinanceListService;
import blservice.serviceFactory.AccountBLFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import ui.accountUI.AccountManageWinController;
import ui.accountUI.list.cashExpense.CashExpenseListWinController;
import ui.accountUI.list.cashExpense.OpenCashExpenseCommitedListController;
import ui.accountUI.list.cashExpense.OpenCashExpenseDraftListController;
import ui.accountUI.list.collection.CollectionListWinController;
import ui.accountUI.list.collection.OpenCollectionCommitedListController;
import ui.accountUI.list.collection.OpenCollectionDraftListController;
import ui.accountUI.list.finance.FinanceListWinController;
import ui.accountUI.list.finance.OpenFinanceListController;
import ui.accountUI.list.payment.OpenPaymentCommitedListController;
import ui.accountUI.list.payment.OpenPaymentDraftListController;
import ui.accountUI.list.payment.PaymentListWinController;
import ui.commonUI.LookListController;
import ui.commonUI.ParentController;
import ui.commonUI.PromptWin;
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
	@FXML Button looklistbtn;
	
	@FXML BorderPane centerPane;
	
	
	private static final String OPEN_LIST_OF_FORM_FXML =  "/fxml/commonUI/OpenListOfForms.fxml";
	private static final String COLLECTION_LIST_FXML = "/fxml/accountUI/CollectionList.fxml";
	private static final String PAYMENT_LIST_FXML = "/fxml/accountUI/CollectionList.fxml";
	private static final String CASH_EXPENSE_LIST_FXML = "/fxml/accountUI/CashExpenseList.fxml";
	private static final String ACCOUNT_MANAGE_FXML = "/fxml/accountUI/AccountManage.fxml";

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
		loadOpenList(AccountBLFactory.getPaymentListService(),new OpenPaymentCommitedListController());
	}




	@FXML public void onOpenCashExpenseCommittedBtnClicked() {
		loadOpenList(AccountBLFactory.getCashExpenseListService(),new OpenCashExpenseCommitedListController());
	}




	@FXML public void onOpenCollectionDraftBtnClicked() {
		loadOpenList(AccountBLFactory.getCollectionListService(), new OpenCollectionDraftListController(this));
	}




	@FXML public void onOpenPaymentDraftBtnClicked() {
		loadOpenList(AccountBLFactory.getPaymentListService(), new OpenPaymentDraftListController(this));	
	}

	


	@FXML public void onOpenCashExpenseDraftBtnClicked() {
		loadOpenList(AccountBLFactory.getCashExpenseListService(), new OpenCashExpenseDraftListController(this));
	}

	@FXML public void onAccountManageBtnClicked(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(ACCOUNT_MANAGE_FXML));
			loader.load();
			AccountManageWinController controller = loader.getController();
			controller.setParentController(this);
			controller.init();

			AnchorPane ListRoot = loader.getRoot();
			
			this.CloseSonWin();
			centerPane.setCenter(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void CloseSonWin() {
		centerPane.setCenter(null);
		centerPane.getChildren().removeAll();		
	}
	
	@FXML public void looklist(){
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource(
						"/fxml/commonUI/LookList.fxml"));
		try {
			AnchorPane presentroot = loader.load();
			centerPane.getChildren().clear();
			centerPane.setCenter(presentroot);
			LookListController ctr=loader.getController();
			ctr.set(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void loadNewList(FinanceListService financeListService,FinanceListWinController financeListWinController, String fxmlPath){
		String id = financeListService.newList();
		if(id == null){
			try {
				new PromptWin("网络异常，请稍后再试！");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		if(id == global.ListGlobalVariables.LIST_FULL){
			try {
				new PromptWin("今日该类单据已满，请明天再来～");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

			loader.setController(financeListWinController);
			loader.load();
			
			financeListWinController.setParentController(this);
			financeListWinController.setService(financeListService);
			financeListWinController.setListID(id);
			financeListWinController.setOperator(User.getInstance().getUserName());
			financeListWinController.init();

			AnchorPane ListRoot = loader.getRoot();
			
			this.CloseSonWin();
			centerPane.setCenter(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void loadOpenList(FinanceListService financeListService,OpenFinanceListController openfinanceListController){
		try {		//此处和下面的loadEditableList方法纯属雷同，无任何设计不合理之处
			FXMLLoader loader = new FXMLLoader(getClass().getResource(OPEN_LIST_OF_FORM_FXML));
			
			loader.setController(openfinanceListController);
			loader.load();

			openfinanceListController.setParentController(this);
			openfinanceListController.setService(financeListService);
			openfinanceListController.init();
			
			AnchorPane ListRoot = loader.getRoot();
			
			this.CloseSonWin();
			centerPane.setCenter(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadCollectionDraftList(CollectionListVO vo){
		FinanceListWinController financeListWinController = new CollectionListWinController(vo);
		String fxmlPath = COLLECTION_LIST_FXML;
		FinanceListService financeListService= AccountBLFactory.getCollectionListService();
		
		loadEditableList(financeListWinController,financeListService,fxmlPath);
		
	}
	
	public void loadPaymentDraftList(CollectionListVO vo){
		FinanceListWinController financeListWinController = new PaymentListWinController(vo);
		String fxmlPath = PAYMENT_LIST_FXML;
		FinanceListService financeListService= AccountBLFactory.getPaymentListService();
		
		loadEditableList(financeListWinController,financeListService,fxmlPath);
		
	}
	
	public void loadCashExpenseDraftList(CashExpenseListVO vo){
		FinanceListWinController financeListWinController = new CashExpenseListWinController(vo);
		String fxmlPath = CASH_EXPENSE_LIST_FXML;
		FinanceListService financeListService= AccountBLFactory.getCashExpenseListService();
		loadEditableList(financeListWinController,financeListService,fxmlPath);
		
	}
	
	private void loadEditableList(FinanceListWinController financeListWinController, FinanceListService financeListService, String fxmlPath){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

			loader.setController(financeListWinController);
			loader.load();
			
			financeListWinController.setParentController(this);
			financeListWinController.setService(financeListService);
			financeListWinController.init();

			AnchorPane ListRoot = loader.getRoot();
			
			this.CloseSonWin();
			centerPane.setCenter(ListRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
