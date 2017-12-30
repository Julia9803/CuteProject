package util;


/**     
* @author 李安迪
* @date 2017年10月26日
* @description 销售人员处理的单据类型，包括销售单，销售退货单，进货单，进货退货单
*/
public enum SalesmanListType implements ListType{

	SaleList("销售单"),
	SaleReturnList("销售退货单"),
	StockList("进货单"),
	StockReturnList("进货退货单");
	
	
	private final String type;
	
	private SalesmanListType(String type){
		this.type = type;
	}
	
	public String getName(){
		return this.type;
	}
}
