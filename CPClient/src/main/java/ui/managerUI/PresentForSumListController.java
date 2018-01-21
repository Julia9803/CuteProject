package ui.managerUI;

import java.io.IOException;
import java.util.List;

import VO.presentVO.PresentForSumVO;
import bl.presentbl.PresentBLFactory;
import blservice.presentblservice.PresentForSumBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public class PresentForSumListController {
	@FXML VBox vBox;
	@FXML Button backBtn;
	private PresentForSumBLService service;
 @FXML private ManagerController managerController;
 	private List<PresentForSumVO> presentForSumList;
 
 public PresentForSumBLService getService() {
		return service;
	}

	public void setService(PresentForSumBLService service) {
		this.service = service;
	}
	
 public ManagerController getManagerController() {
		return managerController;
	}

	public void setManagerController(ManagerController managerController) {
		this.managerController = managerController;
	}
	
	public void deleteFromPresentList(PresentForSumVO vo){
		this.presentForSumList.remove(vo);
		service.delete(vo.getId());
		this.refresh();
	}
	
	public PresentForSumListController(ManagerController managerController){
		this.managerController = managerController;
    	service = PresentBLFactory.getPresentForSumBLService();
    	System.out.println("service"+service);
    	this.presentForSumList = service.getAll();
    	System.out.println(presentForSumList);
	}
	
	@FXML void initialize(){
		this.refresh();
	}
	


	
	public void refresh() {
		vBox.getChildren().clear();
		// TODO Auto-generated method stub
		if(presentForSumList != null)
		for(PresentForSumVO vo : presentForSumList){
   		 PresentForSumCellController controller = 
   				    new PresentForSumCellController(this,vo);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForSumCell.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = null;
				try {
					presentroot = loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));

				vBox.getChildren().add(presentroot);
				System.out.println("after adding children");
		}
		System.out.println(vBox.getChildren());
	}	
	
	@FXML
	public void back(){
  	     Platform.runLater(()-> {
				    try {
				    	System.out.println("return");
				    	this.managerController.centerPane.setCenter(null);
//				    	this.managerController.centerPane.getChildren().removeAll();
					} catch (Exception e) {
						e.printStackTrace();
					}
			});  
		
	}

}
