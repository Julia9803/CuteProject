package dataHelper.service;

import java.rmi.RemoteException;

import dataHelper.serviceImpl.ProjectionClause;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public interface ProjectionClauseGenerator {
	public ProjectionClause calSum(String field) throws RemoteException;
}
