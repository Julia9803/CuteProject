package ui.salesmanUI;

import java.io.IOException;
import java.util.List;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import bl.utility.GoodsVOTrans;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import resultmessage.DataRM;
import ui.commonUI.ParentController;

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
			temp.addAll(vipFuzzySearch.getVIPInIDOnlySeller(message));
			temp.addAll(vipFuzzySearch.getVIPInNameOnlySeller(message));
			temp.addAll(vipFuzzySearch.getVIPInPhoneNumberOnlySeller(message));

		} catch (java.rmi.RemoteException e) {
			e.printStackTrace();
			showInformationDialog(DataRM.FAILED);
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
			for(SalesmanItemVO vo : chosenList){
	   		 SalesmanEditCellController controller = 
	   				    new SalesmanEditCellController(this,vo);
	   		 controllerList.add(controller);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        cellUrl));
	   				loader.setController(controller);
	   				addChildrenForVBox(loader);
         	totalAmountValue+= controller.sumProperty.get();
			}
			
			//更新总价
			totalAmount.setText(totalAmountValue+"");
		
		}	
	
	@FXML
	void commit(){

		check();
		uniBLService.commit(getVOFromUI());
	}
	
	@FXML
	void save(){
		//保存
		uniBLService.save(getVOFromUI());		
	}
	

	//从ui界面得到所需的vo
	public abstract SalesmanListVO getVOFromUI();
}
