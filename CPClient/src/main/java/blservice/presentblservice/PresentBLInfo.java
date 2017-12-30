package blservice.presentblservice;

import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleVO;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description present提供给sales的接口
*/
public interface PresentBLInfo {
	public PresentResultVO findPresent(SaleVO vo);
}
