package bl.presentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.GoodsInSalePO;
import PO.PresentForSumPO;
import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSumVO;
import bl.utility.GoodsInSaleVoTransPo;
import blservice.presentblservice.PresentForSumBLService;
import dataService.presentDataService.PresentForSumDataService;
import network.presentRemoteHelper.PresentForSumDataServiceHelper;
import resultmessage.DataRM;
import util.PresentState;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public class PresentForSumBLServiceImpl implements PresentForSumBLService {

	PresentForSumDataService presentForSumDataService = PresentForSumDataServiceHelper.getInstance().getPresentForSumDataService();
	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#getAll()
	 */
	@Override
	public List<PresentForSumVO> getAll() {
		// TODO Auto-generated method stub
		List<PresentForSumPO> polist = new ArrayList<PresentForSumPO>();
		List<PresentForSumVO> volist = new ArrayList<PresentForSumVO>();
		try {
			polist = presentForSumDataService.getPresentForSum();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
	//		return volist;
		}
		System.out.println("polist"+polist);
		
		
		for(PresentForSumPO po : polist){
			System.out.println(po.getState());
			volist.add(poToVo(po));
		}
		System.out.println("volist"+volist);
		return volist;
	}

	protected List<PresentForSumVO> getWithMinSum(double sum) {
		// TODO Auto-generated method stub
		List<PresentForSumPO> polist = new ArrayList<PresentForSumPO>();
		List<PresentForSumVO> volist = new ArrayList<PresentForSumVO>();
		try {
			polist = presentForSumDataService.getPresentForSum(sum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
	//		return volist;
		}
		System.out.println("polist"+polist);
		
		
		for(PresentForSumPO po : polist){
			volist.add(poToVo(po));
		}
		System.out.println("volist"+volist);
		return volist;
	}
	
	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#getId()
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		try {
			int id = 0;
			System.out.println(presentForSumDataService);
			id = presentForSumDataService.insert();
			System.out.println(id);
			return id;
		//	return presentForSumDataService.insert();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("remote exception");
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
			return presentForSumDataService.deletePresentForSum(id);
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
	public DataRM save(PresentForSumVO vo) {
		// TODO Auto-generated method stub
		try {
			return presentForSumDataService.update(voToPo(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}
	

	protected PresentForSumVO poToVo(PresentForSumPO po){
		List<GoodsInSalePO> polist = po.getPresentList();
		List<GoodsInSaleVO> volist = new ArrayList<GoodsInSaleVO>();
		for(GoodsInSalePO i:polist){
			volist.add(GoodsInSaleVoTransPo.GoodsInSalePoToVo(i));
		}
		
		return new PresentForSumVO(po.getId(),po.getStartTime(), po.getFinishTime(), po.getSum(),volist, po.getVoucher());
	}
	
	protected PresentForSumPO voToPo(PresentForSumVO vo){
		
		
		List<GoodsInSaleVO> volist = vo.getPresentList();
		List<GoodsInSalePO> polist = new ArrayList<GoodsInSalePO>();
		
		if(volist == null)
			polist = null;
		else{
		for(GoodsInSaleVO i:volist){
			polist.add(GoodsInSaleVoTransPo.GoodsInSaleVoToPo(i));
		}
		}
		return new PresentForSumPO(vo.getId(), vo.getStartTime(), vo.getFinishTime(), vo.getTotal(), polist, PresentState.SAVE, vo.getVoucher());
	}

}
