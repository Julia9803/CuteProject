package ui.managerUI;

import java.io.IOException;
import java.util.List;

import VO.presentVO.PresentForSpecialPackageVO;
import bl.presentbl.PresentBLFactory;
import blservice.presentblservice.PresentForSpecialPackageBLService;
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
public class PresentForSpecialPackageListController {
	@FXML VBox vBox;
	@FXML Button backBtn;
	private PresentForSpecialPackageBLService service;
 @FXML private ManagerController managerController;
 	private List<PresentForSpecialPackageVO> presentForSpecialPackageList;
 
 public PresentForSpecialPackageBLService getService() {
		return service;
	}

	public void setService(PresentForSpecialPackageBLService service) {
		this.service = service;
	}
	
 public ManagerController getManagerController() {
		return managerController;
	}

	public void setManagerController(ManagerController managerController) {
		this.managerController = managerController;
	}
	
	public void deleteFromPresentList(PresentForSpecialPackageVO vo){
		this.presentForSpecialPackageList.remove(vo);
		this.refresh();
	}
	
	public PresentForSpecialPackageListController(ManagerController managerController){
		this.managerController = managerController;
    	service = PresentBLFactory.getPresentForSpecialPackageBLService();
    	System.out.println("service"+service);
    	this.presentForSpecialPackageList = service.getAll();
    	System.out.println(presentForSpecialPackageList);
	}
	
	@FXML void initialize(){
		this.refresh();
	}
	


	
	public void refresh() {
		vBox.getChildren().clear();
		// TODO Auto-generated method stub
		if(presentForSpecialPackageList != null)
		for(PresentForSpecialPackageVO vo : presentForSpecialPackageList){
   		 PresentForSpecialPackageCellController controller = 
   				    new PresentForSpecialPackageCellController(this,vo);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForSpecialPackageCell.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = null;
				try {
					presentroot = loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSpecialPackage.fxml"));

				vBox.getChildren().add(presentroot);
				System.out.println("after adding children");
		}
		System.out.println(vBox.getChildren());
	}	
	
	@FXML public void back(){
    	this.managerController.centerPane.setCenter(null);
	}
}
