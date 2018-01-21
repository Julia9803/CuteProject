package bl.salebl;

import java.util.ArrayList;
import java.util.List;

import VO.listVO.SalesDetailListVO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SalesmanItemVO;
import bl.listbl.GetSalesDetails;
import util.DateUtil;

public class GetSalesDetailsImpl implements GetSalesDetails{

	SaleListBLServiceImpl impl = new SaleListBLServiceImpl();
	
	@Override
	public ArrayList<SalesDetailListVO> getSalesDetail() {
	    @SuppressWarnings({ "rawtypes", "unchecked" })
		List<SaleListVO> list = (List)impl.openAllDraft();
		return SaleToDetail(list);
	}
	/**
	 * 
	 * @param list 所有销售记录
	 * @return 所有销售明细记录
	 */
	private ArrayList<SalesDetailListVO> SaleToDetail(List<SaleListVO> list){
		ArrayList<SalesDetailListVO> detailList = new ArrayList<SalesDetailListVO>();
		
		if(list == null || list.isEmpty())
			return detailList;
		
		for(SaleListVO vo: list){
			detailList.addAll(SaleToDetail(vo));
		}
		
		return detailList;
	}
	
	/**
	 * 
	 * @param vo 一条销售记录
	 * @return 多条销售明细记录
	 */
	private ArrayList<SalesDetailListVO> SaleToDetail(SaleListVO vo){
			String id = vo.getId();
			String day = DateUtil.getDateFromListIDAsString(id);
			String operator = vo.getOperator();
			String VIP = vo.getMemberName();
			List<SalesmanItemVO> goodsList = vo.getSaleListItems();
			
			ArrayList<SalesDetailListVO> list = new ArrayList<SalesDetailListVO>();
			
			for(SalesmanItemVO i : goodsList){
				list.add(new SalesDetailListVO(day,i.getName(),i.getType(),i.getAmount(),i.getPrice(),VIP,operator));
			}
			
			return list;
	}
//表单查看中得到销售明细表需要的操作
	
	/*
	 * 实现起来很简单，首先从数据库里把每一张销售单PO都拿出来
	 * 以单据中被卖掉的商品为单位构建上述PO
	 */
	
	/*
	 * 对于时间这个问题，我还是建议使用2017-12-26这种形式，大作业里要的是日期
	 *你觉得返回String不好就把VO里的时间这一项换成Data类吧
	 * 
		
	 */
//	re:使用了yyyymmdd的字符串
}
