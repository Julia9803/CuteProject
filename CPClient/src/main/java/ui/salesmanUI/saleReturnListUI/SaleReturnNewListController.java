package ui.salesmanUI.saleReturnListUI;

import VO.saleVO.SaleReturnListVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import ui.commonUI.ParentController;
import ui.salesmanUI.sale.SaleTypeNewListController;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class SaleReturnNewListController extends SaleTypeNewListController {

	
	@Override
	@FXML
	protected void initialize(){
		super.initialize();
		//将无用的控件set invisible
		saleListPane.setVisible(false);
//		getPresentBtn.setVisible(false);
//		presentHBox.setVisible(false);
//		presentListVBox.setVisible(false);
//		voucherInPresent.setVisible(false);
//		
//		presentListTitle.setVisible(false);
//		strategyTitle.setVisible(false);
	}
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public SaleReturnNewListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.sale.SaleTypeNewListController#findPresent()
	 */
	@FXML
	@Override
	protected void findPresent() {
		
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.SalesmanListWinController#getVOFromUI()
	 */
	@Override
	public SalesmanListVO getVOFromUI(){
		return new SaleReturnListVO(id,operator.getText(),operatorId, null,operatorGrade,VIPID.getText(),
				VIPName.getText(), null, "默认仓库", notesTextField.getText(), chosenList,
				Double.parseDouble(sumAfterRebateLabel.getText()),Double.parseDouble(totalAmount.getText()), Double.parseDouble(rebateField.getText()), Double.parseDouble(useVoucherField.getText())); 
	}

}
