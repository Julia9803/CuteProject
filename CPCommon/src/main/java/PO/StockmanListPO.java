package PO;

import java.io.Serializable;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public abstract class StockmanListPO extends ListPO implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 8692654327132109789L;
	/**
	  * 商品清单
	  */
	 List<StockmanItemPO> SaleListItems;
}
