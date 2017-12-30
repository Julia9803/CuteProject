package bl.listbl;

public interface SalesBussinessSituation {
	//出错时返回-1
	/*
	 * 把所有销售单遍历一遍，累加一下每张单据的折让后金额，返回加起来的数值
	 */
      public double getSalesIncome();//获取折让后销售总收入
      
      /*
       * 把所有销售单遍历一遍，累加一下每张单据总共折让了多少钱，返回加起来的数值
       */
      public double getSalesDiscount();//获取销售折让总额
      
      /*
       * 把所有销售退货单据遍历一遍，计算单据金额之和
       */
      public double getSalesReturnOutcome();//获取销售退货总支出
      
      /*
       * 把所有进货退货单据遍历一遍，计算所有单据金额之和
       */
      public double getStockReturnIncome();//获取进货退货总收入
      
      /*
       * 把所有进货单遍历一遍，计算所有单据金额之和
       */
      public double getstockOutcome();//获取进货总支出
}
