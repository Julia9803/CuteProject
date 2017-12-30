package ui.salesmanUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;

public class StockApproveListController extends StockTypeApproveListController{

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public StockApproveListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see ui.salesmanUI.StockTypeNewListController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI() {
		return new StockListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}

}
