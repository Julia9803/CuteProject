package ui.salesmanUI;

import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import VO.saleVO.SalesmanListVO;
import bl.salebl.SaleBLFactory;
import blservice.saleblservice.SaleListBLService;
import blservice.saleblservice.SaleReturnListBLService;
import blservice.saleblservice.StockListBLService;
import blservice.saleblservice.StockReturnListBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptHelper;
import ui.salesmanUI.saleListUI.SaleListViewController;
import ui.salesmanUI.saleListUI.SaleNewListController;
import ui.salesmanUI.saleReturnListUI.SaleReturnListViewController;
import ui.salesmanUI.saleReturnListUI.SaleReturnNewListController;
import ui.salesmanUI.stockListUI.StockListViewController;
import ui.salesmanUI.stockListUI.StockNewListController;
import ui.salesmanUI.stockReturnListUI.StockReturnListViewController;
import ui.salesmanUI.stockReturnListUI.StockReturnNewListController;
import ui.salesmanUI.vip.VIPWin;

/**     
* @author 李安迪
* @date 2017年12月23日
* @description 销售人员主页面
*/
public class SalesmanController implements ParentController {
	@FXML public AnchorPane root;
	@FXML public BorderPane centerPane;
	@FXML public AnchorPane titlePane;
	
	@FXML public MenuItem newSaleListBtn;
	@FXML public MenuItem newSaleReturnListBtn;
	@FXML public MenuItem newStockListBtn;
	@FXML public MenuItem newStockReturnListBtn;
	
	@FXML public MenuItem draftSaleListBtn;
	@FXML public MenuItem draftSaleReturnListBtn;
	@FXML public MenuItem draftStockListBtn;
	@FXML public MenuItem draftStockReturnListBtn;
	
	@FXML public JFXButton vipBtn;
	
	private static final String SALE_LIST_TITLE_SOURCE = "/fxml/salesmanUI/SaleListTitle.fxml";
	private static final String SALERETURN_LIST_TITLE_SOURCE = "/fxml/salesmanUI/SaleReturnListTitle.fxml";
	private static final String STOCK_LIST_TITLE_SOURCE = "/fxml/salesmanUI/StockListTitle.fxml";
	private static final String STOCKRETURN_LIST_TITLE_SOURCE = "/fxml/salesmanUI/StockReturnListTitle.fxml";
	
	private static final String SALE_LIST_SOURCE = "/fxml/salesmanUI/SaleTypeList.fxml";
	private static final String SALERETURN_LIST_SOURCE = "/fxml/salesmanUI/SaleTypeList.fxml";
	private static final String STOCK_LIST_SOURCE = "/fxml/salesmanUI/StockTypeList.fxml";
	private static final String STOCKRETURN_LIST_SOURCE = "/fxml/salesmanUI/StockTypeList.fxml";	
	
	private static final String FORM_CSS_PATH = "/css/forms/Forms.css";
	private static final String VIEW_PATH = "/fxml/salesmanUI/ListOfForms.fxml";
	SalesmanListWinController controller;
	ListViewController viewController;
	Alert information;
	
//	public void setVIPInvisible() {
//		VIPController vipController = new VIPController();
//		vipController.vip1.setVisible(false);
//		vipController.vip2.setVisible(false);
//		vipController.scrollPane.setVisible(false);
//	}
	
	@FXML
	public void setVIPBtn() {
		Platform.runLater(()->{
			try {
				new VIPWin();
				root.getScene().getWindow().hide();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@FXML
	public void newSaleList(){
		
		if(centerPane.getChildren().isEmpty()){
			System.out.println("in loading new saleList");

	     	
			SaleListBLService service = SaleBLFactory.getSaleListBLService();
			String id = service.getId();
			if(!IdChecker.checkId(service, id)){
				return;
			}
			controller = new SaleNewListController(this,service,id);			
//			controller = new SaleTypeNewListController(this,service,id);
		Platform.runLater(()->{
			loadNewList(id,SALE_LIST_TITLE_SOURCE,SALE_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,controller);		
		});}
		else
		{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}

	}
	
	@FXML
	public void newSaleReturnList(){	
		if(centerPane.getChildren().isEmpty()){
			SaleReturnListBLService service = SaleBLFactory.getSaleReturnListBLService();
			String id = service.getId();
			if(!IdChecker.checkId(service, id)){
				return;
			}
			controller = new SaleReturnNewListController(this,service,id);
		Platform.runLater(()->{
			loadNewList(id,SALERETURN_LIST_TITLE_SOURCE,SALERETURN_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,controller);		
		});}
		else
		{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}

	}		

	@FXML
	public void newStockList(){
		
		if(centerPane.getChildren().isEmpty()){
			System.out.println(SaleBLFactory.getStockListBLService());

			StockListBLService service = SaleBLFactory.getStockListBLService();
			
			String id = service.getId();
			if(!IdChecker.checkId(service, id)){
				return;
			}
			controller = new StockNewListController(this,service,id);
		Platform.runLater(()->{
			loadNewList(id,STOCK_LIST_TITLE_SOURCE,STOCK_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,controller);		
		});}
		else
		{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}	
	
	@FXML
	public void newStockReturnList(){
		
		if(centerPane.getChildren().isEmpty()){
			StockReturnListBLService service = SaleBLFactory.getStockReturnListBLService();
			String id = service.getId();
			if(!IdChecker.checkId(service, id)){
				return;
			}
			controller = new StockReturnNewListController(this,service,id);
		Platform.runLater(()->{
			loadNewList(id,STOCKRETURN_LIST_TITLE_SOURCE,STOCKRETURN_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,controller);		
		});}
		else
		{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}	
	@FXML
	public void showDraftSaleList(){
		
		if(centerPane.getChildren().isEmpty()){
			SaleListBLService service = SaleBLFactory.getSaleListBLService();
			List<SalesmanListVO> list = service.openAllDraft();
			viewController = new SaleListViewController(this,service,list);
		Platform.runLater(()->{
			showDraftList(list,SALE_LIST_TITLE_SOURCE,VIEW_PATH,FORM_CSS_PATH,FORM_CSS_PATH,viewController);		
		});}
		else
		{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}
	@FXML
	public void showDraftSaleReturnList(){
		
		if(centerPane.getChildren().isEmpty()){
			SaleReturnListBLService service = SaleBLFactory.getSaleReturnListBLService();
			List<SalesmanListVO> list = service.openAllDraft();
			viewController = new SaleReturnListViewController(this,service,list);
		Platform.runLater(()->{
			showDraftList(list,SALERETURN_LIST_TITLE_SOURCE,VIEW_PATH,FORM_CSS_PATH,FORM_CSS_PATH,viewController);		
		});}
		else
		{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}
	@FXML
	public void showDraftStockList(){
		
		if(centerPane.getChildren().isEmpty()){
			StockListBLService service = SaleBLFactory.getStockListBLService();
			List<SalesmanListVO> list = service.openAllDraft();
			viewController = new StockListViewController(this,service,list);
		Platform.runLater(()->{
			showDraftList(list,STOCK_LIST_TITLE_SOURCE,VIEW_PATH,FORM_CSS_PATH,FORM_CSS_PATH,viewController);		
		});}
		else
		{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}
	@FXML
	public void showDraftStockReturnList(){
		
		if(centerPane.getChildren().isEmpty()){
			StockReturnListBLService service = SaleBLFactory.getStockReturnListBLService();
			List<SalesmanListVO> list = service.openAllDraft();
			viewController = new StockReturnListViewController(this,service,list);
		Platform.runLater(()->{
			showDraftList(list,STOCKRETURN_LIST_TITLE_SOURCE,VIEW_PATH,FORM_CSS_PATH,FORM_CSS_PATH,viewController);		
		});}
		
		else
		{
			PromptHelper.showPrompt(DataRM.CANCEL_REMIND);
		}
	}
	private void loadNewList(String id, String fxmlTitlePath, String fxmlPath, String cssTitlePath, String cssPath,SalesmanListWinController controller){
		
		if(id == null){
			information = new Alert(Alert.AlertType.ERROR,"请继续努力工作吧~");
			information.setTitle("今日单据生成数目已达到上限");         
			information.setHeaderText("失败");    
			information.showAndWait();
			return;
		}
		FXMLLoader loader;
		loadSimpleFXML(fxmlTitlePath, cssTitlePath);

		System.out.println("after loading");
		AnchorPane ListRoot = null;
		try {
			loader = new FXMLLoader(getClass().getResource(fxmlPath));
      		loader.setController(controller);
			ListRoot = loader.load();
	
			if(cssPath != null)
				ListRoot.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
			
			centerPane.getChildren().clear();
			centerPane.getChildren().add(ListRoot);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showDraftList(List<SalesmanListVO> list, String fxmlTitlePath, String fxmlPath, String cssTitlePath, String cssPath,ListViewController controller){
		
		if(list == null){
			information = new Alert(Alert.AlertType.ERROR,"请继续努力工作吧~");
			information.setTitle("网络错误");         
			information.setHeaderText("失败");    
			information.showAndWait();
			return;
		}
		FXMLLoader loader;
		loadSimpleFXML(fxmlTitlePath, cssTitlePath);

		AnchorPane ListRoot = null;
		try {
			loader = new FXMLLoader(getClass().getResource(fxmlPath));
			loader.setController(controller);
			ListRoot = loader.load();
			

			
			if(cssPath != null)
				ListRoot.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
			
			centerPane.getChildren().clear();
			centerPane.getChildren().add(ListRoot);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 以不改变和重新赋值controller的方式加载简单的fxml和css，加载位置为标题栏titlePane
	 * @param fxmlPath 
	 * @param cssPath
	 */
	private void loadSimpleFXML(String fxmlPath, String cssPath) {
		
		System.out.println("loading title");
		AnchorPane titleRoot = null;
 		 FXMLLoader loader = new FXMLLoader(
				    getClass().getResource(
				       fxmlPath));
				try {
					titleRoot = loader.load();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//	    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));
				if(cssPath != null)
					titleRoot.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
				
				titlePane.getChildren().clear();
				titlePane.getChildren().add(titleRoot);
	}

	/* (non-Javadoc)
	 * @see ui.commonUI.ParentController#CloseSonWin()
	 */
	@Override
	public void CloseSonWin() {
		titlePane.getChildren().clear();
		centerPane.getChildren().clear();
		System.out.println("son win close");
	}
	
	public void CloseListToEdit(){
		centerPane.getChildren().clear();
	}
	
    @FXML 
    public void logOut() {
    	
   	     Platform.runLater(()-> {
				    try {
				    	System.out.println("log out");
						root.getScene().getWindow().hide();
						new ui.mainUI.loginUI.LoginWin();
					} catch (Exception e) {
						e.printStackTrace();
					}
			});   	 
    }
	
}
