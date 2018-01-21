package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.List;

import VO.userVO.UserVO;
import resultmessage.NewUserRM;

public interface AdministratorService {
	
    public NewUserRM checkNewUserName(String name);							//创建新用户,输入用户名，返回用户是否存在
    public void initAndSave(UserVO vo) throws RemoteException;				//保存新用户信息
    public void delete(String name) throws RemoteException;					//删除用户
    public void modify(UserVO vo) throws RemoteException;					//修改用户信息

    public List<UserVO> getAllUser();										// 得到所有用户
}
