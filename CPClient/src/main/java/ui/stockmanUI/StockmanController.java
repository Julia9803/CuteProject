package ui.stockmanUI;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import ui.mainUI.BackgroundController;
import ui.mainUI.loginUI.LoginWin;
import util.State;
import util.StoreListType;

/**
 * 
 * @author julia98
 * @since 2017.12.03
 *
 */
public class StockmanController extends BackgroundController{
	@FXML public AnchorPane root;
	@FXML public BorderPane centerPane;
	@FXML public MenuButton newBtn;
	@FXML public MenuButton lookBtn;
	@FXML public JFXButton goodsManageBtn;
	@FXML public JFXButton draftBtn;
	@FXML public ImageView logOutBtn;
	
	@FXML public MenuItem newPresentListBtn;
	@FXML public MenuItem newStockOverflowListBtn;
	@FXML public MenuItem newStockLostListBtn;
	@FXML public MenuItem newAlarmListBtn;
	@FXML public MenuItem lookPresentListBtn;
	@FXML public MenuItem lookStockOverflowListBtn;
	@FXML public MenuItem lookStockLostListBtn;
	@FXML public MenuItem lookAlarmListBtn;
	@FXML public MenuItem messageBtn;
	@FXML public MenuItem personalInfoBtn;
	
	@FXML public Pane addNext;

	
	
	@FXML public void initialize() {
		
	}
	
	 @FXML public void newPresentList() {
		
	 }
	
     @FXML public void newStockOverflowList() {
		 Platform.runLater(()->{
			 try {
				 ReportListWin win=new ReportListWin();
//				 root.getScene().getWindow().hide();
				;
				 State state=State.IsEditting;
				 win.controller.set(StoreListType.OVERFLOW,state);

			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
	 }
     
     @FXML public void newStockLostList() {
		 Platform.runLater(()->{
			 try {
				 ReportListWin win=new ReportListWin();
//				 root.getScene().getWindow().hide();
				 State state=State.IsEditting;
				 win.controller.set(StoreListType.LOSS,state);

			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
     }
     
     @FXML public void newAlarmList() {
    	 
     }
     
     @FXML public void lookPresentList() {
		 Platform.runLater(()->{
			 try {
				 StoreListWin win=new StoreListWin();
				 root.getScene().getWindow().hide();
				 win.controller.set(StoreListType.PRESENT);
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
     }
     
     @FXML public void lookStockOverflowList() {
		 Platform.runLater(()->{
			 try {
				 StoreListWin win=new StoreListWin();
				 root.getScene().getWindow().hide();
				 win.controller.set(StoreListType.OVERFLOW);
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
     }
     
     @FXML public void lookStockLostList() {
		Platform.runLater(()->{
			 try {
				 StoreListWin win=new StoreListWin();
				 root.getScene().getWindow().hide();
				 win.controller.set(StoreListType.LOSS);
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
     }
     
     @FXML public void lookAlarmList() {
    	 Platform.runLater(()->{
 			try {
 				StoreListWin win=new StoreListWin();
 				root.getScene().getWindow().hide();
 		        win.controller.set(StoreListType.ALARM);
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 		});
     }
     
     @FXML public void message() {
    	 
     }
     
     @FXML public void personalInfo() {
    	 
     }
     
     @FXML public void draft() {
    	 
     }
    
     
     @FXML 
     public void goodsManage() {
		Platform.runLater(()->{
			try {
				new GoodsWin();
				root.getScene().getWindow().hide();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		/*
    	 Platform.runLater(new Runnable() {
    	     public void run() {
    	    	 try {
			    	AnchorPane goodsroot = FXMLLoader.load(getClass().getResource("/fxml/stockmanUI/GoodsBLServiceImpl.fxml"));
					centerPane.setCenter(goodsroot);
	
				 } catch (Exception e) {
					e.printStackTrace();
				 }
    	     }
    	 });
    	 */
     }
     
     @FXML 
     public void logOut() {
    	     Platform.runLater(()-> {
				    try {
						root.getScene().getWindow().hide();
						new LoginWin();
						//new ui.saleUI.SaleWin();
					} catch (Exception e) {
						e.printStackTrace();
					}
			});   	 
     }
}
