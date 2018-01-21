package ui.salesmanUI;

import VO.saleVO.SalesmanItemVO;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public class GoodsSearchResultCellForSalesmanController {

SalesmanItemVO vo;

	@FXML public Label id;
	@FXML public Label name;
	@FXML public CheckBox checkBox;
	@FXML public TextField amountTextField;
	@FXML public TextField priceTextField;
	@FXML public TextField notesTextField;
	
	@FXML
	void initialize(){
		id.setText(vo.getId()+"");
		name.setText(vo.getName());
		amountTextField.setText(vo.getAmount()+"");
		priceTextField.setText(vo.getPrice()+"");
		notesTextField.setText(vo.getNotes());
	}
	/**
	 * @param vo
	 */
	public GoodsSearchResultCellForSalesmanController(SalesmanItemVO vo) {
		// TODO Auto-generated constructor stub
		this.vo = vo;
	}

}
