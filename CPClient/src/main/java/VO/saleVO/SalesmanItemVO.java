package VO.saleVO;


/**     
* @author 李安迪
* @date 2017年10月27日
* @description 销售人员的单据中的商品项
*/
public class SalesmanItemVO {
	/**
	 * 商品编号
	 */
	String id;
	/**
	 * 商品名
	 */	
	String name;
	/**
	 * 型号
	 */
	String type;
	/**
	 * 单价
	 */
	double price;
	/**
	 * 数量
	 */
	int amount;
	/**
	 * 金额
	 */
	double sum;
	/**
	 * 备注
	 */
	String notes;

	public SalesmanItemVO(String id, String name, String type, double price, int amount, double sum,
			String notes) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.sum = sum;
		this.notes = notes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
