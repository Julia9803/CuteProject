package PO.user;

import java.io.Serializable;

import util.UserGrade;
import util.UserPermission;
import util.UserType;

public class UserPO implements Serializable{
	
	private static final long serialVersionUID = -4406494595299352107L;
	private String id;		//弃用
	private	String name;
	private	String password;
	private	UserType type;				
	private	UserGrade grade;			//用户等级（经理，普通）
	private	UserPermission permission;		//权限等级
		  
	public UserPO(){}
	public UserPO(String name,String password,UserType type,UserGrade grade,UserPermission permission){
		  this.setName(name);
		  this.setPassword(password);
		  this.setType(type);
		  this.setGrade(grade);
		  this.setPermission(permission);
	}
	public UserPO(String id,String name,String password,UserType type,UserGrade grade,UserPermission permission){
		  this.setId(id);
		  this.setName(name);
		  this.setPassword(password);
		  this.setType(type);
		  this.setGrade(grade);
		  this.setPermission(permission);
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

