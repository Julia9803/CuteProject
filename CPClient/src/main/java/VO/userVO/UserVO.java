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
		  
	public UserVO(String id,String name,String password,UserType type,UserGrade grade,UserPermission permission){
		  this.id=id;
		  this.name =name;
		  this.password=password;
		  this.type = type;
		  this.grade = grade;
		  this.permission = permission;
	}

		    
	public String getID(){
		 return id;
	}
		 
	public String getName(){
		 return name;
	}
	
	public String getPassword(){
		 return password;
	}

	public UserType getType(){
		 return type;
	}
	
    public UserGrade getGrade(){      	 
        return grade;
    }
    
    public UserPermission getPermission(){      	 
        return permission;
    }
    
}

