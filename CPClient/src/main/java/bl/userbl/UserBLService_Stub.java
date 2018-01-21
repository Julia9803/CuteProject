package bl.userbl;

import java.util.ArrayList;
import java.util.List;

import VO.userVO.MessageVO;
import VO.userVO.OperationVO;
import VO.userVO.UserVO;
import blservice.userblservice.AdministratorService;
import blservice.userblservice.OperationLogService;
import blservice.userblservice.PersonalInfoService;
import resultmessage.LoginRM;
import resultmessage.NewUserRM;
import resultmessage.ResultMessage;
import util.UserGrade;
import util.UserPermission;
import util.UserType;

public class UserBLService_Stub implements AdministratorService, PersonalInfoService, OperationLogService{
	
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
	public void logout() {
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
	public NewUserRM checkNewUserName(String name) {
		if(name.equals("abc"))
			return NewUserRM.EXIST;
		return NewUserRM.VALID;
	}

	@Override
	public void initAndSave(UserVO vo) {
	}

	@Override
	public void delete(String id) {
	}

	@Override
	public void modify(UserVO vo) {
	}


	@Override
	public List<OperationVO> viewLog() {
		List<OperationVO> list = new ArrayList<OperationVO>();
		list.add(operationvo);
		return list;
	}

	@Override
	public List<UserVO> getAllUser() {
		return null;
	}

	
	
}