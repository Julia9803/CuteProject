package blservice.userblservice;

import java.util.List;

import VO.userVO.MessageVO;
import VO.userVO.OperationVO;
import VO.userVO.UserVO;
import resultmessage.LoginRM;
import resultmessage.ResultMessage;

/**
 * 	此接口应该是没有用了
 * 
 */
	
public interface UserBLService {
	
	/*
	 * 每个用户所需的接口
	 */
    public LoginRM login(String name, String password);					//登录账户
    public ResultMessage logout();												//登出账户
    public UserVO getCurrentUserInfo();											//得到当前用户个人信息
    public ResultMessage changePassword(String oldPassword,String newPassword);	//修改密码
    public List<MessageVO> checkMessage();										//查看消息
    
    /*
     * 系统管理员所需的接口
     */
    public String newUser(String name);											//创建新用户
    public ResultMessage initAndSave(UserVO vo);								//保存新用户信息
    public ResultMessage delete(String id);										//删除用户
    public ResultMessage modify(UserVO vo);										//修改用户信息
    public List<UserVO> findUser(String info);									//根据关键字查找用户

    /*
     * 操作日志相关的接口
     */
    public List<OperationVO> viewLog();											//查看操作日志
//    public ResultMessage saveOperation(OperationVO vo);							//生成操作日志		//层内接口
}
