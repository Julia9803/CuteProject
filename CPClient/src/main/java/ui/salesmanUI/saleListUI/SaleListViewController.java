package ui.salesmanUI.saleListUI;

import java.io.IOException;
import java.util.List;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import ui.commonUI.ParentController;
import ui.salesmanUI.CellController;
import ui.salesmanUI.ListViewController;
import ui.salesmanUI.SalesmanController;

/**     
* @author 李安迪
* @date 2017年12月29日
* @description
*/
public class SaleListViewController extends ListViewController implements ParentController {

	/**
	 * @param controller
	 * @param service
	 * @param list
	 */
	public SaleListViewController(SalesmanController controller, SaleUniBLService service, List<SalesmanListVO> list) {
		super(controller, service, list);
	}

	@Override
	public void refresh() {
		vBox.getChildren().clear();
		if(list != null)
		for(SalesmanListVO vo : list){
	  		 CellController controller = generateCellController(vo);
    		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/salesmanUI/SaleTypeList.fxml"));
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

	public CellController generateCellController(SalesmanListVO vo) {
		CellController controller = 
				    new SaleListCellController(this,vo);
		return controller;
	}

	/* (non-Javadoc)
	 * @see ui.commonUI.ParentController#CloseSonWin()
	 */
	@Override
	public void CloseSonWin() {
		
	}
}
