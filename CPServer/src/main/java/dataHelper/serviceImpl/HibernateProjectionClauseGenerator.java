package dataHelper.serviceImpl;

import java.rmi.RemoteException;

import org.hibernate.criterion.Projections;

import dataHelper.service.ProjectionClauseGenerator;


/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class HibernateProjectionClauseGenerator implements ProjectionClauseGenerator {

	/* (non-Javadoc)
	 * @see dataHelper.ProjectionClauseGenerator#calSum(java.lang.String)
	 */
	@Override
	public ProjectionClause calSum(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return new ProjectionClause(Projections.sum(field));
	}

}
