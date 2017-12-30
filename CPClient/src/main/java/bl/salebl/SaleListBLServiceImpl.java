package bl.salebl;

import java.util.ArrayList;
import java.util.List;

import PO.SaleListPO;
import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import dataService.saleDataService.SaleListDataService;
import network.saleRemoteHelper.SaleListDataServiceHelper;
import util.DateUtil;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleListBLServiceImpl extends SaleUniBLServiceImpl{

	SaleListDataService service = SaleListDataServiceHelper.getInstance().getSaleListDataService();
	/* (non-Javadoc)
	 * @see bl.salebl.SaleUniBLServiceImpl#voToPo(VO.saleVO.SalesmanListVO)
	 */
	@Override
	public SalesmanListPO voToPo(SalesmanListVO vo) {
		// TODO Auto-generated method stub
		SaleListVO svo = (SaleListVO)vo;
		List<SalesmanItemVO> volist = svo.getSaleListItems();
		List<SalesmanItemPO> polist = new ArrayList<SalesmanItemPO>();
		
		if(volist == null)
			polist = null;
		else{
		for(SalesmanItemVO i:volist){
			polist.add(itemVoToPo(i));
		}
		}
		return new SaleListPO(svo.getId(),svo.getState(),DateUtil.getDateFromListID(svo.getId()),svo.getOperatorGrade(),svo.getMemberID(),svo.getMemberName(),svo.getOperator(),svo.getOperatorId(),svo.getRealOperator(),svo.getWarehouse(),svo.getNotes(),polist,svo.getSum(),svo.getSumBeforeRebate(),svo.getRebate(),svo.getVoucher());
//		return new SaleListPO(svo.getId(),svo.getState(),DateUtil.getDateFromListID(svo.getId()),svo.getOperatorGrade(),svo.getMemberID(),svo.getMemberName(),svo.getOperator(),svo.getOperatorId(),svo.getRealOperator(),svo.getWarehouse(),svo.getNotes(),polist,svo.getSum(),svo.getSumBeforeRebate(),svo.getRebate(),svo.getVoucher());
	}


	/* (non-Javadoc)
	 * @see bl.salebl.SaleUniBLServiceImpl#poToVo(PO.SalesmanListPO)
	 */
	@Override
	public SalesmanListVO poToVo(SalesmanListPO po) {
		// TODO Auto-generated method stub
		SaleListPO spo = (SaleListPO)po;
		List<SalesmanItemPO> polist = spo.getSaleListItems();
		List<SalesmanItemVO> volist = new ArrayList<SalesmanItemVO>();

		if(polist == null)
			volist = null;
		else{
		for(SalesmanItemPO i:polist){
			volist.add(itemPoToVo(i));
		}
		}
		//留了一个空项，看以后是存操作员的id还是名称
		return new SaleListVO(spo.getId(), spo.getOperator(),spo.getOperatorId(), spo.getState(),spo.getOperatorGrade(),spo.getMemberID(), spo.getMemberName(),spo.getRealOperator(), spo.getWarehouse(), spo.getNotes(), volist, spo.getSum(), spo.getSumBeforeRebate(), spo.getRebate(), spo.getVoucher());
	}

	
	
	
}
