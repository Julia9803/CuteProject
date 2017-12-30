package bl.utility;

import PO.GoodsInSalePO;
import VO.GoodsInSaleVO;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description 
*/
public class GoodsInSaleVoTransPo {
	public static GoodsInSaleVO GoodsInSalePoToVo(GoodsInSalePO po){
		return new GoodsInSaleVO(po.getId(),po.getGoodsName(),po.getAmount());
	}
	
	public static GoodsInSalePO GoodsInSaleVoToPo(GoodsInSaleVO vo){
		return new GoodsInSalePO(vo.getId(),vo.getGoodsName(),vo.getAmount());
	}
}
