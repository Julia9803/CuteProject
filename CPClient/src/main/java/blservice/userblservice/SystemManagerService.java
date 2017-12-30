package blservice.userblservice;

import java.util.List;

import VO.userVO.UserVO;
import resultmessage.ResultMessage;

public interface SystemManagerService {

	
    public String newUser(String name);											//创建新用户
    public ResultMessage initAndSave(UserVO vo);								//保存新用户信息
    public ResultMessage delete(String id);										//删除用户
    public ResultMessage modify(UserVO vo);										//修改用户信息
    public List<UserVO> findUser(String info);									//根据关键字查找用户

    
}
