package dataService.presentDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.PresentForMembershipPO;
import resultmessage.DataRM;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public interface PresentForMembershipDataService extends Remote,Serializable {
	public int insert() throws RemoteException;
	public DataRM deletePresentForMembership(int id) throws RemoteException;
	public DataRM update(PresentForMembershipPO po) throws RemoteException;
	public List<PresentForMembershipPO> getPresentForMembership() throws RemoteException;
	//获得按voucher升序排列的结果集
	List<PresentForMembershipPO> getPresentForMembership(VIPGrade grade, double sum) throws RemoteException;

} 
