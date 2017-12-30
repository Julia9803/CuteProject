package ui.salesmanUI;

import VO.VIPVO.VIPVO;
import VO.goodsVO.GoodsVO;
import bl.VIPbl.VIPBLServiceImpl;
import blservice.VIPblservice.VIPBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.rmi.RemoteException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

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

    public void init(String vip) throws RemoteException {
        System.out.println(vip);
        vipVO = vipBLService.getVIP(vip);

        name.setText(vipVO.getName());
        inputRequired(name);
        id.setText(vipVO.getId());
        inputRequired(id);
        category.setText(vipVO.getCategory());
        inputRequired(category);
        grade.setText(vipVO.getGrade());
        inputRequired(grade);
        phoneNumber.setText(vipVO.getPhoneNumber());
        inputRequired(phoneNumber);
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
        vipVO.setName(name.getText());
        vipVO.setId(id.getText());
        vipVO.setCategory(category.getText());
        vipVO.setGrade(grade.getText());
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

