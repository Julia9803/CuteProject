package VO;


/**     
* @author 李安迪
* @date 2017年10月26日
* @description 销售包和赠送包中的商品清单需要的商品简要信息
*/
public class GoodsInSaleVO {
	/**
	 * 商品编号	
	 */
	String id;
	/**
	 * 商品名称	
	 */
	String goodsName;
	/**
	 * 商品数量
	 */
	int amount = 1;
	
	public GoodsInSaleVO(String id, String goodsName, int amount) {
		
		this.id = id;
		this.goodsName = goodsName;
		this.amount = amount;
	}

	public String getId(){
		return id;
	}
	public String getGoodsName(){
		return goodsName;
	}
	public int getAmount(){
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
