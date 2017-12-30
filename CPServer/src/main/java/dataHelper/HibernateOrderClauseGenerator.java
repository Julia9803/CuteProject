package dataHelper;

import java.rmi.RemoteException;

import org.hibernate.criterion.Order;

/**     
* @author 李安迪
* @date 2017年12月25日
* @description
*/
public class HibernateOrderClauseGenerator implements OrderClauseGenerator {

	/* (non-Javadoc)
	 * @see dataHelper.OrderClauseGenerator#generateDescOrder(java.lang.String)
	 */
	@Override
	public OrderClause generateDescOrder(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return new OrderClause(Order.desc(field));
	}

	/* (non-Javadoc)
	 * @see dataHelper.OrderClauseGenerator#generateAscOrder(java.lang.String)
	 */
	@Override
	public OrderClause generateAscOrder(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return new OrderClause(Order.asc(field));
	}

}
