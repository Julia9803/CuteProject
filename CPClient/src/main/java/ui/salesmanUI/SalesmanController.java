package ui.salesmanUI;

import java.io.IOException;
import java.util.List;

import com.sun.glass.ui.MenuItem;

import VO.saleVO.SalesmanListVO;
import bl.salebl.SaleBLFactory;
import blservice.saleblservice.SaleUniBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月23日
* @description 销售人员主页面
*/
public class SalesmanController implements ParentController {
	@FXML public AnchorPane root;
	@FXML public BorderPane centerPane;
	@FXML public BorderPane titlePane;
	
	@FXML public MenuItem newSaleListBtn;
	@FXML public MenuItem newSaleReturnListBtn;
	@FXML public MenuItem newStockListBtn;
	@FXML public MenuItem newStockReturnListBtn;
	
	@FXML public MenuItem draftSaleListBtn;
	@FXML public MenuItem draftSaleReturnListBtn;
	@FXML public MenuItem draftStockListBtn;
	@FXML public MenuItem draftStockReturnListBtn;
	
	private static final String SALE_LIST_TITLE_SOURCE = "/fxml/salesmanUI/SaleListTitle.fxml";
	private static final String SALERETURN_LIST_TITLE_SOURCE = "/fxml/salesmanUI/SaleReturnListTitle.fxml";
	private static final String STOCK_LIST_TITLE_SOURCE = "/fxml/salesmanUI/StockListTitle.fxml";
	private static final String STOCKRETURN_LIST_TITLE_SOURCE = "/fxml/salesmanUI/StockReturnListTitle.fxml";
	
	private static final String SALE_LIST_SOURCE = "/fxml/salesmanUI/SaleList.fxml";
	private static final String SALERETURN_LIST_SOURCE = "/fxml/salesmanUI/SaleReturnList.fxml";
	private static final String STOCK_LIST_SOURCE = "/fxml/salesmanUI/StockList.fxml";
	private static final String STOCKRETURN_LIST_SOURCE = "/fxml/salesmanUI/StockReturnList.fxml";	
	
	private static final String FORM_CSS_PATH = "/css/forms/Forms.css";
	SaleUniBLService service;
	SalesmanListWinController controller;
	ListViewController viewController;
	Alert information;
	
	@FXML
	public void newSaleList(){
		if(centerPane.getCenter() == null){
			service = SaleBLFactory.getSaleListBLService();
			String id = service.getId();
			controller = new SaleNewListController(this,service,id);			
//			controller = new SaleTypeNewListController(this,service,id);
		Platform.runLater(()->{
			loadNewList(id,SALE_LIST_TITLE_SOURCE,SALE_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,controller);		
		});}

	}
	
	@FXML
	public void newSaleReturnList(){
		if(centerPane.getCenter() == null){
			service = SaleBLFactory.getSaleReturnListBLService();
			String id = service.getId();
			controller = new SaleReturnNewListController(this,service,id);
		Platform.runLater(()->{
			loadNewList(id,SALERETURN_LIST_TITLE_SOURCE,SALERETURN_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,controller);		
		});}

	}		

	@FXML
	public void newStockList(){
		if(centerPane.getCenter() == null){
			service = SaleBLFactory.getStockListBLService();
			String id = service.getId();
			controller = new StockNewListController(this,service,id);
		Platform.runLater(()->{
			loadNewList(id,STOCK_LIST_TITLE_SOURCE,STOCK_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,controller);		
		});}

	}	
	
	@FXML
	public void newStockReturnList(){
		if(centerPane.getCenter() == null){
			service = SaleBLFactory.getStockReturnListBLService();
			String id = service.getId();
			controller = new StockReturnNewListController(this,service,id);
		Platform.runLater(()->{
			loadNewList(id,STOCKRETURN_LIST_TITLE_SOURCE,STOCKRETURN_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,controller);		
		});}

	}	
	@FXML
	public void showDraftSaleList(){
		if(centerPane.getCenter() == null){
			service = SaleBLFactory.getSaleListBLService();
			List<SalesmanListVO> list = service.openAllDraft();
			viewController = new SaleListViewController(this,service,list);
		Platform.runLater(()->{
			showDraftList(list,SALE_LIST_TITLE_SOURCE,SALE_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,viewController);		
		});}
	}
	@FXML
	public void showDraftSaleReturnList(){
		if(centerPane.getCenter() == null){
			service = SaleBLFactory.getSaleReturnListBLService();
			List<SalesmanListVO> list = service.openAllDraft();
			viewController = new SaleReturnListViewController(this,service,list);
		Platform.runLater(()->{
			showDraftList(list,SALE_LIST_TITLE_SOURCE,SALE_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,viewController);		
		});}
	}
	@FXML
	public void showDraftStockList(){
		if(centerPane.getCenter() == null){
			service = SaleBLFactory.getStockListBLService();
			List<SalesmanListVO> list = service.openAllDraft();
			viewController = new StockListViewController(this,service,list);
		Platform.runLater(()->{
			showDraftList(list,SALE_LIST_TITLE_SOURCE,SALE_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,viewController);		
		});}
	}
	@FXML
	public void showDraftStockReturnList(){
		if(centerPane.getCenter() == null){
			service = SaleBLFactory.getStockReturnListBLService();
			List<SalesmanListVO> list = service.openAllDraft();
			viewController = new StockReturnListViewController(this,service,list);
		Platform.runLater(()->{
			showDraftList(list,SALE_LIST_TITLE_SOURCE,SALE_LIST_SOURCE,FORM_CSS_PATH,FORM_CSS_PATH,viewController);		
		});}
	}
	private void loadNewList(String id, String fxmlTitlePath, String fxmlPath, String cssTitlePath, String cssPath,SalesmanListWinController controller){
		if(id == null){
			//TODO 提示单据已满的界面
			information = new Alert(Alert.AlertType.ERROR,"请继续努力工作吧~");
			information.setTitle("今日单据生成数目已达到上限");         
			information.setHeaderText("失败");    
			information.showAndWait();
			return;
		}
		FXMLLoader loader;
		loadSimpleFXML(fxmlTitlePath, cssTitlePath);

		AnchorPane ListRoot = null;
		try {
			loader = new FXMLLoader(getClass().getResource(fxmlPath));
			
//			ListWinController ListWinController  = controller;
//			controller.setParentController(this);
//			controller.setListID(id);
//			controller.setOperator(User.getInstance().getUserName());

			loader.setController(controller);
			ListRoot = loader.load();
			

			
			if(cssPath != null)
				ListRoot.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
			
			centerPane.getChildren().removeAll();
			centerPane.getChildren().add(ListRoot);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showDraftList(List<SalesmanListVO> list, String fxmlTitlePath, String fxmlPath, String cssTitlePath, String cssPath,ListViewController controller){
		if(list == null){
			//TODO 提示网络错误的界面
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
			
//			ListWinController ListWinController  = controller;
//			controller.setParentController(this);
//			controller.setListID(id);
//			controller.setOperator(User.getInstance().getUserName());

			loader.setController(controller);
			ListRoot = loader.load();
			

			
			if(cssPath != null)
				ListRoot.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
			
			centerPane.getChildren().removeAll();
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
				
				titlePane.getChildren().removeAll();
				titlePane.getChildren().add(titleRoot);
	}

	/* (non-Javadoc)
	 * @see ui.commonUI.ParentController#CloseSonWin()
	 */
	@Override
	public void CloseSonWin() {
		// TODO Auto-generated method stub
    	this.centerPane.setCenter(null);
		
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
