package ui.commonUI;

import VO.GoodsInSaleVO;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description
*/
public class GoodsSearchResultCellController {
	
	GoodsInSaleVO vo;
	
	@FXML public Label id;
	@FXML public Label name;
	@FXML public TextField amountTextField;
	@FXML public CheckBox checkBox;
	
	public GoodsSearchResultCellController(GoodsInSaleVO vo){
		this.vo = vo;
	}
	
	@FXML
	void initialize(){
		id.setText(vo.getId()+"");
		name.setText(vo.getGoodsName());
	}
	
	
}
