package ui.salesmanUI.stockReturnListUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockReturnListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import ui.commonUI.ParentController;
import ui.salesmanUI.stock.StockTypeEditListController;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class StockReturnEditListController extends StockTypeEditListController{

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 * @param vo
	 */
	public StockReturnEditListController(ParentController parentController, SaleUniBLService uniBLService, String id,
			SalesmanListVO vo) {
		super(parentController, uniBLService, id, vo);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.StockReturnTypeListController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI() {
		// TODO Auto-generated method stub
		return new StockReturnListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}

	@Override
	@FXML
	protected
	void cancel(){

		this.parentController.CloseSonWin();
	}

}
