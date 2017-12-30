package blservice.saleblservice;

import java.util.List;

import PO.SalesmanListPO;
import VO.saleVO.SalesmanListVO;
import resultmessage.DataRM;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description 销售类单据统一的增删改查接口
*/
public interface SaleUniBLService {
	public String getId();
	public DataRM delete(String id);
	public DataRM approve(SalesmanListVO vo);
	public DataRM reject(SalesmanListVO vo);
	public DataRM save(SalesmanListVO vo);
	public DataRM commit(SalesmanListVO vo);
	public List<SalesmanListVO> openAllDraft();
}
