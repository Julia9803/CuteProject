package ui.salesmanUI.vip;

import java.rmi.RemoteException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import VO.VIPVO.VIPVO;
import bl.VIPbl.VIPBLServiceImpl;
import blservice.VIPblservice.VIPBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import util.VIPGrade;

/**
 * Created by julia98 on 2017/12/22.
 */
public class VIPInfoEditController {
    @FXML public AnchorPane root;
    @FXML public JFXTextField name;
    @FXML public JFXTextField id;
    @FXML public JFXTextField category;
    @FXML public JFXTextField grade;
    @FXML public JFXTextField phoneNumber;
    @FXML public JFXTextField address;
    @FXML public JFXTextField email;
    @FXML public JFXTextField postcode;
    @FXML public JFXTextField collectionLimit;
    @FXML public JFXTextField collection;
    @FXML public JFXTextField clerk;
    @FXML public JFXTextField payment;
    @FXML public JFXButton saveVIPInfoBtn;
    public VIPVO vipVO;
    public static String vip;

    VIPBLService vipBLService = new VIPBLServiceImpl();

    @FXML
    public void initialize() throws RemoteException{
        init(vip);
    }
    
    public void inputRequired(JFXTextField textField) {
    	RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
        textField.getValidators().add(validator);
        textField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
            	textField.validate();
            }
        });
    }
    
    public boolean inputError(JFXTextField textField) {
        	if (!isNumeric(textField.getText())) {
            	textField.setText("请输入数字");
            	return false;
            }
        	return true;
    }

    public static boolean isNumeric(String str) {
    	if(str.contains(".")) {
    		str = str.substring(0, str.indexOf(".")) + str.substring(str.indexOf(".") + 1,str.length());
    	}
    	  for (int i = 0; i < str.length(); i++) {
    	   System.out.println(str.charAt(i));
    	   if (!Character.isDigit(str.charAt(i))) {
    		   System.out.println("输入字符不是数字");
    	    return false;
    	   }
    	  }
    	  System.out.println("输入字符是数字");
    	  return true;
    	 }
    
    public void init(String vip) throws RemoteException {
        System.out.println(vip);
        vipVO = vipBLService.getVIP(vip);

        name.setText(vipVO.getName());
        name.setEditable(false);
        inputRequired(name);
        id.setText(vipVO.getId());
        inputRequired(id);
        category.setText(vipVO.getCategory());
        inputRequired(category);
        grade.setText(vipVO.getGrade().toString());
        inputRequired(grade);
        phoneNumber.setText(vipVO.getPhoneNumber());
        inputError(phoneNumber);
        address.setText(vipVO.getAddress());
        inputRequired(address);
        email.setText(vipVO.getEmail());
        inputRequired(email);
        postcode.setText(vipVO.getPostCode());
        inputRequired(postcode);
        collectionLimit.setText(""+vipVO.getCollectionLimit());
        inputRequired(collectionLimit);
        collection.setText(""+vipVO.getCollection());
        inputRequired(collection);
        clerk.setText(vipVO.getClerk());
        inputRequired(clerk);
        payment.setText(""+vipVO.getPayment());
        inputRequired(payment);
    }

    @FXML
    public void setSaveVIPInfoBtn() throws RemoteException{
    	
    	    if(inputError(grade)&&
    	    inputError(phoneNumber)&&
    	    inputError(postcode)&&
    	    inputError(collectionLimit)&&
    	    inputError(collection)&&
    	    inputError(payment) == true) {
    	    
        vipVO.setName(name.getText());
        vipVO.setId(id.getText());
        vipVO.setCategory(category.getText());
        vipVO.setGrade(VIPGrade.getVIPGradeByString(grade.getText()));
        vipVO.setPhoneNumber(phoneNumber.getText());
        vipVO.setAddress(address.getText());
        vipVO.setEmail(email.getText());
        vipVO.setPostCode(postcode.getText());
        vipVO.setCollectionLimit(Double.parseDouble(collectionLimit.getText()));
        vipVO.setCollection(Double.parseDouble(collection.getText()));
        vipVO.setClerk(clerk.getText());
        vipVO.setPayment(Double.parseDouble(payment.getText()));

        vipBLService.modifyVIP(vipVO);
        Platform.runLater(()->{
            root.getScene().getWindow().hide();
        });
    }
    }
}

