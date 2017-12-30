package ui.salesmanUI;

import java.util.List;

import PO.SalesmanListPO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import ui.commonUI.ParentController;
import ui.commonUI.SonController;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description 打开销售单和销售退货单列表
*/
public abstract class SaleTypeListViewController extends ListViewController{

	/**
	 * @param controller
	 * @param service
	 * @param list
	 */
	public SaleTypeListViewController(SalesmanController controller, SaleUniBLService service,
			List<SalesmanListVO> list) {
		super(controller, service, list);
		// TODO Auto-generated constructor stub
	}
}
