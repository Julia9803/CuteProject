package ui.stockmanUI;

import java.io.IOException;

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
    	  // System.out.println("打开一张具体单据");
    	  try {
			ReportListWin win=new ReportListWin();
			win.controller.set(reportListVO);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	  
       }
      
      public void set(ReportListVO vo){
    	  this.reportListVO=vo;
    	  listID.setText(vo.listID);
    	  goodsID.setText(vo.goodsID);
    	  goodsName.setText(vo.GoodsName);
    	  if(vo.statetype==null){System.out.println("没有初始化状态");}
    	  state.setText(vo.statetype.toString());
    	  num.setText(Integer.toString(vo.Num));
    	  actualNum.setText(Integer.toString(vo.actualNum));
      }
}
