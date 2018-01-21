package ui.commonUI;

import com.jfoenix.controls.JFXButton;

import VO.listVO.BussinessSituationListVO;
import bl.listbl.ListblController;
import blservice.listblservice.Listblservice;
import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class BussinessSituationController {
    @FXML  Label b1;
    @FXML  Label b2;
    @FXML  Label b3;
    @FXML  Label b4;
    @FXML  Label b5;
    @FXML  Label b6;
    @FXML  Label b7;
    @FXML  Label b8;
    @FXML  Label b9;
    @FXML  Label b10;
    @FXML  Label b11;
    @FXML Label rmLabel;
    @FXML
    JFXButton toExcelBtn;
    Listblservice service=new ListblController();
    @FXML
    public void toExcel(){
    	String path="D:\\经营情况.xls";
        service.bussinessSituationToExcel(path);
        rmLabel.setText("导出成功至"+path);
    }

    public void set(BussinessSituationListVO vo){
        b1.setText(Double.toString(vo.overflowIncome));
        b2.setText(Double.toString(vo.salesIncome));
        b3.setText(Double.toString(vo.stockReturnIncome));
        b4.setText(Double.toString(vo.salesDiscount));
        b5.setText(Double.toString(vo.Income));
        b6.setText(Double.toString(vo.Income-vo.Outcome));
        b7.setText(Double.toString(vo.lossOutcome));
        b8.setText(Double.toString(vo.stockOutcome));
        b9.setText(Double.toString(vo.stockReturnIncome));
       // b10.setText(Double.toString());
        //商品赠出先没有
        b11.setText(Double.toString(vo.stockOutcome));

    }
}
