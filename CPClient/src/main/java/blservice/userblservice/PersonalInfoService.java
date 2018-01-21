package blservice.userblservice;

import java.util.List;

import VO.userVO.MessageVO;
import VO.userVO.UserVO;
import resultmessage.LoginRM;
import resultmessage.ResultMessage;

public interface PersonalInfoService {

	 public LoginRM login(String name, String password);					//登录账户
	 public void logout();												//登出账户
	 public UserVO getCurrentUserInfo();										//得到当前用户个人信息
	 public ResultMessage changePassword(String oldPassword,String newPassword);//修改密码
	 public List<MessageVO> checkMessage();										//查看消息
	    
	    
}
