package bl.presentbl;

import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSumVO;
import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleVO;
import dataService.presentDataService.PresentForSumDataService;
import network.presentRemoteHelper.PresentForSumDataServiceHelper;

/**     
* @author 李安迪
* @date 2017年12月25日
* @description 总价类赠送策略的生成
*/
public class PresentForSumHandler {

	PresentForSumBLServiceImpl impl = new PresentForSumBLServiceImpl();
	/**
	 * @param sum
	 * @param result
	 * @return
	 */
	public PresentResultVO handle(PresentResultVO result) {
		// TODO Auto-generated method stub
		List<PresentForSumVO> list = impl.getWithMinSum(result.getSum());
		if(list != null && ! list.isEmpty()){
		PresentForSumVO newPresent = list.get(0);
		int id = newPresent.getId();
		result.getPresentId().add(id);
		result.getPresentList().addAll(newPresent.getPresentList());
		double voucher = newPresent.getVoucher()+result.getVoucher();
		result.setVoucher(voucher);
		}
		
		return result;
	}


	
}
