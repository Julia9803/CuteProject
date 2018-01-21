package blservice.accountblservice;

import java.util.List;

import VO.accountVO.AccountVO;

public interface AccountManagementService {

//	//添加账户
//	 public ResultMessage initAndSaveAccount(AccountVO vo);
//	 
//	//删除账户
//	public ResultMessage deleteAccount(String name);
//	
//	//修改账户
//	public ResultMessage modifyAccount(AccountVO vo);
	
	//得到所有账户信息
	public List<AccountVO> getAllAccount();
	
	//删除旧的账户信息，保存所有新的账户信息
	public void saveAllAccount(List<AccountVO> l);
	
	//得到指定账户信息
	public AccountVO getAccount(String accountName);
	
	//更新账户信息
	public void update(AccountVO vo);
}
