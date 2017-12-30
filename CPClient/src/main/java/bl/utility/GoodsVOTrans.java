package bl.utility;

import java.util.ArrayList;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.goodsVO.GoodsVO;
import VO.saleVO.SalesmanItemVO;
import ui.salesmanUI.SaleTypeListController;
import ui.salesmanUI.StockTypeListController;

/**     
* @author 李安迪
* @date 2017年12月15日
* @description
*/
public class GoodsVOTrans {
	public static List<GoodsInSaleVO> GoodsTransGoodsInSaleInList(List<GoodsVO> list){
		List<GoodsInSaleVO> returnList = new ArrayList<GoodsInSaleVO>();
		for(GoodsVO i : list){
			GoodsInSaleVO returnVo = new GoodsInSaleVO(i.getGoodsID(),i.getGoodsName(),1);
			returnList.add(returnVo);
		}
		return returnList;
	}
	
	public static List<SalesmanItemVO> GoodsTransSalesmanItemInList(List<GoodsVO>list,StockTypeListController controller){
		List<SalesmanItemVO> returnList = new ArrayList<SalesmanItemVO>();
		for(GoodsVO i : list){
			SalesmanItemVO returnVo = new SalesmanItemVO(i.getGoodsID(),i.getGoodsName(),i.getGoodsType(),i.getGoodsBuyPrice(),1,i.getGoodsBuyPrice(),"");
			returnList.add(returnVo);
		}
		return returnList;
	}
	
	public static List<SalesmanItemVO> GoodsTransSalesmanItemInList(List<GoodsVO>list,SaleTypeListController controller){
		List<SalesmanItemVO> returnList = new ArrayList<SalesmanItemVO>();
		for(GoodsVO i : list){
			SalesmanItemVO returnVo = new SalesmanItemVO(i.getGoodsID(),i.getGoodsName(),i.getGoodsType(),i.getGoodsBuyPrice(),1,i.getGoodsSellPrice(),"");
			returnList.add(returnVo);
		}
		return returnList;
	}
}
