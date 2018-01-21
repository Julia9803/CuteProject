package ui.salesmanUI.sale;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import VO.saleVO.SalesmanItemVO;
import bl.utility.GoodsVOTrans;
import blservice.saleblservice.SaleUniBLService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import resultmessage.DataRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptHelper;
import ui.salesmanUI.GoodsSearchResultForSalesmanWin;
import ui.salesmanUI.SalesmanEditCellController;
import ui.salesmanUI.SalesmanListWinController;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description 销售类单据继承这个方法
*/
public abstract class SaleTypeListController extends SalesmanListWinController {



	@FXML protected Label sumAfterRebateLabel;
	@FXML protected TextField rebateField;
	@FXML protected TextField useVoucherField;
	
	@FXML protected HBox presentHBox;
	@FXML protected Button getPresentBtn;
	@FXML protected Label voucherInPresent;
	@FXML protected VBox presentListVBox;
	
	@FXML protected Label presentListTitle;
	@FXML protected Label strategyTitle;
	
	@FXML protected AnchorPane saleListPane;
	protected VIPGrade grade;
	@FXML protected TextField clerk;
	/**
	 * @param parentController
	 * @param uniBLService
	 * @param id
	 */
	public SaleTypeListController(ParentController parentController, SaleUniBLService uniBLService, String id) {
		super(parentController, uniBLService, id);
	}

	/* (non-Javadoc)
	 * @see ui.salesmanUI.SalesmanListWinController#getVIPList(java.lang.String, java.util.List)
	 */
	@Override
	public void getVIPList(String message, List<VIPVO> temp) {
	
		try {
			List<VIPVO> adder = new ArrayList<VIPVO>();
			if((adder =vipFuzzySearch.getVIPInIDOnlyRetailer(message))!=null)
				temp.addAll(adder);
			if((adder = vipFuzzySearch.getVIPInNameOnlyRetailer(message))!=null)
				temp.addAll(adder);
			if((adder = vipFuzzySearch.getVIPInPhoneNumberOnlyRetailer(message))!= null)
				temp.addAll(adder);
//			temp.addAll(vipFuzzySearch.getVIPInIDOnlyRetailer(message));
//			temp.addAll(vipFuzzySearch.getVIPInNameOnlyRetailer(message));
//			temp.addAll(vipFuzzySearch.getVIPInPhoneNumberOnlyRetailer(message));

		} catch (java.rmi.RemoteException e) {
			e.printStackTrace();
			PromptHelper.showPrompt(DataRM.FAILED);
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
	
	@Override
	public void setVIP(VIPVO vo){
		super.setVIP(vo);
		grade = vo.getGrade();
		clerk.setText(vo.getClerk());
	}
	@Override
	@FXML
	protected void initialize(){
		super.initialize();
		sumAfterRebateLabel.setText(totalAmount.getText());
		rebateField.setText("0");
		useVoucherField.setText("0");
		totalAmount.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//            	try{
            	if(!rebateField.getText().isEmpty() && !useVoucherField.getText().isEmpty())
            	sumAfterRebateLabel.setText(Double.parseDouble(totalAmount.getText()) -
                		Double.parseDouble(rebateField.getText())
                		-Double.parseDouble(useVoucherField.getText())+"");
//            	}catch(Exception e){
//            		PromptHelper.showPrompt(DataRM.FORMAT_FAILED);
//            		e.printStackTrace();
//            		
//            	}
                
            }
        });	
		rebateField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//            	try{
            	if(!rebateField.getText().isEmpty() && !useVoucherField.getText().isEmpty())
            	sumAfterRebateLabel.setText(Double.parseDouble(totalAmount.getText()) -
                		Double.parseDouble(rebateField.getText())
                		-Double.parseDouble(useVoucherField.getText())+"");
//            	}catch(Exception e){
//            		PromptHelper.showPrompt(DataRM.FORMAT_FAILED);
//            		e.printStackTrace();
//            		
//            	}
                
            }
        });
		
		useVoucherField.textProperty().addListener(new ChangeListener<String>() {
	          @Override
	            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//	            	try{
	        	  if(!rebateField.getText().isEmpty() && !useVoucherField.getText().isEmpty())
	            	sumAfterRebateLabel.setText(Double.parseDouble(totalAmount.getText()) -
	                		Double.parseDouble(rebateField.getText())
	                		-Double.parseDouble(useVoucherField.getText())+"");
//	            	}catch(Exception e){
//	            		PromptHelper.showPrompt(DataRM.FORMAT_FAILED);
//	            		e.printStackTrace();
//	             }
	          }
        });
		
	}
	@Override
	public void refresh(){
	
		double totalAmountValue = 0;
		goodsListVBox.getChildren().clear();
		for(SalesmanItemVO vo : chosenList){
	   		 SalesmanEditCellController controller = 
	   				    new SalesmanEditCellController(this,vo);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        cellUrl));
	   				loader.setController(controller);
	   				addChildrenForVBox(loader);
	   	         	totalAmountValue+= vo.getSum();
	   				}
	   				//更新总价
	   				totalAmount.setText(totalAmountValue+"");
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
    	System.out.println(totalAmount.getText()+rebateField.getText()+useVoucherField.getText()+sumAfterRebateLabel.getText());
    	System.out.println((Double.parseDouble(totalAmount.getText())<0));
    	System.out.println((Double.parseDouble(rebateField.getText())<0));
    	System.out.println((Double.parseDouble(useVoucherField.getText())<0));
    	System.out.println((Double.parseDouble(sumAfterRebateLabel.getText())<0));   	
    	if((Double.parseDouble(totalAmount.getText())<0)||(Double.parseDouble(rebateField.getText())<0)||(Double.parseDouble(useVoucherField.getText())<0)||(Double.parseDouble(sumAfterRebateLabel.getText())<0))
			{
    		System.out.println("ready to return false");
    		return false;
			}else
		return true;
		
	}
	protected abstract void findPresent(); 
}
