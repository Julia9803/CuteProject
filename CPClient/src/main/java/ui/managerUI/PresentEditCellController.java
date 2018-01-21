package ui.managerUI;

import VO.GoodsInSaleVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**     
* @author 李安迪
* @date 2017年12月15日
* @description
*/
public class PresentEditCellController {
	@FXML Label name;
	@FXML Label amount;
	@FXML Button deleteBtn;
	

	
	protected GoodsInSaleVO vo;
	
	private SinglePresentEditableController controller;
	/**
	 * @param presentForSumController
	 */
	public PresentEditCellController(SinglePresentEditableController controller,GoodsInSaleVO vo) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.vo = vo;
	}

	@FXML void initialize(){
		name.setText(vo.getGoodsName());
		amount.setText(vo.getAmount()+"");

		
	}
	@FXML void delete(){

		controller.deleteFromPresentList(vo);
	}
	
	boolean isValid(){
		//检查总额合法性
		String amountInString = amount.getText();
		@SuppressWarnings("unused")
		double amount = 0;
		try{
			amount = Double.parseDouble(amountInString);
		}catch(Exception e){
			return false;
		}
		
		return true;
	
	}
}
