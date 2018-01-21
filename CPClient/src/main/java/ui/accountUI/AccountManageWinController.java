package ui.accountUI;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import VO.accountVO.AccountVO;
import blservice.accountblservice.AccountManagementService;
import blservice.serviceFactory.AccountBLFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import ui.commonUI.ParentController;
import ui.commonUI.PromptWin;
import ui.commonUI.SonController;

public class AccountManageWinController implements SonController{

	@FXML AnchorPane root;
	
	@FXML TextField newAccountNameTextField;
	@FXML TextField newAccountBalanceTextField;
	@FXML Button addAccountBtn;

	@FXML TableView<AccountItem> accountListTableView;
	@FXML TableColumn<AccountItem,String> account;
	@FXML TableColumn<AccountItem,String> balance;
	@FXML TableColumn<AccountItem,String> deleted;
	final ObservableList<AccountItem> accountItem = FXCollections.observableArrayList();
	
	@FXML Button saveBtn;
	@FXML Button closeBtn;
	
	ParentController parentController;
	AccountManagementService service = AccountBLFactory.getAccountManagementService();
	List<AccountVO> accountList;
	
	
	public void init(){
		accountList = service.getAllAccount();
		accountItem.addAll(accountList.stream()
									.map(e -> new AccountItem(e.getAccountName(),e.getBalance()))
									.collect(Collectors.toList()));
		initTableView();
	}
	
	protected void initTableView(){
		
		initAccountTableColumn();
		initBalanceTableColumn();
		initDeleteTableColumn();
		
		accountListTableView.setItems(accountItem);
	    accountListTableView.setEditable(true);
	
	}
	
	private void initAccountTableColumn(){
		account.setCellValueFactory(new PropertyValueFactory<AccountItem, String>("accountName"));
	}
	
	private void initBalanceTableColumn(){
		balance.setCellValueFactory(new PropertyValueFactory<AccountItem, String>("balance"));
		balance.setCellFactory(TextFieldTableCell.forTableColumn());
		balance.setOnEditCommit(
			    new EventHandler<CellEditEvent<AccountItem, String>>() {
			        @Override
			        public void handle(CellEditEvent<AccountItem, String> t) {
			        	AccountItem item = t.getTableView().getItems().get(t.getTablePosition().getRow());
			        	String newBalance = t.getNewValue();
			        	double b = 0;
			        	try{
			        		b = Double.parseDouble(newBalance);
			        	}catch (NumberFormatException e){
							prompt("余额必须为数字！");
							return ;
			        	}
			        	if(b < 0){
			        		prompt("余额不能为负！");
							return ;
			        	}
				        item.setBalance(newBalance);	
			        }
			    }
			);
	}
	
	
	
	private void initDeleteTableColumn(){
		deleted.setCellValueFactory(new PropertyValueFactory<AccountItem, String>("deleted"));
		deleted.setCellFactory(TextFieldTableCell.forTableColumn());
		deleted.setOnEditStart(
			    new EventHandler<CellEditEvent<AccountItem, String>>() {
			        @Override
			        public void handle(CellEditEvent<AccountItem, String> t) {
			        	AccountItem item = t.getTableView().getItems().get(t.getTablePosition().getRow());
			        	if(Double.parseDouble(item.getBalance())!=0){
			        		prompt("账户余额不为0！");
			        		return;
			        	}
			            accountItem.remove(item);
			        }
			    }
			);
	}
	
	
	@FXML public void onAddAccountBtnClicked() {
		String name = newAccountNameTextField.getText();
		String balance = newAccountBalanceTextField.getText();
		for(AccountItem item : accountItem){
			if(item.getAccountName().equals(name)){
				prompt("账户已存在");
				newAccountNameTextField.setText("");
				newAccountBalanceTextField.setText("");
				return;
			}
		}
		double b = 0;
    	try{
    		b = Double.parseDouble(balance);
    	}catch (NumberFormatException e){
			prompt("余额必须为数字！");
			newAccountBalanceTextField.setText("");
			return ;
    	}
    	if(b < 0){
    		prompt("余额不能为负！");
    		newAccountBalanceTextField.setText("");
			return ;
    	}
    	
    	newAccountNameTextField.setText("");
		newAccountBalanceTextField.setText("");
    	accountItem.add(new AccountItem(name,balance));
		
	}
	
	@FXML public void onSaveBtnClicked() {
		System.out.println("insave");
		System.out.println(accountItem.size());
		service.saveAllAccount(accountItem.stream().map(e -> e.toVO()).collect(Collectors.toList()));
		prompt("保存成功！");
	}
	
	@FXML public void onCloseBtnClicked() {
		parentController.CloseSonWin();
	}
	
	
	@Override
	public void setParentController(ParentController controller) {
		this.parentController = controller;
	}

	protected void prompt(String promptText){
		try {
			new PromptWin(promptText);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
