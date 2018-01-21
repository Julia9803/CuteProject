package ui.salesmanUI;

import java.util.List;

import com.jfoenix.controls.JFXButton;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;


/**     
* @author 李安迪
* @date 2017年12月24日
* @description 销售类单据和库存类单据的草稿单查看界面的父类
*/
public abstract class ListViewController {
	@FXML
	protected VBox vBox;
	@FXML JFXButton backBtn;
	
	public SalesmanController controller;
	public SalesmanController getController() {
		return controller;
	}

	public void setController(SalesmanController controller) {
		this.controller = controller;
	}

	SaleUniBLService service;
	protected List<SalesmanListVO> list;
	

	public ListViewController(SalesmanController controller, SaleUniBLService service, List<SalesmanListVO> list) {
		super();
		this.controller = controller;
		this.service = service;
		this.list = list;
	}
	
	public void deleteFromList(SalesmanListVO vo){
		this.list.remove(vo);
		this.refresh();
	}
	
	@FXML
	void initialize(){
		this.refresh();
	}
	@FXML
	public void back(){
		this.controller.CloseSonWin();
	}
	
	public abstract void refresh();
}
