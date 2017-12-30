package bl.salebl;

import java.util.List;

import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import PO.StockListPO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import dataService.saleDataService.SaleUniDataService;
import network.saleRemoteHelper.StockListDataServiceHelper;
import util.DateUtil;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class StockListBLServiceImpl extends SaleUniBLServiceImpl{
	SaleUniDataService service = StockListDataServiceHelper.getInstance().getStockListDataService();
	/* (non-Javadoc)
	 * @see bl.salebl.SaleUniBLServiceImpl#voToPo(VO.saleVO.SalesmanListVO)
	 */
	@Override
	public SalesmanListPO voToPo(SalesmanListVO vo) {
		// TODO Auto-generated method stub
		StockListVO svo = (StockListVO)vo;
		List<SalesmanItemPO> polist = generatePoList(svo);
		return new StockListPO(svo.getId(),svo.getState(),DateUtil.getDateFromListID(svo.getId()),svo.getOperatorGrade(),svo.getMemberID(),svo.getMemberName(),svo.getOperator(),svo.getOperatorId(),svo.getRealOperator(),svo.getWarehouse(),svo.getNotes(),polist,svo.getSum());
	}





	/* (non-Javadoc)
	 * @see bl.salebl.SaleUniBLServiceImpl#poToVo(PO.SalesmanListPO)
	 */
	@Override
	public SalesmanListVO poToVo(SalesmanListPO po) {
		// TODO Auto-generated method stub
		StockListPO spo = (StockListPO)po;
		List<SalesmanItemVO> volist = generateVoList(po);
		//留了一个空项，看以后是存操作员的id还是名称
		return new StockListVO(spo.getId(), spo.getOperator(), spo.getOperatorId(), spo.getState(),spo.getOperatorGrade(),spo.getMemberID(), spo.getMemberName(),spo.getRealOperator(), spo.getWarehouse(), spo.getNotes(), volist, spo.getSum());
	}




}
