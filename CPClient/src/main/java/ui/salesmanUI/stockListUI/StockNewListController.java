package ui.salesmanUI.stockListUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import ui.commonUI.ParentController;
import ui.salesmanUI.stock.StockTypeNewListController;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class StockNewListController extends StockTypeNewListController {

	
	@Override
	@FXML
	protected
	void initialize(){
		super.initialize();
		System.out.println("stock new list controller initialized");
	}
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public StockNewListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.StockTypeNewListController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI() {
		return new StockListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}
	
}
