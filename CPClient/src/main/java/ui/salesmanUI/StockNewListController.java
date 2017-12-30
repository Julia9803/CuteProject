package ui.salesmanUI;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class StockNewListController extends StockTypeNewListController {

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public StockNewListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
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
