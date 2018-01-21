package ui.salesmanUI;

import VO.saleVO.SalesmanItemVO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**     
* @author 李安迪
* @date 2017年12月27日
* @description
*/
public class SalesmanEditCellController {
	@FXML protected Label typeLabel;
	@FXML protected Label sumLabel;
	protected DoubleProperty sumProperty  = new SimpleDoubleProperty();

	@FXML protected Label priceTextField;

//	@FXML protected TextField priceTextField;
	protected DoubleProperty priceProperty  = new SimpleDoubleProperty();

	@FXML protected Label notesTextField;
//	@FXML protected TextField notesTextField;
	protected StringProperty notesProperty = new SimpleStringProperty(); 

	@FXML protected Label nameLabel;
	@FXML protected Label idLabel;
	@FXML protected Button deleteBtn;
	@FXML protected Label amountTextField;
//	@FXML protected TextField amountTextField;
//	protected Property<Integer> amountProperty = new SimpleIntegerProperty();
	protected IntegerProperty amountProperty  = new SimpleIntegerProperty();
	
	protected final String INIT_AMOUNT = "1";
	protected final int INIT_AMOUNT_INTEGER = 1;
	
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
		if(vo != null){
	    //设置初始值
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
		}
//		//绑定属性
//		notesTextField.textProperty().bindBidirectional(notesProperty);
//		
//		amountTextField.textProperty().bindBidirectional(amountProperty, new NumberStringConverter());
//		
//		priceTextField.textProperty().bindBidirectional(priceProperty,new NumberStringConverter());
//		 sumLabel.textProperty().bind(new StringBinding() {
//
//	            {
//	            	bind(amountTextField.textProperty(),priceTextField.textProperty());
////	                bind(amountProperty.asString(), priceProperty.asString());
//	            }
//
//	            @Override
//	            protected String computeValue() {
//	            	int amount;
//	            	double price;
//	            	try{
//	            	amount = Integer.parseInt(amountTextField.textProperty().getValue());
//	            	price = Double.parseDouble(priceTextField.textProperty().getValue());
//	            	}catch(Exception e){
//	            		return "";
//	            	}
//	        //        return amountProperty.getValue()*priceProperty.getValue()+"";
//	            	
//	            	return amount*price + "";
//	            }
//	        });	
		 
//		//设置监听器
//		    createCommitBinding(amountTextField).addListener((obs, oldText, newText) -> 
//            System.out.printf("changing amount"));
//	    amountTextField.textProperty().addListener((ChangeListener<? super String>) (o, oldVal, newVal) -> {controller.refresh();System.out.println("changing amount");});
//	    sumLabel.textProperty().addListener((ChangeListener<? super String>) (o, oldVal, newVal) -> controller.refresh());

	    //设置最初的总价
//		controller.totalAmount.setText(sumLabel.getText());
//		System.out.println(controller.totalAmount.getText());
		 
//		 //设置不可编辑
//		 amountTextField.setEditable(false);
//		 priceTextField.setEditable(false);
//		 notesTextField.setEditable(false);
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
	public boolean isValidForDouble(Label textField){
		String s = textField.getText();
		@SuppressWarnings("unused")
		double d;
		try{
			d = Double.parseDouble(s);
		}catch(Exception e){
			return false;
		}
		
		return true;
	}
	
	public boolean isValidForInt(Label textField){
		String s = textField.getText();
		@SuppressWarnings("unused")
		int d = 0;
		try{
			d = Integer.parseInt(s);
		}catch(Exception e){
			return false;
		}
		
		return true;
	}

}
