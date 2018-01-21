package ui.salesmanUI.saleListUI;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptHelper;


/**     
* @author 李安迪
* @date 2018年1月8日
* @description
*/
public class SaleWriteoffEditController extends SaleEditListController{

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 * @param vo
	 */
	public SaleWriteoffEditController(ParentController parentController, SaleUniBLService uniBLService, String id,
			SalesmanListVO vo) {
		super(parentController, uniBLService, id, vo);
	}
	
	@Override
	protected
	void initialize(){
		super.initialize();
		saveBtn.setVisible(false);
	}
	
	//提交红冲并复制后单据
	@Override
	@FXML
	protected void commit(){
		if(!check())
			return;
		uniBLService.commit(getVOFromUI());
		PromptHelper.showPrompt(DataRM.SUCCESS);
		this.parentController.CloseSonWin();		
	}
}