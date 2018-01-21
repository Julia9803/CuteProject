package bl.userbl;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import PO.user.UserPO;
import VO.userVO.UserVO;
import blservice.userblservice.AdministratorService;
import dataService.userDataService.UserDataService;
import network.userRemoteHelper.UserDataServiceHelper;
import resultmessage.NewUserRM;

public class AdministratorServiceImpl implements AdministratorService{

	UserDataService dataService = UserDataServiceHelper.getInstance().getDataService();
	VOPOTransformer vopotransformer = new VOPOTransformer();

	@Override
	public NewUserRM checkNewUserName(String name) {
		try {
			if(dataService.getUser(name) != null){
				return NewUserRM.EXIST;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return NewUserRM.VALID;
	}

	@Override
	public void initAndSave(UserVO vo) throws RemoteException{
		UserPO po = vopotransformer.voTopo(vo);
		dataService.insert(po);
	}

	@Override
	public void delete(String name) throws RemoteException {
		dataService.delete(name);
	}

	@Override
	public void modify(UserVO vo) throws RemoteException {
		UserPO po = vopotransformer.voTopo(vo);
		try{
			dataService.update(po);
		}
		catch(RemoteException e){
			dataService.insert(po);
		}
		
	}
	
	@Override
	public List<UserVO> getAllUser() {
		try {
			List<UserPO> poList = dataService.getAllUser();
			return poList.stream().map(e -> vopotransformer.poTovo(e)).collect(Collectors.toList());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	

}
