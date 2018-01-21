package dataService.userDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.user.MessagePO;
import resultmessage.DataRM;
import util.UserType;

public interface MessageDataService extends Remote{
	public List<MessagePO> getAllMessage(UserType type) throws RemoteException;
	public DataRM insert(MessagePO po) throws RemoteException;
}
