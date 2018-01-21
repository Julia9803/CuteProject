package VO.storeVO;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public class StoreVO {
	public String name; //商品名称
	public String ID;  //商品ID
	public int alarmNum;//警戒线
	public int Num; //现有数量
	
	public double averagePrice;//库存均价
	
	//构造方法
	public StoreVO(String name,String ID,int alarm,int Num){
		this.name=name;
		this.ID=ID;
		this.alarmNum=alarm;
		this.Num=Num;
		
	}
	public StoreVO(){};
	public void calcAveragePrice(int oldNum,int adder,double oldPrice,double newPrice){
		averagePrice=(oldNum*oldPrice+adder*newPrice)/(oldNum+adder);
		
	}
}
