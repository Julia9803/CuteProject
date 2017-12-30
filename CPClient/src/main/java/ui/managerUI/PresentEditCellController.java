package ui.managerUI;

import VO.GoodsInSaleVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**     
* @author 李安迪
* @date 2017年12月15日
* @description
*/
public class PresentEditCellController {
	@FXML Label name;
	@FXML TextField amount;
	@FXML Button deleteBtn;
	
	private final String INIT_AMOUNT= "1";
	
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
		amount.setText(INIT_AMOUNT);
	}
	@FXML void delete(){
		//每次删除的时候删除vo,因为并没有保存vo中amount域的更改
		controller.deleteFromPresentList(vo);
	}
	
	boolean isValid(){
		//检查总额合法性
		String amountInString = amount.getText();
		double amount = 0;
		try{
			amount = Double.parseDouble(amountInString);
		}catch(Exception e){
			return false;
		}
		
		return true;
	
	}
}
