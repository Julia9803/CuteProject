package VO.saleVO;

import java.util.List;

import VO.GoodsInSaleVO;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 销售单中返回的信息，供赠送策略使用
*/
public class SaleVO {
	/**
	 * 会员级别
	 */
	VIPGrade grade;
	/**
	 * 商品列表
	 */
	List<GoodsInSaleVO> goodsList;
	/**
	 * 总额
	 */
	double sum;
	public VIPGrade getGrade() {
		return grade;
	}
	public void setGrade(VIPGrade grade) {
		this.grade = grade;
	}
	public List<GoodsInSaleVO> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsInSaleVO> goodsList) {
		this.goodsList = goodsList;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public SaleVO(VIPGrade grade, List<GoodsInSaleVO> goodsList, double sum) {
		super();
		this.grade = grade;
		this.goodsList = goodsList;
		this.sum = sum;
	}
	
	
}
