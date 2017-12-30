package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.State;
import util.UserGrade;
/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class StockReturnListPO extends SalesmanListPO implements Serializable{
//	/*
//	 * 单据编号
//	 */
//	String id;
	public StockReturnListPO(){}
//	public StockReturnListPO(State state, String memberID, String memberName, String operator, String warehouse, String notes,
//			List<SalesmanItemPO> saleListItems, double sum, String id) {
//		super(state, memberID, memberName, operator, warehouse, notes, saleListItems, sum);
//		this.id = id;
//	}
//
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public StockReturnListPO(String id, State state, Date day, UserGrade operatorGrade,String memberID, String memberName, String operator,String operatorId,
			String realOperator, String warehouse, String notes, List<SalesmanItemPO> saleListItems, double sum) {
		super(id, state, day, operatorGrade,memberID, memberName, operator,operatorId,realOperator, warehouse, notes, saleListItems, sum);
		// TODO Auto-generated constructor stub
	}
}
