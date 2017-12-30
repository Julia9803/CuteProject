package util;


/**     
* @author 李安迪
* @date 2017年10月27日
* @description 系统用户，分为库存管理人员,进货销售人员,财务人员,总经理,管理员
*/
public enum UserType {
	Stockman("库存管理人员"),
	Salesman("进货销售人员"),
	Accountant("财务人员"),
	Administrator("管理员"),
	GeneralManager("总经理");
	
	private final String userType;
	
	private UserType(String userType){
		this.userType = userType;
	}
	
	public String getName(){
		return this.userType;
	}
	
}
