package ui.salesmanUI.sale;

import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptHelper;
import ui.mainUI.loginUI.User;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public abstract class SaleTypeNewListController extends SaleTypeListController {

	

	
	@FXML protected Button commitBtn;
	@FXML protected Button saveBtn;
	@FXML protected Button cancelBtn;
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id 
	 */
	public SaleTypeNewListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService,id);
	}
	@Override
	@FXML
	protected
	void initialize(){
		super.initialize();

		operator.setText(User.getInstance().getUserName());
		operatorId = User.getInstance().getId();
		operatorGrade = User.getInstance().getGrade();
		System.out.println("sale type newlist controller initialized" );
	}

	
	@FXML
	protected void cancel(){
		if(!saved){
		DataRM rm = uniBLService.delete(id);
		
		System.out.println("cancel");
		PromptHelper.showPrompt(rm);
		}else{
			PromptHelper.showPrompt(DataRM.SUCCESS);
		}
		this.parentController.CloseSonWin();
	}


}
