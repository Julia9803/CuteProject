package ui.managerUI;

import VO.GoodsInSaleVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**     
* @author 李安迪
* @date 2017年12月19日
* @description
*/
public class PresentNoEditCellController {
	@FXML Label name;
	@FXML Label amount;
	
	private GoodsInSaleVO vo;
	
	@SuppressWarnings("unused")
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
