package util;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 财务人员处理的单据类型，包括付款单，收款单和现金费用单
*/
public enum FinanceListType implements ListType{


		PaymentList("付款单"),
		CollectMoneyList("收款单"),
		CashExpenseList("现金费用单");		
		
		private final String type;
		
		private FinanceListType(String type){
			this.type = type;
		}
		
		public String getName(){
			return this.type;
		}
	
}
