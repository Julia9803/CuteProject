package ui.stockmanUI;

import VO.storeVO.ReportListVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ReportListItemController {
       @FXML Label listID;
       @FXML Label goodsID;
       @FXML Label goodsName;
       @FXML Label state;
       @FXML Label num;
       @FXML Label actualNum;
       @FXML Button btn;
       ReportListVO reportListVO ;
       
      @FXML public void openList(){
    	   System.out.println("打开一张具体单据");
       }
      
      public void set(ReportListVO vo){
    	  this.reportListVO=vo;
    	  listID.setText(vo.listID);
    	  goodsID.setText(vo.goodsID);
    	  goodsName.setText(vo.GoodsName);
    	  state.setText("待审批单据");
    	  num.setText(Integer.toString(vo.Num));
    	  actualNum.setText(Integer.toString(vo.actualNum));
      }
}
