package ui.salesmanUI;

import java.util.List;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月29日
* @description
*/
public class StockReturnListViewController extends ListViewController {

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

	/* (non-Javadoc)
	 * @see ui.salesmanUI.ListViewController#refresh()
	 */
	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

}