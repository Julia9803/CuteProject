package ui.stockmanUI;

import VO.storeVO.AlarmListVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class AlarmListItemController {
     @FXML Label listID;
     @FXML Label goodsID;
     @FXML Label goodsName;
     @FXML Label alarmNum;
     @FXML Label currentNum;
     @FXML Pane pane;
     
     public void set(AlarmListVO vo){
    	 if(vo==null){
    		 System.out.println("没有VO！！");
    	 }
    	 listID.setText(vo.listID);
    	 goodsID.setText(vo.goodsID);
    	 goodsName.setText(vo.goodsName);
    	 alarmNum.setText(Integer.toString(vo.alarmNum));
    	 currentNum.setText(Integer.toString(vo.currentNum));
    	
     }
     
}
