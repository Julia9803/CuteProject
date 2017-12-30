package bl.userbl;

import blservice.userblservice.UserBLService;

/**
 * 这个驱动并不全，也没有填入具体信息，只给出了大致的模版。在写测试用例的时候再详细补充。
 * @author zxy
 */

public class UserBLService_Driver {
	UserBLService userblService = new UserBLService_Stub();
	
	String name;
	String id;
	String password;
	
	
	public void drive(){
//		if(userblService.login(name, password) != ResultMessage.SUCCESS)
//			System.out.println("fail");
		
		if(userblService.checkMessage() == null)
			System.out.println("fail");
		
	}
}
