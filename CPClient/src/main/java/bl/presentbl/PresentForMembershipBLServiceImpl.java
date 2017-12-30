package bl.presentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.GoodsInSalePO;
import PO.PresentForMembershipPO;
import VO.GoodsInSaleVO;
import VO.presentVO.PresentForMembershipVO;
import bl.utility.GoodsInSaleVoTransPo;
import blservice.presentblservice.PresentForMembershipBLService;
import dataService.presentDataService.PresentForMembershipDataService;
import network.presentRemoteHelper.PresentForMembershipDataServiceHelper;
import resultmessage.DataRM;
import util.PresentState;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public class PresentForMembershipBLServiceImpl implements PresentForMembershipBLService {

	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForMembershipBLService#getAll()
	 */
	PresentForMembershipDataService presentForMembershipDataService = PresentForMembershipDataServiceHelper.getInstance().getPresentForMembershipDataService();
	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#getAll()
	 */
	@Override
	public List<PresentForMembershipVO> getAll() {
		// TODO Auto-generated method stub
		List<PresentForMembershipPO> polist;
		try {
			polist = presentForMembershipDataService.getPresentForMembership();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return null;
		}
		List<PresentForMembershipVO> volist = new ArrayList<PresentForMembershipVO>();
		
		for(PresentForMembershipPO po : polist){
			volist.add(poToVo(po));
		}
		
		return volist;
	}

	/**
	 * @param grade
	 * @return
	 */
	public List<PresentForMembershipVO> getWithMinMembership(VIPGrade grade,double sum) {
		// TODO Auto-generated method stub
		List<PresentForMembershipPO> polist;
		try {
			polist = presentForMembershipDataService.getPresentForMembership(grade,sum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return null;
		}
		List<PresentForMembershipVO> volist = new ArrayList<PresentForMembershipVO>();
		
		for(PresentForMembershipPO po : polist){
			volist.add(poToVo(po));
		}
		
		return volist;
	}
	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#getId()
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		try {
			return presentForMembershipDataService.insert();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#delete(int)
	 */
	@Override
	public DataRM delete(int id) {
		// TODO Auto-generated method stub
		try {
			return presentForMembershipDataService.deletePresentForMembership(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#save(VO.presentVO.PresentForSumVO)
	 */
	@Override
	public DataRM save(PresentForMembershipVO vo) {
		// TODO Auto-generated method stub
		try {
			return presentForMembershipDataService.update(voToPo(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	protected PresentForMembershipVO poToVo(PresentForMembershipPO po){
		List<GoodsInSalePO> polist = po.getPresentList();
		List<GoodsInSaleVO> volist = new ArrayList<GoodsInSaleVO>();
		for(GoodsInSalePO i:polist){
			volist.add(GoodsInSaleVoTransPo.GoodsInSalePoToVo(i));
		}
		
		return new PresentForMembershipVO(po.getId(),po.getStartTime(), po.getFinishTime(), po.getGrade(),po.getSum(),volist, po.getRebateInPresentForMembership(),po.getVoucher());
	}
	
	protected PresentForMembershipPO voToPo(PresentForMembershipVO vo){
		
		
		List<GoodsInSaleVO> volist = vo.getPresentList();
		List<GoodsInSalePO> polist = new ArrayList<GoodsInSalePO>();
		
		if(volist == null)
			polist = null;
		else{
		for(GoodsInSaleVO i:volist){
			polist.add(GoodsInSaleVoTransPo.GoodsInSaleVoToPo(i));
		}
		}
		return new PresentForMembershipPO(vo.getId(),vo.getStartTime(), vo.getFinishTime(), vo.getSum(),polist,PresentState.SAVE,vo.getVoucher(),vo.getGrade(),vo.getRebateInPresentForMembership());
	}




}
