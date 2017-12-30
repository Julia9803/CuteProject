package ui.salesmanUI;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import resultmessage.DataRM;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public abstract class SaleTypeListController extends SalesmanListWinController {

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public SaleTypeListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.SalesmanListWinController#getVIPList(java.lang.String, java.util.List)
	 */
	@Override
	public void getVIPList(String message, List<VIPVO> temp) {
		// TODO Auto-generated method stub
	
		try {
			temp.addAll(vipFuzzySearch.getVIPInIDOnlyRetailer(message));
			temp.addAll(vipFuzzySearch.getVIPInNameOnlyRetailer(message));
			temp.addAll(vipFuzzySearch.getVIPInPhoneNumberOnlyRetailer(message));

		} catch (java.rmi.RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showInformationDialog(DataRM.FAILED);
		}
		
	}
	
	@Override
	public void showSearchGoodsWin(List<GoodsVO> temp){
		
	}
}
