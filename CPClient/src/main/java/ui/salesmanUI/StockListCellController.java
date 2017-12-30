package ui.salesmanUI;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import bl.salebl.SaleBLFactory;
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
import ui.managerUI.PresentForMembershipController;
import ui.managerUI.PresentForMembershipEditStrategy;
import ui.managerUI.Strategy;
import util.UserGrade;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class StockListCellController {

	StockListViewController controller;
	SalesmanListVO vo;
	String id;
	
	List<SalesmanItemVO> chosenList;
	
	@FXML protected Label listID;
	@FXML protected Label operator;
	
	@FXML protected Label totalAmount;
	
	@FXML protected Label VIPID;
	@FXML protected Label VIPName;
	
	@FXML protected TextField notesTextField;
	
	@FXML protected Button selectVIPBtn;
	@FXML protected TextField selectVIPField;
	
	@FXML protected Button selectGoodsBtn;
	@FXML protected TextField selectGoodsField;
	
	@FXML protected VBox goodsListVBox;
	
	protected static final String cellUrl = "/fxml/salesmanUI/TabelItemNoEdit.fxml";
	
	/**
	 * @param stockListViewController
	 * @param vo
	 */
	public StockListCellController(StockListViewController stockListViewController, SalesmanListVO vo) {
		this.controller = stockListViewController;
		this.vo = vo;
		this.id = vo.getId();	
	}
	

@FXML
	void initialize(){
		listID.setText(id);
		operator.setText(vo.getOperator());
		
		totalAmount.setText(vo.getSum()+"");
		VIPID.setText(vo.getMemberID());
		VIPName.setText(vo.getMemberName());
		notesTextField.setText(vo.getNotes());
		
		chosenList = vo.getSaleListItems();
		this.refresh();
	}
	@FXML void delete(){
		if(showConfirmDialog())
			controller.deleteFromList(vo);
		
	}
	
	@FXML void edit(){
		Platform.runLater(()->{
		try {
   		 StockEditListController controller = 
   				    new StockEditListController(this.controller,SaleBLFactory.getStockListBLService(),vo.getId(),vo);
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
	
	public void refresh() {
			goodsListVBox.getChildren().clear();
			for(SalesmanItemVO vo : chosenList){
	   		 StockTypeNoEditCellController controller = 
	   				    new StockTypeNoEditCellController(this,vo);
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
			// TODO Auto-generated catch block
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
}
