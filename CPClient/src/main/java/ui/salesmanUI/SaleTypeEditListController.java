package ui.salesmanUI;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ui.commonUI.ParentController;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public class SaleTypeEditListController extends SaleTypeListController {

	
	@FXML protected Button commitBtn;
	@FXML protected Button saveBtn;
	@FXML protected Button cancelBtn;
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public SaleTypeEditListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	void commit(){
		
	}
	
	@FXML
	void save(){
		
	}
	
	@FXML
	void cancel(){
		
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.SalesmanListWinController#getVIPList(java.lang.String, java.util.List)
	 */
	@Override
	public void getVIPList(String message, List<VIPVO> temp) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.SalesmanListWinController#refresh()
	 */
	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.SalesmanListWinController#showSearchGoodsWin(java.util.List)
	 */
	@Override
	public void showSearchGoodsWin(List<GoodsVO> temp) {
		// TODO Auto-generated method stub
		
	}

}
