package ui.managerUI;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import resultmessage.DataRM;
import ui.commonUI.BussinessSituationWin;
import ui.commonUI.LookListController;
import ui.commonUI.PromptHelper;
import ui.commonUI.SalesDetailsTreeTable;

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

	@FXML public  MenuItem InfoListBtn;
	@FXML public MenuItem BussinessSituationBtn;

	@FXML
	public void onNewPresentForMembershipClicked(){
		if(centerPane.getChildren().isEmpty()){
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
		}else{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}
	@FXML
	public void onNewPresentForSpecialPackageClicked(){
		if(centerPane.getChildren().isEmpty()){
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
		}else{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}
	@FXML
	public void onNewPresentForSumClicked(){
		if(centerPane.getChildren().isEmpty()){
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
		}else{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}
	@FXML
	public void onShowPresentForMembershipClicked(){
		if(centerPane.getChildren().isEmpty()){
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
		}else{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}
	@FXML
	public void onShowPresentForSpecialPackageClicked(){
		if(centerPane.getChildren().isEmpty()){
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
		}else{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}
	@FXML
	public void onShowPresentForSumClicked(){
		if(centerPane.getChildren().isEmpty()){
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
		}else{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
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

    @FXML public void openInfoLists(){
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource(
						"/fxml/commonUI/LookList.fxml"));
		try {
			AnchorPane presentroot = loader.load();
			centerPane.getChildren().clear();
			centerPane.setCenter(presentroot);
			LookListController ctr=loader.getController();
			ctr.set(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    @FXML public void openSalesDetailsList(){
    	SalesDetailsTreeTable treetable=new SalesDetailsTreeTable();
        Stage stage=new Stage();

			treetable.start(stage);

    }
    @FXML public void openBussinessSituationList(){
		try {
			BussinessSituationWin win=new BussinessSituationWin();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
