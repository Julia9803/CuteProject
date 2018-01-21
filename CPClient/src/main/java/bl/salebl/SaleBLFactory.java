package bl.salebl;

import blservice.saleblservice.SaleListBLService;
import blservice.saleblservice.SaleReturnListBLService;
import blservice.saleblservice.StockListBLService;
import blservice.saleblservice.StockReturnListBLService;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleBLFactory {
	public static SaleListBLService getSaleListBLService(){
		return new SaleListBLServiceImpl();
	}
	public static SaleReturnListBLService getSaleReturnListBLService(){
		return new SaleReturnListBLServiceImpl();
	}
	public static StockListBLService getStockListBLService(){
		return new StockListBLServiceImpl();
	}
	public static StockReturnListBLService getStockReturnListBLService(){
		return new StockReturnListBLServiceImpl();
	}
}
