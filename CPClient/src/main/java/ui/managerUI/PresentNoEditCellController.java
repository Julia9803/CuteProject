package ui.managerUI;

import VO.GoodsInSaleVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**     
* @author 李安迪
* @date 2017年12月19日
* @description
*/
public class PresentNoEditCellController {
	@FXML Label name;
	@FXML TextField amount;
	
	private GoodsInSaleVO vo;
	
	private SinglePresentController controller;
	/**
	 * @param presentForSumController
	 */
	public PresentNoEditCellController(SinglePresentController controller,GoodsInSaleVO vo) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.vo = vo;
	}

	@FXML void initialize(){
		name.setText(vo.getGoodsName());
		amount.setText(vo.getAmount()+"");
	}

}
