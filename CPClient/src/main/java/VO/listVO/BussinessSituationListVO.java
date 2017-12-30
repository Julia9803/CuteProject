package VO.listVO;

public class BussinessSituationListVO {
	//经营情况表VO
	public double salesIncome;//折让后销售收入
	public double salesDiscount;//销售折让
	public double overflowIncome;//商品报溢收入
	public double salesReturnOutcome;//销售退货支出
	public double stockReturnIncome;//进货退货收入
	public double stockOutcome;//进货支出
	public double lossOutcome;//商品报损支出
	
	//这个VO 比较特殊，由于初始化不是一次完成的，不能用构造方法一次性初始化。
	public double Income;
	public double Outcome;
	
	public void calcIncome(){
		Income=salesIncome+overflowIncome+stockReturnIncome;
		
	}
	
	public void calcOutCome(){
		Outcome=salesReturnOutcome+stockOutcome+lossOutcome;
	}
	
}
