package ui.accountUI.list.cashExpense;

import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Collectors;

import VO.accountVO.CashExpenseListVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import ui.accountUI.list.finance.FinanceListWinController;
import ui.commonUI.PromptWin;
import util.State;

public class CashExpenseListWinController  extends FinanceListWinController{
	
	@FXML AnchorPane root;
	
	CashExpenseListVO vo = null;

	@FXML Label entryNameLabel;
	@FXML TextField entryNameTextField;
	@FXML Button addEntryBtn;
	
	@FXML TableView<EntryItem> EntryListTableView;
	@FXML TableColumn<EntryItem,String> entryName;
	@FXML TableColumn<EntryItem,String> amount;
	@FXML TableColumn<EntryItem,String> note;
	@FXML TableColumn<EntryItem,String> deleted;
	final ObservableList<EntryItem> entryItem = FXCollections.observableArrayList();
	
	public CashExpenseListWinController(){}
	public CashExpenseListWinController(CashExpenseListVO vo){this.vo = vo;}
	
	@Override
	public void init() {
		if(vo != null){
			entryItem.addAll(vo.getEntryItem()
							.stream()
							.map(e->new EntryItem(e.getEntryName(),e.getAmount(),e.getNote()))
							.collect(Collectors.toList()));
			setListID(vo.getId());
			setOperator(vo.getOperator());
			AccountComboBox.setValue(vo.getAccount());
			totalAmount.setText(String.valueOf(vo.getTotalAmount()));

		}
		
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
			        	EntryItem item = t.getTableView().getItems().get(t.getTablePosition().getRow());
			        	String newAmount = t.getNewValue();
			        	try{
			        		Double.parseDouble(newAmount);
			        	}catch (NumberFormatException e){
							prompt("金额必须为数字");
							return ;
							
			        		
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
		            EntryItem item = t.getTableView().getItems().get(t.getTablePosition().getRow());
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
			        	EntryItem item = t.getTableView().getItems().get(t.getTablePosition().getRow());
				        double total = Double.parseDouble(totalAmount.getText()) - Double.parseDouble(item.getAmount());
				        totalAmount.setText(String.valueOf(total));
			            entryItem.remove(item);
			        }
			    }
			);
	}
	
	@FXML 
	public void onSaveBtnClicked() {		
		saveList();
	}


	@FXML 
	public void onCommitBtnClicked() {		
		String account = AccountComboBox.getValue();
		if(account == null || account.equals("")){
			prompt("请选择银行账户");
			return;
			
		}
		if(entryItem.isEmpty()){
			prompt("条目清单是不能为空的");
			return;
		}
		
		commitList();
	}
	

	@Override
	protected CashExpenseListVO createListVO(State state){
		return new CashExpenseListVO(
				listID.getText(),
				operator.getText(),
				null,
				state,
				AccountComboBox.getValue(),
				entryItem.stream().map(e -> e.toVO()).collect(Collectors.toList()),		
				Double.parseDouble(totalAmount.getText())
				);
	}
	
}
