package ui.salesmanUI.saleListUI;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import resultmessage.DataRM;
import ui.commonUI.ConfirmHelper;
import ui.commonUI.PromptHelper;
import ui.managerUI.PresentNoEditCellController;
import ui.managerUI.SinglePresentController;
import ui.salesmanUI.CellController;
import ui.salesmanUI.ListViewController;
import ui.salesmanUI.NoEditCellController;
import ui.salesmanUI.sale.SaleTypeEditListController;
import util.UserGrade;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2018年1月1日
* @description
*/
public class SaleListCellController implements CellController,SinglePresentController{
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
	
	//销售类单据的组件
	@FXML protected HBox presentHBox;
	@FXML protected Button getPresentBtn;
	@FXML protected TextField useVoucherField;
	@FXML protected TextField rebateField;
	@FXML protected Label voucherInPresent;
	@FXML protected VBox presentListVBox;
	@FXML protected Label sumAfterRebateLabel;
	
	@FXML protected Label presentListTitle;
	@FXML protected Label strategyTitle;
	
	@FXML protected AnchorPane saleListPane;
	
	@FXML protected TextField clerk;
	protected VIPGrade grade;
	PresentResultVO presentResult;
	protected static final String cellUrl = "/fxml/salesmanUI/TableItem.fxml";
	
	/**
	 * @param stockListViewController
	 * @param vo
	 */
	public SaleListCellController(ListViewController stockListViewController, SalesmanListVO vo) {
		this.controller = stockListViewController;
		this.vo = vo;
		this.id = vo.getId();
		this.uniBLService = SaleBLFactory.getSaleListBLService();
	}

@FXML
	void initialize(){
		listID.setText(id);
		operator.setText(vo.getOperator());
		
		VIPID.setText(vo.getMemberID());
		VIPName.setText(vo.getMemberName());
		notesTextField.setText(vo.getNotes());
		
		chosenList = vo.getSaleListItems();
		clerk.setText(vo.getRealOperator());
		
		//销售单中特有的属性
		SaleListVO svo = (SaleListVO)vo;
		rebateField.setText(svo.getRebate()+"");
		useVoucherField.setText(svo.getVoucher()+"");
		System.out.println(svo.getSum()+" "+svo.getSumBeforeRebate());
		sumAfterRebateLabel.setText(svo.getSum()+"");
		totalAmount.setText(svo.getSumBeforeRebate()+"");
		
		
		//把textfield set
		notesTextField.setEditable(false);
		rebateField.setEditable(false);
		useVoucherField.setEditable(false);
		
		//将无用的控件set invisible
		selectVIPBtn.setVisible(false);
		searchVIPField.setVisible(false);
		selectGoodsBtn.setVisible(false);
		searchGoodsField.setVisible(false);
		
		getPresentBtn.setVisible(false);		

		//销售单特有部分
		clerk.setText(vo.getRealOperator());
		clerk.setEditable(false);
		grade = svo.getGrade();
		//策略部分
		presentResult = svo.getPresentResultVO();
		if(presentResult!=null){
		//显示金额
		voucherInPresent.setText(presentResult.getVoucher()+"");
		sumAfterRebateLabel.setText(presentResult.getSum()+"");
		//显示策略id
		
		List<Integer> presentId = presentResult.getPresentId();
		System.out.println(presentResult);
		if(presentId != null){
			for(Integer i : presentId){
			Button b = new Button(i+"");
			presentHBox.getChildren().add(b);
			System.out.println("presentID is" + i + "");
			}
		}
		//显示特价商品列表
		List<GoodsInSaleVO> presentList = presentResult.getPresentList();
		if(presentList!=null){
			setPresentList(presentList);
		}
		}
		//改变组件的名称
		saveBtn.setText("编辑");
		cancelBtn.setText("删除");
		this.refresh();
	}

@Override
public void setPresentList(List<GoodsInSaleVO> presentList) {
	presentListVBox.getChildren().clear();
	for(GoodsInSaleVO vo : presentList){
		 PresentNoEditCellController controller = 
				    new PresentNoEditCellController(this,vo);
		 FXMLLoader loader = new FXMLLoader(
				    getClass().getResource(
				        "/fxml/managerUI/PresentNoEditCell.fxml"));
				loader.setController(controller);
				AnchorPane presentroot = null;
			try {
				presentroot = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
		presentListVBox.getChildren().add(presentroot);
	}
}
	//空的方法
	@FXML 
	protected void selectGoods(){}
	@FXML
	protected void selectVIP(){}
	@FXML
	protected void findPresent(){}
	//删除
	@FXML void cancel(){
		if(showConfirmDialog()){
			uniBLService.delete(id);
			controller.deleteFromList(vo);
			System.out.println("delete");
		}
		
	}
	@FXML void commit(){
		
		DataRM rm = uniBLService.commit(getVOFromUI());	
		PromptHelper.showPrompt(rm);
		
	}
	//编辑
	@FXML void save(){
		if(ConfirmHelper.showConfirmDialog("编辑状态会清空已获得的策略哦")){
		this.controller.controller.CloseListToEdit();

		Platform.runLater(()->{
		try {
   		 SaleTypeEditListController controller = generateEditList();
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/salesmanUI/SaleTypeList.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = loader.load();
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForMembership.fxml"));
			this.controller.getController().centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
		}
	}
	protected SaleTypeEditListController generateEditList() {
		SaleEditListController controller = 
   				    new SaleEditListController(this.controller.controller,SaleBLFactory.getSaleListBLService(),vo.getId(),vo);
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
	public SalesmanListVO getVOFromUI(){
		return new SaleListVO(id,operator.getText(),operatorId, null,operatorGrade,VIPID.getText(),
				VIPName.getText(),grade, clerk.getText(), "默认仓库", notesTextField.getText(),chosenList,
				Double.parseDouble(sumAfterRebateLabel.getText()),Double.parseDouble(totalAmount.getText()), Double.parseDouble(rebateField.getText()), Double.parseDouble(useVoucherField.getText()), presentResult); 
	}

	
}
