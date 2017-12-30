package bl.listbl;

import java.util.ArrayList;

import VO.listVO.SalesDetailListVO;

public interface GetSalesDetails {
// 得到销售明细表的数据，我把实现写在销售包，具体数据抓取请安迪实现一下。
	
	public ArrayList<SalesDetailListVO> getSalesDetail();
}
