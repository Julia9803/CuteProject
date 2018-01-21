package dataHelper.serviceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.criterion.Criterion;

/**     
* @author 李安迪
* @date 2017年12月20日
* @description 查询条件，组合了hibernate框架的查询条件，更换框架时只需更换成员变量声明的类型
*/
public class CriterionClause extends UnicastRemoteObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7014809906340749012L;
	private Criterion criterion;

	public CriterionClause(Criterion criterion) throws RemoteException {
		super();
		this.criterion = criterion;
	}

	public Criterion getCriterion() {
		return criterion;
	}

	public void setCriterion(Criterion criterion) {
		this.criterion = criterion;
	}
	
	
}
