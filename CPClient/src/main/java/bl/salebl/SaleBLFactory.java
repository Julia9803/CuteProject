package bl.salebl;

import blservice.saleblservice.SaleUniBLService;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleBLFactory {
	public static SaleUniBLService getSaleListBLService(){
		return new SaleListBLServiceImpl();
	}
	public static SaleUniBLService getSaleReturnListBLService(){
		return new SaleReturnListBLServiceImpl();
	}
	public static SaleUniBLService getStockListBLService(){
		return new StockListBLServiceImpl();
	}
	public static SaleUniBLService getStockReturnListBLService(){
		return new StockReturnListBLServiceImpl();
	}
}
