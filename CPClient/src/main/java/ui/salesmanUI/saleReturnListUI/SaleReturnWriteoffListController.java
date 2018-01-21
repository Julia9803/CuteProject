package ui.salesmanUI.saleReturnListUI;

import VO.saleVO.SaleReturnListVO;
import VO.saleVO.SalesmanListVO;
import bl.salebl.SaleBLFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import resultmessage.DataRM;
import ui.commonUI.PromptHelper;
import ui.mainUI.loginUI.User;
import ui.salesmanUI.IdChecker;
import ui.salesmanUI.ListViewController;
import ui.salesmanUI.WriteoffHelper;
import util.UserType;

/**     
* @author 李安迪
* @date 2018年1月1日
* @description
*/
public class SaleReturnWriteoffListController extends SaleReturnListCellController{


	/**
	 * @param stockListViewController
	 * @param vo
	 */
	public SaleReturnWriteoffListController(ListViewController stockListViewController, SalesmanListVO vo,String id) {
		super(stockListViewController, vo);
		this.uniBLService = SaleBLFactory.getSaleReturnListBLService();
		this.vo = uniBLService.get(id);
	}

	@Override
	@FXML
	protected
	void initialize(){

		super.initialize();
		if(User.getInstance().getUserType() == UserType.GeneralManager){
			commitBtn.setVisible(false);
			saveBtn.setVisible(false);
			cancelBtn.setVisible(false);
			return;
		}
		commitBtn.setText("红冲");
		saveBtn.setText("复制");
		cancelBtn.setVisible(false);
	}

	//红冲
	@Override
	@FXML
	protected
	void commit(){
		SalesmanListVO vo = getMinusVOFromUI();
		if(IdChecker.checkId(uniBLService, vo)){
		DataRM rm = uniBLService.approve(getMinusVOFromUI(),true);
		PromptHelper.showPrompt(rm);
		}else{
			Platform.runLater(()->{
				root.getScene().getWindow().hide();
			});
		}
	}
		
	
	
	//红冲并复制
	@Override
	@FXML
	protected
	void save(){
		DataRM rm = uniBLService.approve(getMinusVOFromUI(),true);
		PromptHelper.showPrompt(rm);
		if(IdChecker.checkId(uniBLService, vo)){
		Platform.runLater(()->{
		try {
   		 SaleReturnWriteoffEditController controller = new SaleReturnWriteoffEditController(null,SaleBLFactory.getSaleReturnListBLService(),vo.getId(),vo);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/salesmanUI/SaleTypeList.fxml"));
   				loader.setController(controller);
   				root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
		}
	}

	//得到数值取反的vo

	public SalesmanListVO getMinusVOFromUI() {
		return new SaleReturnListVO(id,operator.getText(),operatorId, null,operatorGrade,VIPID.getText(),
				VIPName.getText(), null, "默认仓库", notesTextField.getText(), WriteoffHelper.getMinus(chosenList),
				-Double.parseDouble(sumAfterRebateLabel.getText()),-Double.parseDouble(totalAmount.getText()), -Double.parseDouble(rebateField.getText()), -Double.parseDouble(useVoucherField.getText())); 

	}	

}
