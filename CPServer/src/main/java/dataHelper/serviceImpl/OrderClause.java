package dataHelper.serviceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.criterion.Order;



/**     
* @author 李安迪
* @date 2017年12月20日
* @description 查询条件，组合了hibernate框架的排序条件，更换框架时只需更换成员变量声明的类型
*/
public class OrderClause extends UnicastRemoteObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4448695852853166125L;
	private Order order;

	public OrderClause(Order Order) throws RemoteException {
		super();
		this.order = Order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
