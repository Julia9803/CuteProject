package ui.managerUI;

import java.io.IOException;
import java.util.List;

import VO.presentVO.PresentForMembershipVO;
import bl.presentbl.PresentBLFactory;
import blservice.presentblservice.PresentForMembershipBLService;
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
public class PresentForMembershipListController {
	@FXML VBox vBox;
	@FXML Button backBtn;
	private PresentForMembershipBLService service;
 @FXML private ManagerController managerController;
 	private List<PresentForMembershipVO> presentForMembershipList;
 
 public PresentForMembershipBLService getService() {
		return service;
	}

	public void setService(PresentForMembershipBLService service) {
		this.service = service;
	}
	
 public ManagerController getManagerController() {
		return managerController;
	}

	public void setManagerController(ManagerController managerController) {
		this.managerController = managerController;
	}
	
	public void deleteFromPresentList(PresentForMembershipVO vo){
		this.presentForMembershipList.remove(vo);
		this.refresh();
	}
	
	public PresentForMembershipListController(ManagerController managerController){
		this.managerController = managerController;
    	service = PresentBLFactory.getPresentForMembershipBLService();
    	System.out.println("service"+service);
    	this.presentForMembershipList = service.getAll();
    	System.out.println(presentForMembershipList);
	}
	
	@FXML void initialize(){
		this.refresh();
	}
	


	
	public void refresh() {
		vBox.getChildren().clear();
		// TODO Auto-generated method stub
		if(presentForMembershipList != null)
		for(PresentForMembershipVO vo : presentForMembershipList){
   		 PresentForMembershipCellController controller = 
   				    new PresentForMembershipCellController(this,vo);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForMembershipCell.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = null;
				try {
					presentroot = loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForMembership.fxml"));

				vBox.getChildren().add(presentroot);
				System.out.println("after adding children");
		}
		System.out.println(vBox.getChildren());
	}	
	
	
	@FXML public void back(){
    	this.managerController.centerPane.setCenter(null);
	}
}
