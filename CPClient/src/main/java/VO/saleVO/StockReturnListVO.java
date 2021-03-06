package VO.saleVO;

import java.util.List;

import util.State;
import util.UserGrade;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 进货退货单
*/
public class StockReturnListVO extends SalesmanListVO{
	/**
	 * @param id
	 * @param operator
	 * @param operatorId
	 * @param state
	 * @param day
	 * @param memberID
	 * @param memberName
	 * @param realOperator
	 * @param warehouse
	 * @param notes
	 * @param saleListItems
	 * @param sum
	 */
	public StockReturnListVO(String id, String operator, String operatorId, State state, UserGrade operatorGrade,String memberID,
			String memberName, String realOperator, String warehouse, String notes, List<SalesmanItemVO> saleListItems,
			double sum) {
		super(id, operator, operatorId, state, operatorGrade,memberID, memberName, realOperator, warehouse, notes, saleListItems, sum);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 单据类型
	 */
	SalesmanListType type = SalesmanListType.StockReturnList;
}
