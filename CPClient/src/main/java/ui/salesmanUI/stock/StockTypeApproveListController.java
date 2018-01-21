package ui.salesmanUI.stock;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptHelper;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public abstract class StockTypeApproveListController extends StockTypeEditListController {

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public StockTypeApproveListController(ParentController parentController, SaleUniBLService uniBLService, String id,SalesmanListVO vo) {
		super(parentController, uniBLService, id,vo);
		this.vo = uniBLService.get(id);
	}
	
	@Override
	@FXML
	protected
	void initialize(){
		super.initialize();
		commitBtn.setText("过审");
		saveBtn.setText("驳回");
	}

	//审批
	@Override
	@FXML
	protected
	void commit(){
		if(!check())
			return;
		DataRM rm = uniBLService.approve(getVOFromUI(),false);
		PromptHelper.showPrompt(rm);
		Platform.runLater(()->{
			root.getScene().getWindow().hide();
		});
	}
	
	//审批不通过
	@Override
	@FXML
	protected
	void save(){
		DataRM rm = uniBLService.reject(getVOFromUI());
		PromptHelper.showPrompt(rm);
		Platform.runLater(()->{
			root.getScene().getWindow().hide();
		});
	}


}
