package ui.commonUI;

import VO.listVO.InfoListVO;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class InfoListController {
 @FXML
    Label id;
 @FXML
    Label operator;
 @FXML
    Label type;
 @FXML TextArea note;
 @FXML CheckBox isChosen;
 
 public void set(InfoListVO vo){
	 id.setText(vo.id);;
	 operator.setText(vo.operator);
	 type.setText(vo.type.toString());
	 note.setText(vo.note);
	 note.setEditable(false);
 }
}
