package ui.salesmanUI.stockReturnListUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockReturnListVO;
import bl.salebl.SaleBLFactory;
import ui.salesmanUI.CellController;
import ui.salesmanUI.ListViewController;
import ui.salesmanUI.stock.StockTypeEditListController;
import ui.salesmanUI.stockListUI.StockListCellController;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class StockReturnListCellController extends StockListCellController implements CellController {

	/**
	 * @param stockListViewController
	 * @param vo
	 */
	public StockReturnListCellController(ListViewController stockReturnListViewController, SalesmanListVO vo) {
		super(stockReturnListViewController, vo);
		this.uniBLService = SaleBLFactory.getStockReturnListBLService();
	}

	@Override
	public SalesmanListVO getVOFromUI() {
		return new StockReturnListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}
	
	@Override
	protected
	StockTypeEditListController generateEditList() {
		StockTypeEditListController controller = 
   				    new StockReturnEditListController(this.controller.controller,SaleBLFactory.getStockReturnListBLService(),vo.getId(),vo);
		return controller;
	}
}
