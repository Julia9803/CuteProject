package ui.stockmanUI;

import blservice.goodsblservice.GoodsBLService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.goodsVO.GoodsCategoryVO;


public class NewGoodsORCategoryController {
    @FXML private AnchorPane root;
    @FXML private TextField name;
    @FXML public ChoiceBox nameType;
    @FXML Button sureBtn;
    @FXML Button cancelBtn;

    private static String type = "";
    private static String goodsID = "";

    GoodsBLService goodsBLService;
    GoodsController goodsController;
    private ArrayList<String> list = new ArrayList();
    private String newName = "";

    /**
     * 一个ArrayList存放 0：商品或分类 1：名称
     * @return
     */
    protected ArrayList<String> getList() {
        return list;
    }

    @FXML
    public void onSureBtnClicked() throws RemoteException{
        if(name.getText() == null) return;
        switch (name.getText()) {
            case "商品":
                type = "goods";
                //goodsID = goodsBLService.newGoods(name.getText(),goodsController.treeView.getSelectionModel().getSelectedItem().getParent().getValue().toString().substring(0,3));
                this.newName = name.getText();
                list.add(type);
                break;

            case "商品分类":
                type = "goodsCategory";
                TreeItem<String> currentNode = goodsController.treeView.getSelectionModel().getSelectedItem();
                String tmp = name.getText();
                while(!currentNode.getParent().getValue().contains("根节点")){
                    tmp = currentNode.getParent().getValue().toString().substring(3) + "/" + tmp;
                }
                GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO(tmp,"");
                int autoId = goodsBLService.newGoodsCategoryAutoId(goodsCategoryVO);
                GoodsCategoryVO gcvo = goodsBLService.getCategory(tmp,currentNode.getParent().getValue().toString().substring(3));
                gcvo.setAutoId(autoId);
                goodsBLService.modifyGoodsCategory(gcvo);
                this.newName = name.getText();
                list.add(type);
                break;

            default:
                list.add(name.getText());
                root.getScene().getWindow().hide();
        }
    }

    @FXML
    public void onCancelBtnClicked(){
        root.getScene().getWindow().hide();
    }
}
