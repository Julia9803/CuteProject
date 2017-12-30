package ui.salesmanUI;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public abstract class StockTypeEditListController extends StockTypeListController {
	@FXML protected Button commitBtn;
	@FXML protected Button saveBtn;
	@FXML protected Button cancelBtn;
	
	SalesmanListVO vo;
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public StockTypeEditListController(ParentController parentController, SaleUniBLService uniBLService, String id,SalesmanListVO vo) {
		super(parentController, uniBLService, id);
	}

	@FXML
	void initialize(){
		super.initialize();
		operator.setText(vo.getOperator());
		operatorId = vo.getOperatorId();
		operatorGrade = vo.getOperatorGrade();
		
		totalAmount.setText(vo.getSum()+"");
		VIPID.setText(vo.getMemberID());
		VIPName.setText(vo.getMemberName());
		notesTextField.setText(vo.getNotes());
		
		chosenList = vo.getSaleListItems();
		this.refresh();
	}
	
	

}
