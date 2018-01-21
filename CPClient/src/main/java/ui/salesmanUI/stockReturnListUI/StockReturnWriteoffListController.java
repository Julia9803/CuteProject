package ui.salesmanUI.stockReturnListUI;

import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockReturnListVO;
import bl.salebl.SaleBLFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import resultmessage.DataRM;
import ui.commonUI.PromptHelper;
import ui.mainUI.loginUI.User;
import ui.salesmanUI.IdChecker;
import ui.salesmanUI.ListViewController;
import util.UserType;

/**     
* @author 李安迪
* @date 2018年1月8日
* @description
*/
public class StockReturnWriteoffListController extends StockReturnListCellController{




	/**
	 * @param stockReturnListViewController
	 * @param vo
	 */
	public StockReturnWriteoffListController(ListViewController stockReturnListViewController, SalesmanListVO vo,String id) {
		super(stockReturnListViewController, vo);
		this.uniBLService = SaleBLFactory.getStockReturnListBLService();
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
   		 StockReturnWriteoffEditController controller = new StockReturnWriteoffEditController(null,SaleBLFactory.getStockReturnListBLService(),vo.getId(),vo);
   		 FXMLLoader loader = new FXMLLoader(
   				    getClass().getResource(
   				        "/fxml/salesmanUI/StockTypeList.fxml"));
   				loader.setController(controller);
   				root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	});
		}
	}


	public SalesmanListVO getMinusVOFromUI() {
		return new StockReturnListVO(id,operator.getText(),operatorId,null,operatorGrade,VIPID.getText(),VIPName.getText(),null,"默认仓库",notesTextField.getText(),chosenList,-Double.parseDouble(totalAmount.getText()));
	}

	
}
