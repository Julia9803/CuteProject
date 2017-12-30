package ui.managerUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSpecialPackageVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**     
* @author 李安迪
* @date 2017年12月19日
* @description
*/
public class PresentForSpecialPackageCellController implements SinglePresentController{
	@FXML protected Button editBtn;
	@FXML protected Button deleteBtn;
	@FXML protected VBox presentListVBox;
	
	@FXML protected TextField startYearField;
    @FXML protected TextField startMonthField;
    @FXML protected TextField startDayField;
    @FXML protected TextField finishYearField;
    @FXML protected TextField finishMonthField;
    @FXML protected TextField finishDayField;

    @FXML protected TextField rebateField;
    
    @FXML PresentForSpecialPackageListController controller;
    PresentForSpecialPackageVO vo;
    Strategy strategy;
	private List<GoodsInSaleVO> presentList;
	
    protected List<TextField> textFieldList;
	/**
     * 界面保存但不显示策略id
     */
    int id;
    
    public int getId(){
    	return this.id;
    }
    
    public void setId(int id){
    	this.id = id;
    }
    /**
	 * @param presentForSpecialPackageListController
	 * @param vo
	 */
	public PresentForSpecialPackageCellController(PresentForSpecialPackageListController controller, PresentForSpecialPackageVO vo) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.vo = vo;
		this.strategy = new PresentForSpecialPackageCellStrategy();
	}


	@FXML void initialize(){
    	textFieldList = new ArrayList<TextField>();
    	//加入文本框列表
    	textFieldList.add(startYearField);
    	textFieldList.add(startMonthField);
    	textFieldList.add(startDayField);
    	textFieldList.add(finishYearField);
    	textFieldList.add(finishMonthField);
    	textFieldList.add(finishDayField);
    	textFieldList.add(rebateField);
    	
    	strategy.initData(this, vo);
    }


	/* (non-Javadoc)
	 * @see ui.managerUI.SinglePresentController#setPresentList(java.util.List)
	 */
	@Override
	public void setPresentList(List<GoodsInSaleVO> presentList) {
		// TODO Auto-generated method stub
		this.presentList = presentList;
		this.refresh();
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
	@FXML void delete(){
		if(showConfirmDialog())
			controller.deleteFromPresentList(vo);
		
	}
	
	@FXML void edit(){
		Platform.runLater(()->{
		try {
   		 Strategy strategy = new PresentForSpecialPackageEditStrategy();
   		 PresentForSpecialPackageController controller = 
   				    new PresentForSpecialPackageController(strategy,this.controller.getManagerController(),vo);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForSpecialPackage.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = loader.load();
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSpecialPackage.fxml"));
			this.controller.getManagerController().centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
	}
	public void refresh() {
		presentListVBox.getChildren().clear();
		// TODO Auto-generated method stub
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(presentroot == null)
					System.out.println("presentroot is null");
				if(presentListVBox == null)
					System.out.println("presentListVBox is null");
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSpecialPackage.fxml"));
			presentListVBox.getChildren().add(presentroot);
		}
	}
}
