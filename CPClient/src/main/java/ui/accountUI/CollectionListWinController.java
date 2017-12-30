package ui.accountUI;

import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Collectors;

import VO.accountVO.CollectionListVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import resultmessage.CommitListRM;
import resultmessage.SaveListRM;
import ui.commonUI.PromptWin;
import ui.mainUI.loginUI.User;
import util.State;

public class CollectionListWinController extends FinanceListWinController{
	
	
	@FXML
	AnchorPane root;

	@FXML Label VIPName;
	@FXML Label VIPID;
	@FXML Button selectVIPBtn;
	
	@FXML TableView<TransferItem> TransferListTableView;
	@FXML TableColumn<TransferItem,String> account;
	@FXML TableColumn<TransferItem,String> amount;
	@FXML TableColumn<TransferItem,String> note;
	@FXML TableColumn<TransferItem,String> deleted;
	final ObservableList<TransferItem> transferItem = FXCollections.observableArrayList();


	
	public void init(){
		super.init();
		initTableView();

	}

	
	protected void initTableView(){
		
		initAccountTableColumn();
		initAmountTableColumn();
		initNoteTableColumn();
		initDeleteTableColumn();
		
		TransferListTableView.setItems(transferItem);
	    TransferListTableView.setEditable(true);
		
	    //TODO 测试用，以后删掉
//	    transferItem.add(new TransferItem("1 ", 100,"dv"));
//	    transferItem.add(new TransferItem("老张", 100,"dv"));
//	    transferItem.add(new TransferItem("我 ", 100,"dv"));


	}
	
	private void initAccountTableColumn(){
		//account不可在TableView中修改
		account.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("account"));
	}
	
	private void initAmountTableColumn(){
		amount.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("amount"));
		amount.setCellFactory(TextFieldTableCell.forTableColumn());
		amount.setOnEditCommit(
			    new EventHandler<CellEditEvent<TransferItem, String>>() {
			        @Override
			        public void handle(CellEditEvent<TransferItem, String> t) {
			        	TransferItem item = (TransferItem) t.getTableView().getItems().get(t.getTablePosition().getRow());
			        	String newAmount = t.getNewValue();
			        	try{
			        		Double.parseDouble(newAmount);
			        	}catch (NumberFormatException e){
			        		try {
								prompt("金额必须为数字");
								return ;
							} catch (IOException e1) {
								e1.printStackTrace();
								return;
							}
			        		
			        	}
			        	
				        item.setAmount(newAmount);	
			            double total = transferItem.stream()
			            						   .map(e -> Double.parseDouble(e.getAmount()))
			            						   .reduce(0.0, (a,b)->a+b);			//真的爽(其实从效率上讲不见得比用iterator好)
			            totalAmount.setText(String.valueOf(total));
			        }
			    }
			);
	}
	
	private void initNoteTableColumn(){
		note.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("note"));
		note.setCellFactory(TextFieldTableCell.forTableColumn());
		note.setOnEditCommit(
		    new EventHandler<CellEditEvent<TransferItem, String>>() {
		        @Override
		        public void handle(CellEditEvent<TransferItem, String> t) {
		            TransferItem item = (TransferItem) t.getTableView().getItems().get(t.getTablePosition().getRow());
		            item.setNote(t.getNewValue());	
		        }
		    }
		);
	}
	
	private void initDeleteTableColumn(){
		deleted.setCellValueFactory(new PropertyValueFactory<TransferItem, String>("deleted"));
		deleted.setCellFactory(TextFieldTableCell.forTableColumn());
		deleted.setOnEditStart(
			    new EventHandler<CellEditEvent<TransferItem, String>>() {
			        @Override
			        public void handle(CellEditEvent<TransferItem, String> t) {
			        	TransferItem item = (TransferItem) t.getTableView().getItems().get(t.getTablePosition().getRow());
				        double total = Double.parseDouble(totalAmount.getText()) - Double.parseDouble(item.getAmount());
				        totalAmount.setText(String.valueOf(total));
			            transferItem.remove(item);
			        }
			    }
			);
	}
	

	
	@FXML 
	public  void OnAccountSelected() {		//TODO 不知道为什么这个方法每次点都会掉用4次(2次可以理解)。不过不影响功能，只是会产生outofboundException
		String newAccount = AccountComboBox.getValue();
		System.out.println("new:"+newAccount+"end");
		if(newAccount == null || newAccount.equals("")) return;
		System.out.println("in");
		AccountComboBox.setValue("");
		Iterator<TransferItem> iterator = transferItem.iterator();
		while(iterator.hasNext()){
			int i = 1;
			TransferItem item = iterator.next();
			if(item.getAccount().equals(newAccount)){	//此账户已经选择过了
				try {
					new PromptWin("此账户已经选择过啦");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			System.out.println(i++);

		}
		transferItem.add(new TransferItem(newAccount,0,""));
		System.out.println(transferItem.size());
	}
	
	
	
	

	@FXML 
	public void onSaveBtnClicked() {		//不同单据保存的前置条件可能不同，故不放在父类中
		
		CollectionListVO vo = createListVO(State.IsDraft);
		
		SaveListRM saverm = financeListService.save(vo);
		switch(saverm){
		case SUCCESS:
			try {
				new PromptWin("保存成功！");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}


	@FXML 
	public void onCommitBtnClicked() {		//不同单据提交的前置条件不同，故不放在父类中
		if(transferItem.isEmpty()){
			try {
				prompt("转账列表是不能为空的");
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
				
			}
		}
		CollectionListVO vo = createListVO(State.IsCommitted);
		CommitListRM commitrm = financeListService.commit(vo);
		switch(commitrm){
		case SUCCESS:
			try {
				prompt("提交成功！");
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{		//提示窗虽然加载不出来，不过提交已经成功了，就应该关闭了
				parentController.CloseSonWin();		
			}
			break;
		default:
			System.out.println(commitrm);
		}
	}
	

	protected CollectionListVO createListVO(State state){
		return new CollectionListVO(
				listID.getText(),
				"00007",//VIPID.getText(),
				"me",//VIPName.getText(),
				User.getInstance().getUserName(),
				User.getInstance().getId(),
				transferItem.stream().map(e -> e.toVO()).collect(Collectors.toList()),		
				Double.parseDouble(totalAmount.getText()),
				state
				);
	}
	
	
}


