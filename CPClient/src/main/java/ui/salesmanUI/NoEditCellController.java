package ui.salesmanUI;



import VO.saleVO.SalesmanItemVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



/**     

* @author 李安迪

* @date 2017年12月29日

* @description 商品项

*/

public class NoEditCellController{

	@FXML protected Label typeLabel;

	@FXML protected Label sumLabel;

	@FXML protected Label priceTextField;
	@FXML protected Label amountTextField;
	@FXML protected Label notesTextField;
//	@FXML protected TextField priceTextField;

//	@FXML protected TextField notesTextField;

	@FXML protected Label nameLabel;

	@FXML protected Label idLabel;

	@FXML protected Button deleteBtn;

//	@FXML protected TextField amountTextField;

	

	protected SalesmanItemVO vo;

	

	/**

	 * @param stockListCellController

	 * @param vo

	 */

	public NoEditCellController(CellController stockListCellController, SalesmanItemVO vo) {

		this.vo = vo;

	}



	@FXML

	void initialize(){

	    //设置初始值
if(vo != null){
		typeLabel.setText(vo.getType());

		sumLabel.setText(vo.getSum()+"");

		priceTextField.setText(vo.getPrice()+"");

//		priceProperty.set(vo.getPrice());

		

	amountTextField.setText(vo.getAmount()+"");

	sumLabel.setText(vo.getSum()+"");

//		amountProperty.set(INIT_AMOUNT_INTEGER);

		

		notesTextField.setText(vo.getNotes());

		nameLabel.setText(vo.getName());

		idLabel.setText(vo.getId());

	

//		 amountTextField.setEditable(false);
//
//		 priceTextField.setEditable(false);
//
//		 notesTextField.setEditable(false);

}		 

		deleteBtn.setVisible(false);

	}



@FXML void delete(){}

}