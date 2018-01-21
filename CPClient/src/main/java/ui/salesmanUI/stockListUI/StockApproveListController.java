package ui.salesmanUI.stockListUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;
import ui.salesmanUI.stock.StockTypeApproveListController;

public class StockApproveListController extends StockTypeApproveListController{

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 * @param vo
	 */
	public StockApproveListController(ParentController parentController, SaleUniBLService uniBLService, String id,
			SalesmanListVO vo) {
		super(parentController, uniBLService, id, vo);
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.StockTypeListController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI() {
		// TODO Auto-generated method stub
		return new StockListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}


	

}
