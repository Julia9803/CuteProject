package bl.userbl;

import java.util.ArrayList;
import java.util.List;

import VO.userVO.MessageVO;
import VO.userVO.OperationVO;
import VO.userVO.UserVO;
import blservice.userblservice.PersonalInfoService;
import blservice.userblservice.UserBLService;
import resultmessage.LoginRM;
import resultmessage.ResultMessage;
import util.UserGrade;
import util.UserPermission;
import util.UserType;

public class UserBLService_Stub implements UserBLService, PersonalInfoService{
	
	protected static final MessageVO messagevo = null;
	protected static final UserVO uservo = new UserVO("007", "zzz","123",UserType.Accountant,UserGrade.General,UserPermission.Highest);
	protected static final OperationVO operationvo = null;
	
	
	@Override
	public LoginRM login(String name, String password) {
		if(!uservo.getName().equals(name))
			return LoginRM.USER_NOT_FOUND;
		if(!uservo.getPassword().equals(password))
			return LoginRM.WRONG_PASSWORD;
		return LoginRM.SUCCESS;
		}
	
	@Override
	public ResultMessage logout() {
		return ResultMessage.SUCCESS;
	}
	
	@Override
	public UserVO getCurrentUserInfo() {
		return uservo;
	}

	@Override
	public ResultMessage changePassword(String oldPassword, String newPassword) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<MessageVO> checkMessage() {
		List<MessageVO> list = new ArrayList<MessageVO>();
		list.add(messagevo);
		return list;
	}

	@Override
	public String newUser(String name) {
		return "大师";
	}

	@Override
	public ResultMessage initAndSave(UserVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(UserVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<UserVO> findUser(String info) {
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(uservo);
		return list;
	}

	@Override
	public List<OperationVO> viewLog() {
		List<OperationVO> list = new ArrayList<OperationVO>();
		list.add(operationvo);
		return list;
	}

	
	
}