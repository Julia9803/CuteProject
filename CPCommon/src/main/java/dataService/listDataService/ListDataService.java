package dataService.listDataService;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InfoListPO;
public interface ListDataService extends  Remote,Serializable {
	public void addInfoList(InfoListPO po) throws RemoteException;
	public void removeInfoList(String id) throws RemoteException;
	public void changeToApproved(String id) throws RemoteException;
	public ArrayList<InfoListPO> openInfoList() throws RemoteException;
	public ArrayList<InfoListPO> openApproved() throws RemoteException;
	
}
