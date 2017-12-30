package ui.stockmanUI;

import java.rmi.RemoteException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import VO.goodsVO.GoodsVO;
import bl.goodsbl.GoodsBLServiceImpl;
import blservice.goodsblservice.GoodsBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 * Created by julia98 on 2017/12/11.
 */
public class GoodsInfoEditController {
    
    @FXML public AnchorPane root;
    @FXML public JFXTextField goodsName;
    @FXML public JFXTextField goodsType;
    @FXML public JFXTextField goodsID;
    @FXML public JFXTextField goodsCategory;
    @FXML public JFXTextField goodsStoreNum;
    @FXML public JFXTextField goodsSellPrice;
    @FXML public JFXTextField goodsBuyPrice;
    @FXML public JFXTextField recentBuyPrice;
    @FXML public JFXTextField recentSellPrice;
    @FXML public JFXButton saveGoodsInfoBtn;
    public GoodsVO goodsVO;
    public static String goods;
    GoodsBLService goodsBLService = new GoodsBLServiceImpl();

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
    @FXML
    public void initialize() throws RemoteException{
        
        init(goods);
        goodsName.setEditable(true);
        inputRequired(goodsName);
        goodsType.setEditable(true);
        inputRequired(goodsType);
        goodsID.setEditable(false);
        goodsCategory.setEditable(false);
        goodsStoreNum.setEditable(false);
        goodsBuyPrice.setEditable(true);
        inputRequired(goodsBuyPrice);
        goodsSellPrice.setEditable(true);
        inputRequired(goodsSellPrice);
        recentBuyPrice.setEditable(true);
        inputRequired(recentBuyPrice);
        recentSellPrice.setEditable(true);
        inputRequired(recentSellPrice);


        goodsName.setText(goodsVO.getGoodsName());
        goodsType.setText(goodsVO.getGoodsType());
        goodsID.setText(goodsVO.getGoodsID());
        goodsCategory.setText(goodsVO.getGoodsCategory());
        goodsStoreNum.setText("5");
        goodsSellPrice.setText(""+ goodsVO.getGoodsSellPrice());
        goodsBuyPrice.setText(""+ goodsVO.getGoodsBuyPrice());
        recentBuyPrice.setText(""+ goodsVO.recentBuyPrice());
        recentSellPrice.setText(""+ goodsVO.recentSellPrice());
    }

    public void init(String goods) throws RemoteException{
        System.out.println("controller" + goods);
        goodsVO = goodsBLService.getGoods(goods.substring(0,goods.indexOf('/')),goods.substring(goods.indexOf('/')+1,goods.length()));
        System.out.println(goodsVO.getGoodsName());
    }

    @FXML
    public void setSaveGoodsInfoBtn() throws RemoteException{
        
        goodsVO.setGoodsName(goodsName.getText());
        goodsVO.setGoodsType(goodsType.getText());
        goodsVO.setGoodsCategory(goodsCategory.getText());
        goodsVO.setGoodsBuyPrice(Double.parseDouble(goodsBuyPrice.getText()));
        goodsVO.setGoodsSellPrice(Double.parseDouble(goodsSellPrice.getText()));
        goodsVO.setRecentBuyPrice(Double.parseDouble(recentBuyPrice.getText()));
        goodsVO.setRecentSellPrice(Double.parseDouble(recentSellPrice.getText()));

        goodsBLService.modifyGoods(goodsVO);
        Platform.runLater(()->{
            root.getScene().getWindow().hide();
        });
    }
}
