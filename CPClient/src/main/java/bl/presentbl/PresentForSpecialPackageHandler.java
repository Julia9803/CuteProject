package bl.presentbl;

import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSpecialPackageVO;
import VO.presentVO.PresentResultVO;

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
		System.out.println("handling presentforspecialpackage");

		List<PresentForSpecialPackageVO> list = impl.getWithMinSpecialPackage(goodsList);
		if(list != null && ! list.isEmpty()){
		PresentForSpecialPackageVO newPresent = list.get(0);
		System.out.println(newPresent);
		int id = newPresent.getId();
		if(!result.getPresentId().contains(id)){
		result.getPresentId().add(id);
		System.out.println("presentid"+id);
		System.out.println("presentidInList"+result.getPresentId());
		result.getPresentList().addAll(newPresent.getPresentList());
		double rebate = newPresent.getPriceReduction();
		if(result.getSum() - rebate > 0)
		result.setSum(result.getSum() - rebate);
		}
		}
		return result;
	}



}
