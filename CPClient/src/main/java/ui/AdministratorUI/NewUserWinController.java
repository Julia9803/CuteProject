package ui.AdministratorUI;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import VO.userVO.UserVO;
import blservice.serviceFactory.UserBLFactory;
import blservice.userblservice.AdministratorService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import resultmessage.NewUserRM;
import ui.commonUI.ParentController;
import ui.commonUI.PromptWin;
import ui.commonUI.SonController;
import util.UserGrade;
import util.UserPermission;
import util.UserType;

public class NewUserWinController implements SonController{
	
	@FXML AnchorPane root;

	@FXML Label titleLabel;
	@FXML Button saveBtn;
	@FXML ComboBox<String> userTypeComboBox; 
	@FXML TextField userNameTextField;
	@FXML Label userNamePromptLabel;
	@FXML TextField passwordTextField;
	@FXML ComboBox<String> userGradeComboBox;
	@FXML ComboBox<Integer> userPermissionComboBox;
	
	List<UserType> userTypeList;
	List<UserGrade> userGradeList;
	List<UserPermission> userPermissionList;
	
	ParentController parentcontroller;
	
	AdministratorService service = UserBLFactory.getAdministratorService();
	
	
	@Override
	public void setParentController(ParentController controller) {
		this.parentcontroller = controller;
	}
	
	@FXML 
	public void initialize(){
		initComboBox();
	}
	
	protected void initComboBox(){
		userTypeList = Arrays.asList(UserType.values());
		this.userTypeComboBox.getItems().addAll(userTypeList.stream().map(e -> e.getName()).collect(Collectors.toList()));
		
		userGradeList = Arrays.asList(UserGrade.values());
		this.userGradeComboBox.getItems().addAll(userGradeList.stream().map(e -> e.getName()).collect(Collectors.toList()));
		
		userPermissionList = Arrays.asList(UserPermission.values());
		this.userPermissionComboBox.getItems().addAll(userPermissionList.stream().map(e -> e.getPermission()).collect(Collectors.toList()));
	
	}
	
	@FXML 
	public void onUserNameInput(){		
		NewUserRM rm = service.checkNewUserName(userNameTextField.getText());
		switch(rm){
		case EXIST:
			userNamePromptLabel.setText("该用户名已存在");
//			clearUserNamePrompt();
			break;
		case INVALID:
			userNamePromptLabel.setText("用户名不合法");
//			clearUserNamePrompt();
			break;
		case VALID:
			userNamePromptLabel.setText("ok");
//			clearUserNamePrompt();
			break;
		default:
			break;
		}
	}
	
//	private static final long promptTime = 1000;
//	private void clearUserNamePrompt(){
//		new Timer().schedule(new TimerTask(){
//			public void run(){
//				Platform.runLater(new Runnable() {
//			        @Override
//			        public void run() {
//			        	userNamePromptLabel.setText("");
//			        }
//			   });
//				
//			}
//		}, promptTime);
//	}
	
	@FXML 
	public void onSaveBtnClicked(){
		
		if(isInputValid() == false) return;
		
		String userName = userNameTextField.getText();
		
		String password = passwordTextField.getText();
		
		UserType userType = null;
		for(UserType t : UserType.values()){
			if(t.getName().equals(userTypeComboBox.getValue()))
			{
				userType = t;
				break;
			}
		}
		UserGrade userGrade = null;
		for(UserGrade g : UserGrade.values()){
			if(g.getName().equals(userGradeComboBox.getValue()))
			{
				userGrade = g;
				break;
			}
		}
		
		UserPermission userPermission = null;
		for(UserPermission p : UserPermission.values()){
			if(userPermissionComboBox.getValue().intValue() == (p.getPermission()))
			{
				userPermission = p;
				break;
			}
		}
		
		UserVO vo = new UserVO(userName,
							password,
							userType,
							userGrade,
							userPermission
						);
		
		try {
			service.initAndSave(vo);
		} catch (RemoteException e1) {
			e1.printStackTrace();
			prompt("网络异常，请稍后再试");
			return;
		}
		
		prompt("保存成功！");
		
		this.parentcontroller.CloseSonWin();
		
	}
	
	private boolean isInputValid(){
		if(userTypeComboBox.getValue() == null || userTypeComboBox.getValue().equals("")){
			userTypeComboBox.setPromptText("请选择用户类型");
			return false;
		}
		if(userNameTextField.getText().equals("")){
			userNameTextField.setPromptText("请输入用户名");
			return false;
		}
		if(passwordTextField.getText().equals("")){
			passwordTextField.setPromptText("请输入用户密码");
			return false;
		}
		if(userGradeComboBox.getValue() == null || userGradeComboBox.getValue().equals("")){
			userGradeComboBox.setPromptText("请选择用户等级");
			return false;
		}
		if(userPermissionComboBox.getValue() == null || userPermissionComboBox.getValue().equals("")){
			userPermissionComboBox.setPromptText("请选择用户权限等级");
			return false;
		}
		
		NewUserRM rm = service.checkNewUserName(userNameTextField.getText());
		switch(rm){
		case EXIST:
			userNamePromptLabel.setText("该用户名已存在!");
			return false;
		case INVALID:
			userNamePromptLabel.setText("用户名不合法!");
			return false;
		case VALID:
			break;
		default:
			break;
		}
		return true;
	}

	
	private void prompt(String text){
		try {
			new PromptWin(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
