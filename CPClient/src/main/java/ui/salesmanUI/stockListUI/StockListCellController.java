package ui.salesmanUI.stockListUI;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import bl.salebl.SaleBLFactory;
import blservice.saleblservice.SaleUniBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import resultmessage.DataRM;
import ui.commonUI.PromptHelper;
import ui.salesmanUI.CellController;
import ui.salesmanUI.ListViewController;
import ui.salesmanUI.NoEditCellController;
import ui.salesmanUI.stock.StockTypeEditListController;
import util.UserGrade;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class StockListCellController implements CellController {

	protected ListViewController controller;
	protected SalesmanListVO vo;
	protected String id;
	protected SaleUniBLService uniBLService;
	
	protected List<SalesmanItemVO> chosenList;
	
	@FXML protected AnchorPane root;
	
	@FXML protected Label listID;
	@FXML protected Label operator;
	@FXML protected String operatorId;
	@FXML protected UserGrade operatorGrade;
	
	@FXML protected Label totalAmount;
	
	@FXML protected Label VIPID;
	@FXML protected Label VIPName;
	
	@FXML protected TextField notesTextField;
	


	@FXML protected Button selectVIPBtn;
	@FXML protected TextField searchVIPField;

	@FXML protected Button selectGoodsBtn;
	@FXML protected TextField searchGoodsField;
	
	@FXML protected VBox goodsListVBox;
	
	@FXML protected Label nullErrorMessage;	
	@FXML protected Label numberErrorMessage;
	
	//编辑单据，跳转新页面
	@FXML protected Button saveBtn;
	//提交单据
	@FXML protected Button commitBtn;
	//删除单据
	@FXML protected Button cancelBtn;
	
	protected static final String cellUrl = "/fxml/salesmanUI/TableItem.fxml";
	
	/**
	 * @param stockListViewController
	 * @param vo
	 */
	public StockListCellController(ListViewController stockListViewController, SalesmanListVO vo) {
		this.controller = stockListViewController;
		this.vo = vo;
		this.id = vo.getId();
	//	this.uniBLService = service;
		this.uniBLService = SaleBLFactory.getStockListBLService();
	}
	

@FXML
protected
	void initialize(){
		listID.setText(id);
		operator.setText(vo.getOperator());
		
		totalAmount.setText(vo.getSum()+"");
		VIPID.setText(vo.getMemberID());
		VIPName.setText(vo.getMemberName());
		notesTextField.setText(vo.getNotes());
		
		chosenList = vo.getSaleListItems();
		
	
		notesTextField.setEditable(false);
		//将无用的控件set invisible
		selectVIPBtn.setVisible(false);
		searchVIPField.setVisible(false);
		selectGoodsBtn.setVisible(false);
		searchGoodsField.setVisible(false);

		//改变组件的名称
		saveBtn.setText("编辑");
		cancelBtn.setText("删除");
		this.refresh();
	}
	//空的方法
	@FXML 
	void selectGoods(){}
	@FXML
	void selectVIP(){}
	//删除
	@FXML void cancel(){
		if(showConfirmDialog()){
			uniBLService.delete(id);
			controller.deleteFromList(vo);
			System.out.println("delete");
		}
		
	}
	
	@FXML
	protected void commit(){
		
		DataRM rm = uniBLService.commit(getVOFromUI());	
		PromptHelper.showPrompt(rm);
		
	}
	//编辑
	@FXML
	protected void save(){
		this.controller.controller.CloseListToEdit();

		Platform.runLater(()->{
		try {
   		 StockTypeEditListController controller = generateEditList();
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/salesmanUI/StockTypeList.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = loader.load();
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForMembership.fxml"));
			this.controller.getController().centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}


	protected StockTypeEditListController generateEditList() {
		StockEditListController controller = 
   				    new StockEditListController(this.controller.controller,SaleBLFactory.getStockListBLService(),vo.getId(),vo);
		return controller;
	}
	
	public void refresh() {
			goodsListVBox.getChildren().clear();
			for(SalesmanItemVO vo : chosenList){
				NoEditCellController controller = 
	   				    new NoEditCellController(this,vo);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        cellUrl));
	   				loader.setController(controller);
	   				addChildrenForVBox(loader);
			}
		}	
	/**
	 * @param loader
	 */
	protected void addChildrenForVBox(FXMLLoader loader) {
		AnchorPane presentroot = null;
		try {
			presentroot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		goodsListVBox.getChildren().add(presentroot);
	}
	
	public boolean showConfirmDialog(){
		System.out.println("confirming");
		Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,"确认此项操作？");
	    Optional<ButtonType> result = confirmation.showAndWait();
	    if(result.isPresent() && result.get() == ButtonType.OK){
	        return true;
	     }
	    else{
	    	return false;
	     }
	}
	
	public SalesmanListVO getVOFromUI() {
		return new StockListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}

}
