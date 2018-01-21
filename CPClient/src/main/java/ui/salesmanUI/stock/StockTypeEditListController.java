package ui.salesmanUI.stock;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptHelper;

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
		this.vo = vo;
	}

	@Override
	@FXML
	protected
	void initialize(){
		super.initialize();
		System.out.println(vo);
		if(vo.getOperator()!=null)
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
	
	@FXML
	protected
	void cancel(){
		if(parentController != null)
		this.parentController.CloseSonWin();
		else{
	   	     Platform.runLater(()-> {
					    try {
							root.getScene().getWindow().hide();
						} catch (Exception e) {
							e.printStackTrace();
						}
				});   	 
		}		
		PromptHelper.showPrompt(DataRM.SUCCESS);
	}
}
