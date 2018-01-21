package VO.userVO;

import util.UserGrade;
import util.UserPermission;
import util.UserType;

public class UserVO{
	private String id;
	private	String name;
	private	String password;
	private	UserType type;				
	private	UserGrade grade;			//用户等级（经理，普通）
	private	UserPermission permission;		//权限等级
		  
	public UserVO(){}
	public UserVO(String name,String password,UserType type,UserGrade grade,UserPermission permission){
		  this.setName(name);
		  this.setPassword(password);
		  this.setType(type);
		  this.setGrade(grade);
		  this.setPermission(permission);
	}
	public UserVO(String id,String name,String password,UserType type,UserGrade grade,UserPermission permission){
		  this.setId(id);
		  this.setName(name);
		  this.setPassword(password);
		  this.setType(type);
		  this.setGrade(grade);
		  this.setPermission(permission);
	}
	public UserVO(UserVO vo){
		this.setId(vo.id);
		this.setName(vo.name);
		this.setPassword(vo.password);
		this.setType(vo.type);
		this.setGrade(vo.grade);
		this.setPermission(vo.permission);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public UserGrade getGrade() {
		return grade;
	}
	public void setGrade(UserGrade grade) {
		this.grade = grade;
	}
	public UserPermission getPermission() {
		return permission;
	}
	public void setPermission(UserPermission permission) {
		this.permission = permission;
	}

		    
    
}

