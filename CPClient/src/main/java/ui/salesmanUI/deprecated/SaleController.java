package ui.salesmanUI.deprecated;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.util.Duration;

public class SaleController {

	@FXML public MenuButton newBtn;
	@FXML public MenuButton lookBtn;
	@FXML public Button draftBtn;
	@FXML public Button messageBtn;
	@FXML public Button personBtn;
	@FXML public Label logOut;
	
	@FXML
	public Transition lookBtnTransition(){
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), newBtn);
		transition.setByX(0);
		transition.setByY(20);
		transition.play();
		return transition;
	}
	
	@FXML
	public Transition draftBtnTransition(){
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), newBtn);
		transition.setByX(0);
		transition.setByY(20);
		transition.play();
		return transition;
	}
	
	@FXML
	public Transition messageBtnTransition(){
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), newBtn);
		transition.setByX(0);
		transition.setByY(20);
		transition.play();
		return transition;
	}
	
	@FXML
	public Transition personBtnTransition(){
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), newBtn);
		transition.setByX(0);
		transition.setByY(20);
		transition.play();
		return transition;
	}
	
	@FXML
	public Transition newBtnTransition(){
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), newBtn);
		transition.setByX(0);
		transition.setByY(20);
		transition.play();
		return transition;
	}
	
	@FXML
	public void onNewBtnClicked() {
		
	}
	
}
