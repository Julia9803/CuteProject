package dataService.userDataService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.user.UserPO;
import resultmessage.DataRM;
public interface UserDataService extends Remote{

	public DataRM insert(UserPO po) throws RemoteException;
	public DataRM delete(String name) throws RemoteException;
	public DataRM update(UserPO po) throws RemoteException;
	public UserPO getUser(String Name) throws RemoteException;
	public List<UserPO> getAllUser() throws RemoteException;
	
}
