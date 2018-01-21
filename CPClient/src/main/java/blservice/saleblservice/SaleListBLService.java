package blservice.saleblservice;

import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleVO;

/**     
* @author 李安迪
* @date 2017年12月29日
* @description
*/
public interface SaleListBLService extends SaleUniBLService {
	public PresentResultVO findPresent(SaleVO vo);
}
