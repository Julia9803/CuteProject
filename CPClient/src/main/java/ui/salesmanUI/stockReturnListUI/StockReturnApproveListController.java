package ui.salesmanUI.stockReturnListUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockReturnListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import ui.commonUI.ParentController;
import ui.salesmanUI.stock.StockTypeApproveListController;

public class StockReturnApproveListController extends StockTypeApproveListController{

	public StockReturnApproveListController(ParentController parentController, SaleUniBLService uniBLService, String id,
			SalesmanListVO vo) {
		super(parentController, uniBLService, id, vo);
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.StockReturnTypeListController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI() {
		return new StockReturnListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}

	@Override
	@FXML
	protected
	void cancel(){
		if(parentController != null)
		this.parentController.CloseSonWin();
	}

}