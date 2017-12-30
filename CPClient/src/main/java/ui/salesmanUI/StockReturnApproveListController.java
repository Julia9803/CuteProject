package ui.salesmanUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockReturnListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;

public class StockReturnApproveListController extends StockTypeApproveListController{

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public StockReturnApproveListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see ui.salesmanUI.StockTypeListController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI() {
		return new StockReturnListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));	}



}