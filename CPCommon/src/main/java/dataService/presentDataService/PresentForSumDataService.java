package dataService.presentDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.PresentForSumPO;
import resultmessage.DataRM;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public interface PresentForSumDataService extends Remote,Serializable{
	public int insert() throws RemoteException;
	public DataRM deletePresentForSum(int id) throws RemoteException;
	public DataRM update(PresentForSumPO po) throws RemoteException;
	public List<PresentForSumPO> getPresentForSum() throws RemoteException;
	//获得降序排列的结果集
	public List<PresentForSumPO> getPresentForSum(double sum) throws RemoteException;
}
