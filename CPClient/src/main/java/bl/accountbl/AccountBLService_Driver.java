package bl.accountbl;

import VO.accountVO.AccountVO;
import VO.accountVO.InitAccountVO;
import blservice.accountblservice.AccountBLService;
import resultmessage.ResultMessage;

/**
 * 这个驱动并不全，也没有填入具体信息，只给出了大致的模版。在写测试用例的时候再详细补充。
 * @author zxy
 */

public class AccountBLService_Driver {
	
	AccountBLService accountblService = new AccountBLService_Stub();
	
	protected static final InitAccountVO initAccountvo = null;	
	protected static final AccountVO accountvo = null;	
	protected static final String name = null;	
	protected static final String id = null;	
	
	public void drive() {
		if(accountblService.getGoodsInfo() == null)
			System.out.println("fail");
		
		if(accountblService.getVIPInfo() == null)
			System.out.println("fail");
		
		if(accountblService.saveInitAccountInfo(initAccountvo) != ResultMessage.SUCCESS)
			System.out.println("fail");
		
		if(accountblService.initAndSaveAccount(accountvo) != ResultMessage.SUCCESS)
			System.out.println("fail");
		
		
	}

}
