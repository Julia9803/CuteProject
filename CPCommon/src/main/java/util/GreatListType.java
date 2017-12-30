package util;

public enum GreatListType implements ListType {
   //斟酌了一下，还是觉得把所有能审批的单据类型都放在这里。
	PAYMENT,COLLECYMONEY,CASHEXPENSE,OVERFLOW,LOSS,PRESENT,SALE,SALE_RETURN,STOCK,STOCK_RETURN
	
	/*
	 * 以上分别是：
	 * 付款单、收款单、现金费用单、报溢单、报损单、赠送单、销售单、销售退货单、进货单、进货退货单
	 */
}
