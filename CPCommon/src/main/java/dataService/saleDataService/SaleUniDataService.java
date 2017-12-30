package dataService.saleDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.SalesmanListPO;
import resultmessage.DataRM;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public interface SaleUniDataService extends Remote,Serializable{

	/**
	 * @return
	 */
	public String insert() throws RemoteException;

	/**
	 * @param id
	 * @return
	 */
	public DataRM delete(String id) throws RemoteException;

	/**
	 * @param voToPo
	 * @return
	 */
	public DataRM save(SalesmanListPO po) throws RemoteException;

	/**
	 * @param voToPo
	 * @return
	 */
	public DataRM commit(SalesmanListPO po) throws RemoteException;

	/**
	 * @return
	 */
	public List<SalesmanListPO> openAllDraft() throws RemoteException;
	
	
	public DataRM approve(SalesmanListPO po) throws RemoteException;
	
	public DataRM refuse(SalesmanListPO po) throws RemoteException;

}
