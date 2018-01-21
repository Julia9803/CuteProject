package ui.salesmanUI.stockListUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import ui.commonUI.ParentController;
import ui.salesmanUI.stock.StockTypeEditListController;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class StockEditListController extends StockTypeEditListController{

	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 * @param vo
	 */
	public StockEditListController(ParentController parentController, SaleUniBLService uniBLService, String id,
			SalesmanListVO vo) {
		super(parentController, uniBLService, id, vo);
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.StockTypeListController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI() {
		return new StockListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,Double.parseDouble(totalAmount.getText()));
	}

	@Override
	@FXML
	protected
	void cancel(){
		if(parentController != null)
		this.parentController.CloseSonWin();
		else{
		     Platform.runLater(()-> {
		    	 try{
						root.getScene().getWindow().hide();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}); 
		}
	}

}
