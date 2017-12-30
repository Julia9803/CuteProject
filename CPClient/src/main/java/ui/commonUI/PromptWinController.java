package ui.commonUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PromptWinController {
	@FXML Label promptText;
	
	public void setPromptText(String text){
		promptText.setText(text);
	}
}
