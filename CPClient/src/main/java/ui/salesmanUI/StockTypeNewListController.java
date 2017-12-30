
package ui.salesmanUI;

import java.util.ArrayList;

import VO.goodsVO.GoodsVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import ui.commonUI.ParentController;
import ui.mainUI.loginUI.User;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public abstract class StockTypeNewListController extends StockTypeListController {
	@FXML protected Button commitBtn;
	@FXML protected Button saveBtn;
	@FXML protected Button cancelBtn;
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id 
	 */
	public StockTypeNewListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService,id);
	}

	@FXML
	void initialize(){
		super.initialize();
		operator.setText(User.getInstance().getUserName());
		operatorId = User.getInstance().getId();
		operatorGrade = User.getInstance().getGrade();
	}
	@FXML
	void cancel(){
		uniBLService.delete(id);
	}


}
