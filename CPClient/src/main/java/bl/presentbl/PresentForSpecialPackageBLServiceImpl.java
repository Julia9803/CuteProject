package bl.presentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.GoodsInSalePO;
import PO.PresentForSpecialPackagePO;
import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSpecialPackageVO;
import bl.utility.GoodsInSaleVoTransPo;
import blservice.presentblservice.PresentForSpecialPackageBLService;
import dataService.presentDataService.PresentForSpecialPackageDataService;
import network.presentRemoteHelper.PresentForSpecialPackageDataServiceHelper;
import resultmessage.DataRM;
import util.PresentState;

/**     
* @author 李安迪
* @date 2017年12月13日
* @description
*/
public class PresentForSpecialPackageBLServiceImpl implements PresentForSpecialPackageBLService {

	PresentForSpecialPackageDataService presentForSpecialPackageDataService = PresentForSpecialPackageDataServiceHelper.getInstance().getPresentForSpecialPackageDataService();
	/* (non-Javadoc)
	 * @see blservice.presentblservice.PresentForSumBLService#getAll()
	 */
	@Override
	public List<PresentForSpecialPackageVO> getAll() {
		// TODO Auto-generated method stub
		List<PresentForSpecialPackagePO> polist;
		try {
			polist = presentForSpecialPackageDataService.getPresentForSpecialPackage();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return null;
		}
		List<PresentForSpecialPackageVO> volist = new ArrayList<PresentForSpecialPackageVO>();
		if(polist != null)
		for(PresentForSpecialPackagePO po : polist){
			volist.add(poToVo(po));
		}
		
		return volist;
	}

	/**
	 * @param specialPackage
	 * @return
	 */
	public List<PresentForSpecialPackageVO> getWithMinSpecialPackage(List<GoodsInSaleVO> goodsList) {
		// TODO Auto-generated method stub
		List<PresentForSpecialPackagePO> polist;
		try {
			List<GoodsInSalePO> goodsPoList = new ArrayList<GoodsInSalePO>();
			if(goodsList != null)
			for(GoodsInSaleVO vo :goodsList){
			goodsPoList.add(GoodsInSaleVoTransPo.GoodsInSaleVoToPo(vo));
			}
			polist = presentForSpecialPackageDataService.getPresentForSpecialPackage(goodsPoList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return null;
		}
		List<PresentForSpecialPackageVO> volist = new ArrayList<PresentForSpecialPackageVO>();
		if(polist != null)
		for(PresentForSpecialPackagePO po : polist){
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
			return presentForSpecialPackageDataService.insert();
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
			return presentForSpecialPackageDataService.deletePresentForSpecialPackage(id);
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
	public DataRM save(PresentForSpecialPackageVO vo) {
		// TODO Auto-generated method stub
		try {
			return presentForSpecialPackageDataService.update(voToPo(vo));
		} catch (RemoteException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	protected PresentForSpecialPackageVO poToVo(PresentForSpecialPackagePO po){
		List<GoodsInSalePO> polist = po.getPresentList();
		List<GoodsInSaleVO> volist = new ArrayList<GoodsInSaleVO>();
		for(GoodsInSalePO i:polist){
			volist.add(GoodsInSaleVoTransPo.GoodsInSalePoToVo(i));
		}
		
		return new PresentForSpecialPackageVO(po.getId(),po.getStartTime(), po.getFinishTime(), volist, po.getPriceReduction());
	}
	
	protected PresentForSpecialPackagePO voToPo(PresentForSpecialPackageVO vo){
		
		
		List<GoodsInSaleVO> volist = vo.getPresentList();
		List<GoodsInSalePO> polist = new ArrayList<GoodsInSalePO>();
		
		if(volist == null)
			polist = null;
		else{
		for(GoodsInSaleVO i:volist){
			polist.add(GoodsInSaleVoTransPo.GoodsInSaleVoToPo(i));
		}
		}
		return new PresentForSpecialPackagePO(vo.getId(), vo.getStartTime(), vo.getFinishTime(), polist, PresentState.SAVE, vo.getPriceReduction());
	}




}
