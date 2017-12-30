package dataService.listDataService;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InfoListPO;
public interface ListDataService extends  Remote,Serializable {
	public void addInfoList(InfoListPO po);
	public void removeInfoList(String id);
	public void changeToApproved(String id);
	public ArrayList<InfoListPO> openInfoList();
	public ArrayList<InfoListPO> openApproved();
	
}
