package ui.managerUI;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.mainUI.loginUI.LoginWin;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public class ManagerController {
	@FXML public AnchorPane root;
	@FXML public BorderPane centerPane;
	
	@FXML public MenuItem newPresentForMembership;
	@FXML public MenuItem showPresentForMembership;
	@FXML public MenuItem newPresentForSpecialPackage;
	@FXML public MenuItem showPresentForSpecialPackage;
	@FXML public MenuItem newPresentForSum;
	@FXML public MenuItem showPresentForSum;
	
	@FXML
	public void onNewPresentForMembershipClicked(){
		if(centerPane.getCenter() == null){
		Platform.runLater(()->{
		try {
   		 Strategy strategy = new PresentForMembershipNewStrategy();
   		 PresentForMembershipController controller = 
   				    new PresentForMembershipController(strategy,this);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForMembership.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = loader.load();
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
		}
	}
	@FXML
	public void onNewPresentForSpecialPackageClicked(){
		if(centerPane.getCenter() == null){
		Platform.runLater(()->{
		try {
   		 Strategy strategy = new PresentForSpecialPackageNewStrategy();
   		 PresentForSpecialPackageController controller = 
   				    new PresentForSpecialPackageController(strategy,this);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForSpecialPackage.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = loader.load();
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
		}
	}
	@FXML
	public void onNewPresentForSumClicked(){
		if(centerPane.getCenter() == null){
		Platform.runLater(()->{
		try {
   		 Strategy strategy = new PresentForSumNewStrategy();
   		 PresentForSumController controller = 
   				    new PresentForSumController(strategy,this);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForSum.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = loader.load();
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
		}
	}
	@FXML
	public void onShowPresentForMembershipClicked(){
		if(centerPane.getCenter() == null){
		Platform.runLater(()->{
			try {
	   		 PresentForSumListController controller = 
	   				    new PresentForSumListController(this);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        "/fxml/managerUI/PresentForMembershipList.fxml"));
	   				loader.setController(controller);
	   				AnchorPane presentroot = loader.load();
	//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));
				centerPane.setCenter(presentroot);
			} catch (Exception e) {
				e.printStackTrace();
			}
			});
		}
	}
	@FXML
	public void onShowPresentForSpecialPackageClicked(){
		if(centerPane.getCenter() == null){
		Platform.runLater(()->{
		try {
   		 PresentForSumListController controller = 
   				    new PresentForSumListController(this);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForSpecialPackageList.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = loader.load();
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
		}
	}
	@FXML
	public void onShowPresentForSumClicked(){
		if(centerPane.getCenter() == null){
		Platform.runLater(()->{
		try {
   		 PresentForSumListController controller = 
   				    new PresentForSumListController(this);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/managerUI/PresentForSumList.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = loader.load();
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));
			centerPane.setCenter(presentroot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
		}
	}
    
    @FXML 
    public void logOut() {
    	
   	     Platform.runLater(()-> {
				    try {
				    	System.out.println("log out");
						root.getScene().getWindow().hide();
						new ui.mainUI.loginUI.LoginWin();
						//new ui.saleUI.SaleWin();
					} catch (Exception e) {
						e.printStackTrace();
					}
			});   	 
    }

}
