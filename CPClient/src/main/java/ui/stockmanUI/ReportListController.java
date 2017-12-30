package ui.stockmanUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.State;
import util.StoreListType;


public class ReportListController {

	/*
	 * 库存报溢单/报损单的Controller,有四种初始化状态
	 * 第一种，在查看草稿单时打开
	 * 第二种，在新建时打开
	 * 第三种，在总经理查看审批时打开
	 * 第四种，在财务人员查看审批时打开
	 */
	@FXML Label listID;
	@FXML TextField goodsID;
	@FXML Label operator;
	@FXML Label time;
    @FXML  Label goodsName;
	@FXML  Label num;
	@FXML  Label delta;
	@FXML Label deltaLabel;
    @FXML Label title;
	@FXML Label rm;
	@FXML Button GoodsInfoBtn;
	@ FXML TextField actualNum;
	@ FXML Button btn1;
    @ FXML Button btn2;
    @ FXML Button btn3;

    @FXML public void Action1(){

    }

    @FXML public void Action2(){

    }

    @FXML public void Action3(){

    }

    @FXML public void getGoodsInfo(){

    }

    public void set(StoreListType type, State state){
        setType(type);
        setState(state);
        rm.setText("");
    }

    private   void setType(StoreListType type){
        if(type.equals(StoreListType.OVERFLOW)){
            title.setText("库存报溢单");
            deltaLabel.setText("报溢数量");
        }else {
            title.setText("库存报损单");
            deltaLabel.setText("报损数量");
        }

    }

    private   void setState(State state){
        if(state.equals(State.IsEditting)){
            delta.setVisible(false);
            deltaLabel.setVisible(false);
            btn1.setText("保存");
            btn2.setText("提交");//实际上是保存并提交
            btn3.setText("取消");
        }

    }


}
