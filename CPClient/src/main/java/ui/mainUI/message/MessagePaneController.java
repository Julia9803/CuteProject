package ui.mainUI.message;

import VO.userVO.MessageVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import util.DateUtil;

public class MessagePaneController {

	@FXML Label titleLabel;
	@FXML Label dateLabel;
	@FXML TextArea contentTextArea;
	
	MessageVO vo;
	
	public MessagePaneController(MessageVO vo){
		this.vo = vo;
	}
	
	@FXML
	public void initialize(){
		titleLabel.setText(vo.getTitle());
		dateLabel.setText(DateUtil.getStringDate(vo.getDate()));
		contentTextArea.setText(vo.getContent());
	}

}
