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
		// TODO 特价商品清单的写法
		//拆包vo
		this.goodsList = vo.getGoodsList();
		this.grade = vo.getGrade();
		this.sum = vo.getSum();
		
		result = new PresentResultVO(new ArrayList<Integer>(), 0, goodsList, sum);
		
		result = packageHandler.handle(goodsList,result);
		result = sumHandler.handle(result);
		result = membershipHandler.handle(grade,result);
		
		return result;
		
		
	}

}
