package ui.salesmanUI.saleReturnListUI;

import VO.saleVO.SaleReturnListVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import ui.commonUI.ParentController;
import ui.salesmanUI.sale.SaleTypeApproveListController;

/**     
* @author 李安迪
* @date 2018年1月1日
* @description
*/
public class SaleReturnApproveListController extends SaleTypeApproveListController{

	/**
	 * @param object
	 * @param saleListBLService
	 * @param id
	 * @param object2
	 */
	public SaleReturnApproveListController(ParentController parentController, SaleUniBLService uniBLService, String id,
			SalesmanListVO vo) {
		super(parentController, uniBLService, id, vo);
		this.vo = uniBLService.get(id);
	}
	
	@Override
	public SalesmanListVO getVOFromUI(){
		return new SaleReturnListVO(id,operator.getText(),operatorId, null,operatorGrade,VIPID.getText(),
				VIPName.getText(), null, "默认仓库", notesTextField.getText(), chosenList,
				Double.parseDouble(sumAfterRebateLabel.getText()),Double.parseDouble(totalAmount.getText()), Double.parseDouble(rebateField.getText()), Double.parseDouble(useVoucherField.getText())); 
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.sale.SaleTypeListController#findPresent()
	 */
	@Override
	@FXML
	protected void findPresent() {
		
	}



}
