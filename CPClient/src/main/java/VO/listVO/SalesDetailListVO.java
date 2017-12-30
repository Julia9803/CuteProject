package VO.listVO;

public class SalesDetailListVO {
	//销售明细表
	public String day;
	public String goodsName;
	public String model;//型号
	public int num;//数量
	public double  price ; //单价

	public double  sum;//总额（折让前）
	
	public String VIP;  //客户
	public String Operator; //操作员
	
	public SalesDetailListVO(String day,String goodsName ,String model,int num,double price,String VIP,String operator){
		this.day=day;
		this.goodsName=goodsName;
		this.model=model;
		this.num=num;
		this.price=price;
		sum=num*price;
		
		this.VIP=VIP;
		this.Operator=operator;
		
	}
	
	
}
