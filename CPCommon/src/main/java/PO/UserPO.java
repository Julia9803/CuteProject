package PO;

import java.io.Serializable;

import util.UserGrade;
import util.UserType;

public class UserPO  implements Serializable{
	/**
	 * 编号
	 */
	String id;
	/**
	 * 名称
	 */
	String name;
	/**
	 * 密码
	 */
	String password;
	/**
	 * 是否有最高权限
	 */
	boolean hasHighestAuthority=false;
	/**
	 * 用户等级
	 */
	UserGrade grade;
	/**
	 * 用户类别
	 */	
	UserType type;

//	  public UserPO(String i,String n,String p,int l){
//	  id=i;
//	  name =n;
//	  password=p;
//	 level=l ;
//	  }
//
//	  public String getName(){
//	  return name;
//	  }
//	    
//	  public String getID(){
//	        return id;
//	  }
//	  
//	  public String getPassword(){
//	     return password;
//	  }
//
///*	  public UserRole getRole(){
//	     return role;
//	}*/
//   public int getLevel(){
//  	 
//  	 return level;
//   }
}
