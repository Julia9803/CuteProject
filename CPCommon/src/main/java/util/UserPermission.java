package util;

public enum UserPermission {
	Highest(5), 
	One(1);
	
	private final int permission;
	
	private UserPermission(int permission){
		this.permission = permission;
	}
	
	public int getPermission(){
		return permission;
	}
}
