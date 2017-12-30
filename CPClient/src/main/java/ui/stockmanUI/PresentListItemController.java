package ui.stockmanUI;

import VO.storeVO.PresentListVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PresentListItemController {
    @FXML Label listID;
    @FXML Label state;
    @FXML Label VIP;
    @FXML Label time;
    @FXML Button btn;
    PresentListVO presentListVO;
    public void set(PresentListVO vo){
    	if(vo==null){
    		System.out.println("没有VO！");
    	}
    	this.presentListVO=vo;
    	listID.setText(vo.listID);
    	state.setText("草稿单据");
    	VIP.setText(vo.VIPname);
    	time.setText(vo.time);
    }
    
    @FXML public void openList(){
    	System.out.println("打开这张库存赠送单");
    }
}
