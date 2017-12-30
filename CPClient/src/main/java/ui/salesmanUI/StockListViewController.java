package ui.salesmanUI;

import java.io.IOException;
import java.util.List;

import VO.presentVO.PresentForMembershipVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import ui.commonUI.ParentController;
import ui.managerUI.PresentForMembershipCellController;
import ui.managerUI.PresentNoEditCellController;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class StockListViewController extends ListViewController implements ParentController{

	/**
	 * @param controller
	 * @param service
	 * @param list
	 */
	public StockListViewController(SalesmanController controller, SaleUniBLService service,
			List<SalesmanListVO> list) {
		super(controller, service, list);
	}

	public void refresh() {
		vBox.getChildren().clear();
		if(list != null)
		for(SalesmanListVO vo : list){
	  		 StockListCellController controller = 
	   				    new StockListCellController(this,vo);
    		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/salesmanUI/StockListCell.fxml"));
   				loader.setController(controller);
   				AnchorPane presentroot = null;
				try {
					presentroot = loader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				vBox.getChildren().add(presentroot);
		}
	}

	/* (non-Javadoc)
	 * @see ui.commonUI.ParentController#CloseSonWin()
	 */
	@Override
	public void CloseSonWin() {
		// TODO Auto-generated method stub
		
	}


}
