package dataService.presentDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.GoodsInSalePO;
import PO.PresentForSpecialPackagePO;
import resultmessage.DataRM;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public interface PresentForSpecialPackageDataService extends Remote,Serializable{
	public int insert() throws RemoteException;
	public DataRM deletePresentForSpecialPackage(int id) throws RemoteException;
	public DataRM update(PresentForSpecialPackagePO po) throws RemoteException;
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage() throws RemoteException;
	//获得按降价金额降序排列的结果集
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<GoodsInSalePO> goodsList) throws RemoteException;
}
