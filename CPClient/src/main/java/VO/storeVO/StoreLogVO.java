package VO.storeVO;

import util.GreatListType;

public class StoreLogVO {
//库存记录VO
	//为了库存查看，必须记录下来每次库存变动的时间、商品ID、商品名称、变动原因、商品数量、涉及的总价
	public String time;
	public String id;
	public String name;
	public GreatListType type;
	public int num;
	public double price;
}
