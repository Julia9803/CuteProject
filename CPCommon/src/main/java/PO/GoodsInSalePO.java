package PO;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 销售中返回的商品信息，以供选择合适的赠送策略
*/
public class GoodsInSalePO implements Serializable{
	int autoId;
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
	int amount;
	public GoodsInSalePO(){}
	public GoodsInSalePO(String id, String goodsName, int amount) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.amount = amount;
	}
	@SuppressWarnings("unused")
	private int getAutoId() {
		return autoId;
	}
	@SuppressWarnings("unused")
	private void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsInSalePO other = (GoodsInSalePO) obj;
		if (amount != other.amount)
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
