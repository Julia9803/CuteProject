package dataService.accountDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.account.AccountPO;
import resultmessage.DataRM;
public interface AccountDataService extends Remote{
	
	List<AccountPO> getAllAccount() throws RemoteException;
	public DataRM deleteAllAccount() throws RemoteException;
	public DataRM insert(AccountPO po) throws RemoteException;
	public AccountPO get(String accountName) throws RemoteException;
	public DataRM update(AccountPO po) throws RemoteException;
	
}
