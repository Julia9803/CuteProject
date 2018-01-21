package ui.salesmanUI.stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import VO.saleVO.SalesmanItemVO;
import bl.utility.GoodsVOTrans;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXMLLoader;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptHelper;
import ui.salesmanUI.GoodsSearchResultForSalesmanWin;
import ui.salesmanUI.SalesmanEditCellController;
import ui.salesmanUI.SalesmanListWinController;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description 
*/
public abstract class StockTypeListController extends SalesmanListWinController {

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public StockTypeListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.SalesmanListWinController#getVIPList(java.lang.String, java.util.List)
	 */
	@Override
	public void getVIPList(String message, List<VIPVO> temp) {	
		try {
			List<VIPVO> adder = new ArrayList<VIPVO>();
			if((adder =vipFuzzySearch.getVIPInIDOnlySeller(message))!=null)
				temp.addAll(adder);
			if((adder = vipFuzzySearch.getVIPInNameOnlySeller(message))!=null)
				temp.addAll(adder);
			if((adder = vipFuzzySearch.getVIPInPhoneNumberOnlySeller(message))!= null)
				temp.addAll(adder);

		} catch (java.rmi.RemoteException e) {
			e.printStackTrace();
			PromptHelper.showPrompt(DataRM.FAILED);
		}
		
	}
	
	@Override
	public void showSearchGoodsWin(List<GoodsVO> temp){
	try {
		new GoodsSearchResultForSalesmanWin(GoodsVOTrans.GoodsTransSalesmanItemInList(temp,this),this);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	/* (non-Javadoc)
	 * @see ui.salesmanUI.SalesmanListWinController#refresh()
	 */
	@Override
	public void refresh() {
		double totalAmountValue = 0;
			goodsListVBox.getChildren().clear();
			controllerList.clear();
			if(chosenList != null)
			for(SalesmanItemVO vo : chosenList){
	   		 SalesmanEditCellController controller = 
	   				    new SalesmanEditCellController(this,vo);
	   		 controllerList.add(controller);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        cellUrl));
	   				loader.setController(controller);
	   				addChildrenForVBox(loader);
         	totalAmountValue+= vo.getSum();
			}
			
			//更新总价
			totalAmount.setText(totalAmountValue+"");
		
		}	

	
	


}
