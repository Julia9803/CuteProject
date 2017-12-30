package ui.managerUI;

import java.util.List;

import VO.GoodsInSaleVO;

/**     
* @author 李安迪
* @date 2017年12月19日
* @description 单个赠送策略的单独界面和cell界面都实现这个接口
*/
public interface SinglePresentController {

	/**
	 * @param presentList
	 */
	void setPresentList(List<GoodsInSaleVO> presentList);

}
