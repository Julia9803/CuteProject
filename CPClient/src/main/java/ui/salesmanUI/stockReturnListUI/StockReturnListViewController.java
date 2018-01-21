package ui.salesmanUI.stockReturnListUI;

import java.util.List;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.salesmanUI.CellController;
import ui.salesmanUI.SalesmanController;
import ui.salesmanUI.stockListUI.StockListViewController;

/**     
* @author 李安迪
* @date 2017年12月29日
* @description
*/
public class StockReturnListViewController extends StockListViewController {

	/**
	 * @param controller
	 * @param service
	 * @param list
	 */
	public StockReturnListViewController(SalesmanController controller, SaleUniBLService service,
			List<SalesmanListVO> list) {
		super(controller, service, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CellController generateCellController(SalesmanListVO vo) {
		CellController controller = 
				   new StockReturnListCellController(this,vo);
		return controller;
	}

}
