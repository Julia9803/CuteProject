package bl.userbl;

import java.rmi.RemoteException;
import java.util.List;

import PO.user.UserPO;
import VO.userVO.MessageVO;
import VO.userVO.UserVO;
import blservice.userblservice.PersonalInfoService;
import dataService.userDataService.UserDataService;
import network.userRemoteHelper.UserDataServiceHelper;
import resultmessage.LoginRM;
import resultmessage.ResultMessage;

public class PersonalInfoServiceImpl implements PersonalInfoService{

	UserDataService dataService = UserDataServiceHelper.getInstance().getDataService();
	VOPOTransformer vopoTransformer = new VOPOTransformer();
	UserVO uservo;
	
	@Override
	public LoginRM login(String name, String password) {
		UserPO po = null;
		try {
			po = dataService.getUser(name);
			if(po == null)
				return LoginRM.USER_NOT_FOUND;
			if(!password.equals(po.getPassword()))
				return LoginRM.WRONG_PASSWORD;
		} catch (RemoteException e) {
			e.printStackTrace();
			return LoginRM.NETWORK_ERROR;
		}
		uservo = vopoTransformer.poTovo(po);
		return LoginRM.SUCCESS;
	}

	@Override
	public void logout() {
		uservo = null;
	}

	@Override
	public UserVO getCurrentUserInfo() {
		return new UserVO(uservo);
	}

	@Override
	public ResultMessage changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageVO> checkMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
