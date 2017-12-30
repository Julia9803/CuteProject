package bl.salebl;

import java.util.List;

import PO.SaleReturnListPO;
import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import VO.saleVO.SaleReturnListVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import dataService.saleDataService.SaleReturnListDataService;
import dataService.saleDataService.SaleUniDataService;
import network.saleRemoteHelper.SaleReturnListDataServiceHelper;
import util.DateUtil;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleReturnListBLServiceImpl extends SaleUniBLServiceImpl {

	SaleReturnListDataService service = SaleReturnListDataServiceHelper.getInstance().getSaleReturnListDataService();
	/* (non-Javadoc)
	 * @see bl.salebl.SaleUniBLServiceImpl#voToPo(VO.saleVO.SalesmanListVO)
	 */
	@Override
	public SalesmanListPO voToPo(SalesmanListVO vo) {
		// TODO Auto-generated method stub
		SaleReturnListVO svo = (SaleReturnListVO)vo;
		List<SalesmanItemPO> polist = generatePoList(svo);
		return new SaleReturnListPO(svo.getId(),svo.getState(),DateUtil.getDateFromListID(svo.getId()),svo.getOperatorGrade(),svo.getMemberID(),svo.getMemberName(),svo.getOperator(),svo.getOperatorId(),svo.getRealOperator(),svo.getWarehouse(),svo.getNotes(),polist,svo.getSum(),svo.getSumBeforeRebate(),svo.getRebate(),svo.getVoucher());
	}





	/* (non-Javadoc)
	 * @see bl.salebl.SaleUniBLServiceImpl#poToVo(PO.SalesmanListPO)
	 */
	@Override
	public SalesmanListVO poToVo(SalesmanListPO po) {
		// TODO Auto-generated method stub
		SaleReturnListPO spo = (SaleReturnListPO)po;
		List<SalesmanItemVO> volist = generateVoList(po);
		//留了一个空项，看以后是存操作员的id还是名称
		return new SaleReturnListVO(spo.getId(), spo.getOperator(), spo.getOperatorId(), spo.getState(), spo.getOperatorGrade(),spo.getMemberID(), spo.getMemberName(),spo.getRealOperator(), spo.getWarehouse(), spo.getNotes(), volist, spo.getSum(), spo.getSumBeforeRebate(), spo.getRebate(), spo.getVoucher());
	}



	

}
