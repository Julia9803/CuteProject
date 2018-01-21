package bl.utility;

import java.util.ArrayList;
import java.util.List;

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
	
	public static List<GoodsInSaleVO> GoodsInSalePoToVo(List<GoodsInSalePO> po){
		List<GoodsInSaleVO> l = new ArrayList<GoodsInSaleVO>();
		if(po != null)
		for(GoodsInSalePO i : po){
			l.add(GoodsInSalePoToVo(i));
		}
		return l;
	}
	
	public static List<GoodsInSalePO> GoodsInSaleVoToPo(List<GoodsInSaleVO> vo){
		List<GoodsInSalePO> l = new ArrayList<GoodsInSalePO>();
		if(vo != null)
		for(GoodsInSaleVO i : vo){
			l.add(GoodsInSaleVoToPo(i));
		}
		return l;
	}
}
