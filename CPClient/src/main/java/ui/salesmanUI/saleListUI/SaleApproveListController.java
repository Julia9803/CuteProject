package ui.salesmanUI.saleListUI;

import java.io.IOException;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SaleVO;
import VO.saleVO.SalesmanListVO;
import bl.utility.GoodsVOTrans;
import blservice.saleblservice.SaleListBLService;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptHelper;
import ui.managerUI.PresentNoEditCellController;
import ui.managerUI.SinglePresentController;
import ui.salesmanUI.sale.SaleTypeApproveListController;

/**     
* @author 李安迪
* @date 2018年1月1日
* @description
*/
public class SaleApproveListController extends SaleTypeApproveListController implements SinglePresentController{
	PresentResultVO presentResult;
	/**
	 * @param object
	 * @param saleListBLService
	 * @param id
	 * @param object2
	 */
	public SaleApproveListController(ParentController parentController, SaleUniBLService uniBLService, String id,
			SalesmanListVO vo) {
		super(parentController, uniBLService, id, vo);
		this.vo = uniBLService.get(id);
		SaleListVO svo = (SaleListVO)(this.vo);
		if(svo.getPresentResultVO() != null)
		presentResult = svo.getPresentResultVO();  
	}
	
	@Override
	public SalesmanListVO getVOFromUI(){
		return new SaleListVO(id,operator.getText(),operatorId, null,operatorGrade,VIPID.getText(),
				VIPName.getText(),grade, clerk.getText(), "默认仓库", notesTextField.getText(),chosenList,
				Double.parseDouble(sumAfterRebateLabel.getText()),Double.parseDouble(totalAmount.getText()), Double.parseDouble(rebateField.getText()), Double.parseDouble(useVoucherField.getText()), presentResult); 
	}


	/* (non-Javadoc)
	 * @see ui.salesmanUI.sale.SaleTypeListController#findPresent()
	 */
	@FXML
	@Override
	protected void findPresent() {
		SaleListBLService service = (SaleListBLService)(uniBLService);
		SaleVO saleVO = null;
		List<GoodsInSaleVO> goodsList = GoodsVOTrans.SalesmanItemTransGoodsInList(chosenList);
		try{
		saleVO = new SaleVO(grade,goodsList,Double.parseDouble(totalAmount.getText()));
		}catch(Exception e){
			DataRM rm = DataRM.FORMAT_FAILED;
			PromptHelper.showPrompt(rm);
			e.printStackTrace();
			return;
		}
		presentResult = service.findPresent(saleVO);
		
		if(presentResult == null){
			DataRM rm = DataRM.SUCCESS;
			PromptHelper.showPrompt(rm);
			return;
		}
		//显示在ui组件上
		System.out.println(presentResult);

		//显示金额
		voucherInPresent.setText(presentResult.getVoucher()+"");
		sumAfterRebateLabel.setText(presentResult.getSum()+"");
		//显示策略id
		List<Integer> presentId = presentResult.getPresentId();
		if(presentId != null){
			for(Integer i : presentId){
			Button b = new Button(i+"");
			presentHBox.getChildren().add(b);
			System.out.println("presentID is" + i + "");
			}
		}
		//显示特价商品列表
		List<GoodsInSaleVO> presentList = presentResult.getPresentList();
		if(presentList!=null){
			setPresentList(presentList);
		}
		
	}
	

@Override
public void setPresentList(List<GoodsInSaleVO> presentList) {
presentListVBox.getChildren().clear();
for(GoodsInSaleVO vo : presentList){
	 PresentNoEditCellController controller = 
			    new PresentNoEditCellController(this,vo);
	 FXMLLoader loader = new FXMLLoader(
			    getClass().getResource(
			        "/fxml/managerUI/PresentNoEditCell.fxml"));
			loader.setController(controller);
			AnchorPane presentroot = null;
		try {
			presentroot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	presentListVBox.getChildren().add(presentroot);
}

}

}
