package ui.stockmanUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import util.State;

public class PresentListController {
    @FXML ComboBox<String> goodsID;
    @FXML Label operator;
    @FXML Label listID;
    @FXML Label time;
    @FXML Label VIP;
    @FXML ComboBox<String> goodsName;
    @FXML ComboBox<Integer> goodsNum;
    @FXML Button btn1;
    @FXML Button btn2;
    @FXML Button btn3;
    @FXML Button addGoodsBtn;
    @FXML Button deleteGoodsBtn;
    @FXML Label rm;

    @FXML public void addGoods(){

    }
    @FXML public void deleteGoods(){

    }
    @FXML public void Action1(){

    }

    @FXML public void Action2(){

    }

    @FXML public void Action3(){

    }

    public void set(State state){
        rm.setText("");
        if(state.equals(State.IsEditting)){
            btn1.setText("保存");
            btn2.setText("提交");//实际上是保存并提交
            btn3.setText("取消");
        }
    }

}
