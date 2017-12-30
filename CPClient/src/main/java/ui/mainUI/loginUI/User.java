package ui.mainUI.loginUI;

import VO.userVO.UserVO;
import bl.userbl.UserBLService_Stub;
import blservice.userblservice.PersonalInfoService;
import resultmessage.LoginRM;
import util.UserGrade;
import util.UserPermission;
import util.UserType;

public class User {
	private PersonalInfoService service;
	private static User user;
	
	boolean loggedIn = false;		//是否登录，不知道有没有用。。re:按照现在的逻辑，如果在登出后getinstance的话，还是可以获得一个user对象的？
									//re:re：是的，现在登出后也能。不过没有关系吧。user类的含义是提供user相关的服务，不是一个用户。如果没有问题了就把注释删掉吧。
	
	private String id;
	private	String name;
	private	UserType type = UserType.Salesman;				
	private	UserGrade grade;			//用户等级（经理，普通）
	private	UserPermission permission;		//权限等级
											//为了安全，密码不让界面层持有，不过userVO里是否要有密码？re：有密码的意义不是太大吧
											//re:re:修改用户信息，注册新用户时是要有密码的，那个vo没想好要不要和这个uservo共用
	private User(){
		service = new UserBLService_Stub();
	}
	
	public static User getInstance(){
		if(user == null)
			user = new User();
		return user;
	}
	
	
	public LoginRM login(String username, String password){
		LoginRM loginrm = service.login(username, password);
		if(loginrm == LoginRM.SUCCESS){
			loggedIn = true;
			UserVO uservo = service.getCurrentUserInfo();
			this.id = uservo.getID();
			this.name = uservo.getName();
			this.type = uservo.getType();
			this.grade = uservo.getGrade();
			this.permission = uservo.getPermission();
		}
		
		return loginrm;
	}
	
	public void logout(){
		service.logout();
		user = null;
	}
	
	public UserType getUserType(){
		return type;
	}
	
	public String getUserName(){
		return name;
	}

	public String getId() {
		return id;
	}

	public UserGrade getGrade() {
		return grade;
	}

	public UserPermission getPermission() {
		return permission;
	}

	

	
}
