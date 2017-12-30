package blservice.accountblservice;

import java.util.List;

import VO.accountVO.AccountVO;
import resultmessage.ResultMessage;

public interface AccountManagementService {

	//添加账户
	 public ResultMessage initAndSaveAccount(AccountVO vo);
	 
	//删除账户
	public ResultMessage deleteAccount(String name);
	
	//修改账户
	public ResultMessage modifyAccount(AccountVO vo);
	
	//得到所有账户信息
	public List<AccountVO> findAccount();
}
