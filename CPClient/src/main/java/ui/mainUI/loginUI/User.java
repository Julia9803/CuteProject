package ui.mainUI.loginUI;

import java.text.SimpleDateFormat;
import java.util.Date;

import VO.userVO.UserVO;
import blservice.serviceFactory.UserBLFactory;
import blservice.userblservice.PersonalInfoService;
import resultmessage.LoginRM;
import util.UserGrade;
import util.UserPermission;
import util.UserType;

public class User {
	private PersonalInfoService service;
	private static User user;
	
	boolean loggedIn = false;		
									
	private String id;
	private	String name;
	private	UserType type = UserType.Salesman;				
	private	UserGrade grade;			//用户等级（经理，普通）
	private	UserPermission permission;		//权限等级
											//为了安全，密码不让界面层持有，不过userVO里是否要有密码？re：有密码的意义不是太大吧
											//re:re:修改用户信息，注册新用户时是要有密码的，那个vo没想好要不要和这个uservo共用
	private User(){
		service = UserBLFactory.getPersonalInfoService();
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
			this.id = uservo.getId();
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

	public static String calcTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		String s=df.format(new Date());
		return s;
	}
	
	public static String calcPreciseTime(){
		//计算精确到秒的时间
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String s=df.format(new Date());
		return s;
	}

	
}
