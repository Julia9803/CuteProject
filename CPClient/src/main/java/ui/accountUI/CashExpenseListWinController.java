package ui.accountUI;

import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Collectors;

import VO.accountVO.CashExpenseListVO;
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
import resultmessage.CommitListRM;
import resultmessage.SaveListRM;
import ui.commonUI.PromptWin;
import ui.mainUI.loginUI.User;
import util.State;

public class CashExpenseListWinController  extends FinanceListWinController{

	@FXML TextField entryNameTextField;
	@FXML Button addEntryBtn;
	
	@FXML TableView<EntryItem> EntryListTableView;
	@FXML TableColumn<EntryItem,String> entryName;
	@FXML TableColumn<EntryItem,String> amount;
	@FXML TableColumn<EntryItem,String> note;
	@FXML TableColumn<EntryItem,String> deleted;
	final ObservableList<EntryItem> entryItem = FXCollections.observableArrayList();
	
	
	@Override
	public void init() {
		super.init();
		initTableView();
	}

	@FXML
	public void onAddEntryBtnClicked(){
		String text = entryNameTextField.getText();
		if(text == null || text.equals(""))
			return;
		entryNameTextField.setText("");
		Iterator<EntryItem> iterator = entryItem.iterator();
		while(iterator.hasNext()){
			EntryItem item = iterator.next();
			if(item.getEntryName().equals(text)){
				try {
					new PromptWin("此条目已经有啦");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
		}
		entryItem.add(new EntryItem(text,0,""));
	}
	
	protected void initTableView(){
		
		initEntryNameTableColumn();
		initAmountTableColumn();
		initNoteTableColumn();
		initDeleteTableColumn();
		
		EntryListTableView.setItems(entryItem);
	    EntryListTableView.setEditable(true);
		
	    //TODO 测试用，以后删掉
//	    entryItem.add(new EntryItem("1 ", 100,"dv"));
//	    entryItem.add(new EntryItem("老张", 100,"dv"));
//	    entryItem.add(new EntryItem("我 ", 100,"dv"));


	}
	
	private void initEntryNameTableColumn(){
		//entryName不可在TableView中修改
		entryName.setCellValueFactory(new PropertyValueFactory<EntryItem, String>("entryName"));
	}
	
	private void initAmountTableColumn(){
		amount.setCellValueFactory(new PropertyValueFactory<EntryItem, String>("amount"));
		amount.setCellFactory(TextFieldTableCell.forTableColumn());
		amount.setOnEditCommit(
			    new EventHandler<CellEditEvent<EntryItem, String>>() {
			        @Override
			        public void handle(CellEditEvent<EntryItem, String> t) {
			        	EntryItem item = (EntryItem) t.getTableView().getItems().get(t.getTablePosition().getRow());
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
			            double total = entryItem.stream()
			            						   .map(e -> Double.parseDouble(e.getAmount()))
			            						   .reduce(0.0, (a,b)->a+b);		
			            totalAmount.setText(String.valueOf(total));
			        }
			    }
			);
	}
	
	private void initNoteTableColumn(){
		note.setCellValueFactory(new PropertyValueFactory<EntryItem, String>("note"));
		note.setCellFactory(TextFieldTableCell.forTableColumn());
		note.setOnEditCommit(
		    new EventHandler<CellEditEvent<EntryItem, String>>() {
		        @Override
		        public void handle(CellEditEvent<EntryItem, String> t) {
		            EntryItem item = (EntryItem) t.getTableView().getItems().get(t.getTablePosition().getRow());
		            item.setNote(t.getNewValue());	
		        }
		    }
		);
	}
	
	private void initDeleteTableColumn(){
		deleted.setCellValueFactory(new PropertyValueFactory<EntryItem, String>("deleted"));
		deleted.setCellFactory(TextFieldTableCell.forTableColumn());
		deleted.setOnEditStart(
			    new EventHandler<CellEditEvent<EntryItem, String>>() {
			        @Override
			        public void handle(CellEditEvent<EntryItem, String> t) {
			        	EntryItem item = (EntryItem) t.getTableView().getItems().get(t.getTablePosition().getRow());
				        double total = Double.parseDouble(totalAmount.getText()) - Double.parseDouble(item.getAmount());
				        totalAmount.setText(String.valueOf(total));
			            entryItem.remove(item);
			        }
			    }
			);
	}
	
	@FXML 
	public void onSaveBtnClicked() {		//不同单据保存的前置条件可能不同，故不放在父类中
		
		CashExpenseListVO vo = createListVO(State.IsDraft);
		
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
		String account = AccountComboBox.getValue();
		if(account == null || account.equals("")){
			try {
				prompt("请选择银行账户");
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		if(entryItem.isEmpty()){
			try {
				prompt("条目清单是不能为空的");
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		
		CashExpenseListVO vo = createListVO(State.IsCommitted);
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
	

	protected CashExpenseListVO createListVO(State state){
		return new CashExpenseListVO(
				listID.getText(),
				User.getInstance().getUserName(),
				User.getInstance().getId(),
				state,
				AccountComboBox.getValue(),
				entryItem.stream().map(e -> e.toVO()).collect(Collectors.toList()),		
				Double.parseDouble(totalAmount.getText())
				);
	}
	
}
