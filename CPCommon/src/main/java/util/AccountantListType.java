package util;


/**     
* @author 李安迪
* @date 2017年10月26日
* @description 财务人员处理的单据类型，包括付款单，收款单和现金费用单
*/
public enum AccountantListType implements ListType{


		PaymentList("付款单"),
		ReceiptList("收款单"),
		CashList("现金费用单");		
		
		private final String type;
		
		private AccountantListType(String type){
			this.type = type;
		}
		
		public String getName(){
			return this.type;
		}
	
}
