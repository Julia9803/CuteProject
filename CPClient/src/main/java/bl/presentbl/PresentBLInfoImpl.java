package bl.presentbl;

import java.util.ArrayList;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleVO;
import blservice.presentblservice.PresentBLInfo;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public class PresentBLInfoImpl implements PresentBLInfo{
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
	
	PresentResultVO result;
	
	PresentForSumHandler sumHandler = new PresentForSumHandler();
	PresentForSpecialPackageHandler packageHandler = new PresentForSpecialPackageHandler();
	PresentForMembershipHandler membershipHandler = new PresentForMembershipHandler();
	
	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentBLInfo#findPresent(VO.saleVO.SaleVO)
	 */
	@Override
	public PresentResultVO findPresent(SaleVO vo) {
		System.out.println("finding present start");
		//拆包vo
		this.goodsList = vo.getGoodsList();
		this.grade = vo.getGrade();
		this.sum = vo.getSum();
		
		result = new PresentResultVO(new ArrayList<Integer>(), 0.0, new ArrayList<GoodsInSaleVO>(), sum);
	
		result = packageHandler.handle(goodsList,result);
		System.out.println("after finding special package"+result);
		result = sumHandler.handle(result);
		System.out.println("after finding sum"+result);
		result = membershipHandler.handle(grade,result);
		System.out.println("after finding membership"+result);
		
		System.out.println("finding present finish");
		return result;
		
		
	}

}
