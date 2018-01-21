package ui.accountUI.list.collectionAndPayment;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import VO.VIPVO.VIPVO;
import VO.accountVO.CollectionListVO;
import blservice.VIPblservice.VIPFuzzySearch;
import blservice.serviceFactory.VIPSearcherFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import ui.commonUI.VIPSearchResultWin;
import ui.commonUI.VIPSearcher;
import util.State;

public class CollectionAndPaymentListWinController extends FinanceListWinController{
	@FXML
	AnchorPane root;
	
	CollectionListVO vo = null;

	@FXML Label VIPName;
	@FXML Label VIPID;
	@FXML TextField searchVIPTextField;
	@FXML Button searchVIPBtn;
	boolean VIPSelected = false;
	VIPFuzzySearch vipSearchService = VIPSearcherFactory.getVIPFuzzySearchService(); 
	
	@FXML TableView<TransferItem> TransferListTableView;
	@FXML TableColumn<TransferItem,String> account;
	@FXML TableColumn<TransferItem,String> amount;
	@FXML TableColumn<TransferItem,String> note;
	@FXML TableColumn<TransferItem,String> deleted;
	final ObservableList<TransferItem> transferItem = FXCollections.observableArrayList();

	public CollectionAndPaymentListWinController(){}
	public CollectionAndPaymentListWinController(CollectionListVO vo){this.vo = vo;}
	
	@Override
	public void init(){
		if(vo != null){
			transferItem.addAll(vo.getTransferItem()
								.stream()
								.map(e->new TransferItem(e.getAccount(),e.getAmount(),e.getNote()))
								.collect(Collectors.toList()));
			setListID(vo.getId());
			setOperator(vo.getOperator());
			if(vo.getVIPName()!= null && !vo.getVIPName().equals("")){
				VIPName.setText(vo.getVIPName());
				VIPID.setText(vo.getVIPID());
				VIPSelected = true;
			}
			
			totalAmount.setText(String.valueOf(vo.getTotalAmount()));
		}
		
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
			        	TransferItem item = t.getTableView().getItems().get(t.getTablePosition().getRow());
			        	String newAmount = t.getNewValue();
			        	try{
			        		Double.parseDouble(newAmount);
			        	}catch (NumberFormatException e){
							prompt("金额必须为数字");
							return ;
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
		            TransferItem item = t.getTableView().getItems().get(t.getTablePosition().getRow());
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
			        	TransferItem item = t.getTableView().getItems().get(t.getTablePosition().getRow());
				        double total = Double.parseDouble(totalAmount.getText()) - Double.parseDouble(item.getAmount());
				        totalAmount.setText(String.valueOf(total));
			            transferItem.remove(item);
			        }
			    }
			);
	}
	
//	protected void initComboBox(){		//此方法也没有用
//		super.initComboBox();
//		AccountComboBox.valueProperty().addListener(new ChangeListener<String>() {
//            @Override public void changed(ObservableValue ov, String oldValue, String newAccount) {                
//        		if(newAccount == null || newAccount.equals("")) return;
//        		AccountComboBox.setValue("");
//        		Iterator<TransferItem> iterator = transferItem.iterator();
//        		while(iterator.hasNext()){
//        			TransferItem item = iterator.next();
//        			if(item.getAccount().equals(newAccount)){	//此账户已经选择过了
//        				try {
//        					new PromptWin("此账户已经选择过啦");
//        				} catch (IOException e) {
//        					e.printStackTrace();
//        				}
//        				return;
//        			}
//
//        		}
//        		transferItem.add(new TransferItem(newAccount,0,""));
//            }    
//        });
//	}

	
	@FXML
	public void onSearchVIPBtnClicked(){
		String keyword = searchVIPTextField.getText();
		if(keyword == null){		
			prompt("请输入会员的关键字！");
			return;
		}
		List<VIPVO> vipList = new ArrayList<VIPVO>();
		try {
			vipList = getVIP(keyword);
		} catch (RemoteException e) {
			e.printStackTrace();
			prompt("网络异常，请稍后再试！");
			return;
		}
		if(vipList == null || vipList.size() == 0){
			prompt("没有符合条件的会员信息！");
			return;
		}
		try {
			new VIPSearchResultWin(vipList,new VIPSearcher(){
				@Override
				public void VIPSelected(VIPVO vipvo) {
					VIPName.setText(vipvo.getName());
					VIPID.setText(vipvo.getId());
					VIPSelected = true;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private List<VIPVO> getVIP(String keyword) throws RemoteException{
		List<VIPVO> vipList = new ArrayList<VIPVO>();
		List<VIPVO> temp = null;
		temp = vipSearchService.getVIPInID(keyword);
		if(temp != null)
			vipList.addAll(temp);
		temp = vipSearchService.getVIPInName(keyword);
		if(temp != null)
			vipList.addAll(temp);
		temp = vipSearchService.getVIPInType(keyword);
		if(temp != null)
			vipList.addAll(temp);
		vipList = new ArrayList<VIPVO>(new HashSet<VIPVO>(vipList));
		return vipList;
	}
	
	@FXML 
	public  void OnAccountSelected(ActionEvent event) {		//不知道为什么这个方法每次点都会掉用4次(2次可以理解)。不过不影响功能，只是会产生outofboundException

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
//				prompt("此账户已经选择过啦");				//重复触发事件的问题没有解决，那就不提示了，感觉不出来
				return;
			}
			System.out.println(i++);

		}
		transferItem.add(new TransferItem(newAccount,0,""));
		System.out.println(transferItem.size());
	}
	
	
	
	

	@FXML 
	public void onSaveBtnClicked() {		
		
		saveList();
	}


	@FXML 
	public void onCommitBtnClicked() {		//可以加一些提交单据的前置条件
		if(VIPSelected == false){
			prompt("请选择会员！");
			return;
		}
		if(transferItem.isEmpty()){
			prompt("转账列表是不能为空的");
			return;
		}
		commitList();
	}
	
	@Override
	protected CollectionListVO createListVO(State state){
		return new CollectionListVO(
				listID.getText(),
				VIPID.getText(),
				VIPName.getText(),
				operator.getText(),
				null,				//操作员编号，弃用了
				transferItem.stream().map(e -> e.toVO()).collect(Collectors.toList()),		
				Double.parseDouble(totalAmount.getText()),
				state
				);
	}
}
