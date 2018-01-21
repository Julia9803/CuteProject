package ui.salesmanUI.saleListUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SaleVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import bl.utility.GoodsVOTrans;
import blservice.saleblservice.SaleListBLService;
import blservice.saleblservice.SaleUniBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import resultmessage.DataRM;
import ui.commonUI.ConfirmHelper;
import ui.commonUI.ParentController;
import ui.commonUI.PromptHelper;
import ui.mainUI.loginUI.User;
import ui.managerUI.PresentNoEditCellController;
import ui.managerUI.SinglePresentController;
import ui.salesmanUI.CellController;
import ui.salesmanUI.NoEditCellController;
import ui.salesmanUI.sale.RebateChecker;
import ui.salesmanUI.sale.SaleTypeNewListController;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class SaleNewListController extends SaleTypeNewListController implements SinglePresentController, CellController{

	PresentResultVO presentResult;
	
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public SaleNewListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
	}


	@Override
	public SalesmanListVO getVOFromUI(){
		return new SaleListVO(id,operator.getText(),operatorId, null,operatorGrade,VIPID.getText(),
				VIPName.getText(),grade, clerk.getText(), "默认仓库", notesTextField.getText(),chosenList,
				Double.parseDouble(sumAfterRebateLabel.getText()),Double.parseDouble(totalAmount.getText()), Double.parseDouble(rebateField.getText()), Double.parseDouble(useVoucherField.getText()), presentResult); 
	}

	public void refreshInValid() {
		goodsListVBox.getChildren().clear();
		for(SalesmanItemVO vo : chosenList){
			NoEditCellController controller = 
   				    new NoEditCellController(this,vo);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        cellUrl));
   				loader.setController(controller);
   				addChildrenForVBox(loader);
		}
	}	

	protected void Invalid(){
		
			notesTextField.setEditable(false);
	rebateField.setEditable(false);
	useVoucherField.setEditable(false);
	clerk.setEditable(false);
	
	//将无用的控件set invisible
	selectVIPBtn.setVisible(false);
	searchVIPField.setVisible(false);
	selectGoodsBtn.setVisible(false);
	searchGoodsField.setVisible(false);
	
	getPresentBtn.setVisible(false);	
	refreshInValid();
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.sale.SaleTypeListController#findPresent()
	 */
	@FXML
	@Override
	protected void findPresent() {
		if(ConfirmHelper.showConfirmDialog()&&check()){
			Invalid();
		SaleListBLService service = (SaleListBLService)(uniBLService);
		SaleVO saleVO = null;
		List<GoodsInSaleVO> goodsList = GoodsVOTrans.SalesmanItemTransGoodsInList(chosenList);
		try{
		saleVO = new SaleVO(grade,goodsList,Double.parseDouble(sumAfterRebateLabel.getText()));
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
		List<Integer> temp = new ArrayList<Integer>();
		
		if(!presentHBox.getChildren().isEmpty()){
		List<Node> list = presentHBox.getChildren();
			for(Node n : list){
				temp.add(Integer.parseInt(((Button)n).getText()));
			}
		}
		if(presentId != null){
			for(Integer i : presentId){
				if(!temp.contains(i)){
			Button b = new Button(i+"");
			presentHBox.getChildren().add(b);
			System.out.println("presentID is" + i + "");
				}
			}
		}

		//显示特价商品列表
		List<GoodsInSaleVO> presentList = presentResult.getPresentList();
		if(presentList!=null){
			setPresentList(presentList);
		}
		
		}
	}


	/* (non-Javadoc)
	 * @see ui.managerUI.SinglePresentController#setPresentList(java.util.List)
	 */
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
	
	@Override
	public boolean checkFormat(){
		
    	try{
    	sumAfterRebateLabel.setText(Double.parseDouble(totalAmount.getText()) -
        		Double.parseDouble(rebateField.getText())
        		-Double.parseDouble(useVoucherField.getText())+"");
    	}catch(Exception e){
    		PromptHelper.showPrompt(DataRM.FORMAT_FAILED);
    		e.printStackTrace();
    		return false;
     }
    	if((Double.parseDouble(totalAmount.getText())<0)||(Double.parseDouble(rebateField.getText())<0)||(Double.parseDouble(useVoucherField.getText())<0)||(Double.parseDouble(sumAfterRebateLabel.getText())<0))
			{
    		System.out.println("ready to return false");
    		PromptHelper.showPrompt(DataRM.FORMAT_FAILED);
    		return false;
			}
	
 //   	System.out.println(User.getInstance().getGrade());
    	if(Double.parseDouble(rebateField.getText())>RebateChecker.getRebateLimit(User.getInstance().getUserType(),User.getInstance().getGrade()))
    	{
    		PromptHelper.showPrompt(DataRM.REBATE_FAILED);
    		return false;
    	}
		return true;
		
	}
}
