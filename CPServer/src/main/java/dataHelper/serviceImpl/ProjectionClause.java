package dataHelper.serviceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.criterion.Projection;



/**     
* @author 李安迪
* @date 2017年12月20日
* @description 统计条件，组合了hibernate框架的投影统计条件
*/
public class ProjectionClause extends UnicastRemoteObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6491048967595983898L;
	private Projection projection;

	public ProjectionClause(Projection projection) throws RemoteException {
		super();
		this.projection = projection;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}
	
	
}
