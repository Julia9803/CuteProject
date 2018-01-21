package PO;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 销售中返回的商品信息，以供选择合适的赠送策略
*/
public class StockmanItemPO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2356299182446987344L;
	/**
	 * 商品编号	
	 */
	String id;
	/**
	 * 商品名称	
	 */
	String goodsName;
	/**
	 * 商品数量
	 */
	String amount;
}
