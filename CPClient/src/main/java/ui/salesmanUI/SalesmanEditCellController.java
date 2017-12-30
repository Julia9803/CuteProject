package ui.salesmanUI;

import VO.saleVO.SalesmanItemVO;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**     
* @author 李安迪
* @date 2017年12月27日
* @description
*/
public class SalesmanEditCellController {
	@FXML protected Label typeLabel;
	@FXML protected Label sumLabel;
	protected DoubleProperty sumProperty  = new SimpleDoubleProperty();

	@FXML protected TextField priceTextField;
	protected DoubleProperty priceProperty  = new SimpleDoubleProperty();

	@FXML protected TextField notesTextField;
	protected StringProperty notesProperty = new SimpleStringProperty(); 

	@FXML protected Label nameLabel;
	@FXML protected Label idLabel;
	@FXML protected Button deleteBtn;
	@FXML protected TextField amountTextField;
	protected IntegerProperty amountProperty  = new SimpleIntegerProperty();
	
	protected final String INIT_AMOUNT = "1";
	
	protected SalesmanItemVO vo;
	
	protected SalesmanListWinController controller;
	/**
	 * @param salesmanListWinController
	 * @param vo
	 */
	public SalesmanEditCellController(SalesmanListWinController salesmanListWinController, SalesmanItemVO vo) {
		// TODO Auto-generated constructor stub
		this.controller = salesmanListWinController;
		this.vo = vo;
	}
	
	@FXML void initialize(){
		//绑定属性
		notesTextField.textProperty().bind(notesProperty);
		
		amountTextField.textProperty().bind(amountProperty.asString());
		
		priceTextField.textProperty().bind(priceProperty.asString());
		 sumLabel.textProperty().bind(new StringBinding() {

	            {
	                bind(amountProperty.asString(), priceProperty.asString());
	            }

	            @Override
	            protected String computeValue() {
	                return amountProperty.getValue()*priceProperty.getValue()+"";
	            }
	        });	
		 
		//设置监听器
	    amountTextField.textProperty().addListener((ChangeListener<? super String>) (o, oldVal, newVal) -> controller.refresh());
	    priceTextField.textProperty().addListener((ChangeListener<? super String>) (o, oldVal, newVal) -> controller.refresh());
		
	    //设置初始值
		typeLabel.setText(vo.getType());
		sumLabel.setText(vo.getSum()+"");
		priceTextField.setText(vo.getPrice()+"");
		amountTextField.setText(INIT_AMOUNT);
		notesTextField.setText("");
		nameLabel.setText(vo.getName());
		idLabel.setText(vo.getId());
		

	}
	
	@FXML void delete(){
		controller.deleteFromchosenList(vo);
	}

	/**
	 * @return 条目是否合法
	 */
	public boolean isValid() {
		return isValidForDouble(priceTextField)&&isValidForInt(amountTextField);

	}
	public boolean isValidForDouble(TextField textField){
		String s = textField.getText();
		double d = 0;
		try{
			d = Double.parseDouble(s);
		}catch(Exception e){
			return false;
		}
		
		return true;
	}
	
	public boolean isValidForInt(TextField textField){
		String s = textField.getText();
		int d = 0;
		try{
			d = Integer.parseInt(s);
		}catch(Exception e){
			return false;
		}
		
		return true;
	}

}
