package bl.presentbl;

import java.util.ArrayList;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSpecialPackageVO;
import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleVO;

/**     
* @author 李安迪
* @date 2017年12月25日
* @description
*/
public class PresentForSpecialPackageHandler {

	PresentForSpecialPackageBLServiceImpl impl = new PresentForSpecialPackageBLServiceImpl();
	/**
	 * @param SpecialPackage
	 * @param result
	 * @return
	 */
	public PresentResultVO handle(List<GoodsInSaleVO> goodsList, PresentResultVO result) {
		// TODO Auto-generated method stub

		List<PresentForSpecialPackageVO> list = impl.getWithMinSpecialPackage(goodsList);
		if(list != null && ! list.isEmpty()){
		PresentForSpecialPackageVO newPresent = list.get(0);
		int id = newPresent.getId();
		result.getPresentId().add(id);
		result.getPresentList().addAll(newPresent.getPresentList());
		double rebate = newPresent.getPriceReduction();
		if(result.getSum() - rebate > 0)
		result.setSum(result.getSum() - rebate);
		}
		
		return result;
	}



}
