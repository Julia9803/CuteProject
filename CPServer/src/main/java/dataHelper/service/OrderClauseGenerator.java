package dataHelper.service;

import java.rmi.RemoteException;

import dataHelper.serviceImpl.OrderClause;

/**     
* @author 李安迪
* @date 2017年12月25日
* @description
*/
public interface OrderClauseGenerator {
	public OrderClause generateDescOrder(String field) throws RemoteException;
	public OrderClause generateAscOrder(String field) throws RemoteException;
}
