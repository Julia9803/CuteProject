package ui.mainUI.loginUI;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import resultmessage.LoginRM;
import util.UserType;

public class LoginController {
	@FXML public AnchorPane root;
	@FXML public TextField usernameTxt;
	@FXML public TextField passwordTxt;
	@FXML public Button loginBtn;
	@FXML Label usernameLabel;
	@FXML Label passwordLabel;
	

	private long displayTime = 1000;

	
	@FXML
	public void onLoginBtnClicked() {
		String username = usernameTxt.getText();
		String password = passwordTxt.getText();
		

		if(username == null||username.equals("")){
			usernameLabel.setText("用户名不能为空哦～");
			clearLabel(usernameLabel);
			passwordTxt.setText("");
			usernameTxt.requestFocus();
			return;
		}
		
		if(password == null||password.equals("")){
			passwordLabel.setText("密码不能为空哦～");
			clearLabel(passwordLabel);
			passwordTxt.requestFocus();
			return;
		}
				
		LoginRM loginRM = User.getInstance().login(username, password);
		switch(loginRM){
		case SUCCESS:{
			root.getScene().getWindow().hide();
			
			openWindow(User.getInstance().getUserType());
			break;
		}
		case USER_NOT_FOUND:{
			usernameLabel.setText("该用户不存在～");
			usernameTxt.setText("");
			passwordTxt.setText("");
			usernameTxt.requestFocus();
			clearLabel(usernameLabel);
			break;
		}
		case WRONG_PASSWORD:{
			System.out.println("password wrong");
			passwordLabel.setText("密码输错啦～");
			passwordTxt.setText("");
			passwordTxt.requestFocus();
			clearLabel(passwordLabel);
			break;
		}
		}
		
	}
	
	private void openWindow(UserType type){
		
		
		Platform.runLater(()->{
			try {
				switch(type){
				case Stockman:{
					new ui.stockmanUI.StockmanWin();
					break;
				}
				case Salesman:{
					new ui.salesmanUI.SaleWin();
					break;
				}
				case Accountant:{
					new ui.mainUI.accountantUI.AccountantWin();
					break;
				}
				case GeneralManager:{
					new ui.managerUI.ManagerWin();
					break;
				}
				case Administrator:{
					new ui.AdministratorUI.AdministratorWin();
					break;
				}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	private void clearLabel(Label label){
		new Timer().schedule(new TimerTask(){
			public void run(){
				Platform.runLater(new Runnable() {
			        @Override
			        public void run() {
			        	label.setText("");
			        }
			   });
				
			}
		}, displayTime);
	}

}
