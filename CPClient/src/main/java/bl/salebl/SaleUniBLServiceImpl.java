package bl.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.PresentForSumPO;
import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import VO.presentVO.PresentForSumVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import dataService.saleDataService.SaleUniDataService;
import resultmessage.DataRM;
import util.State;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public abstract class SaleUniBLServiceImpl implements SaleUniBLService {

	SaleUniDataService service;						//TODO 这个恐怕多态不了
	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#getId()
	 */
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		try {
			String id = service.insert();
			System.out.println(id);
			return id;
		//	return presentForSumDataService.insert();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#delete(java.lang.String)
	 */
	@Override
	public DataRM delete(String id) {
		// TODO Auto-generated method stub
		try {
			return service.delete(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#save(VO.saleVO.SalesmanListVO)
	 */
	@Override
	public DataRM save(SalesmanListVO vo) {
		try {
			vo.setState(State.IsDraft);
			return service.save(voToPo(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	@Override
	public DataRM approve(SalesmanListVO vo){
		try {
			vo.setState(State.IsApproved);
			return service.save(voToPo(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}
	
	@Override
	public DataRM reject(SalesmanListVO vo){
		try {
			vo.setState(State.IsRefused);
			return service.save(voToPo(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}
	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#commit(VO.saleVO.SalesmanListVO)
	 */
	@Override
	public DataRM commit(SalesmanListVO vo) {
		// TODO Auto-generated method stub
		try {
			vo.setState(State.IsCommitted);
			return service.commit(voToPo(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#openAllDraft()
	 */
	@Override
	public List<SalesmanListVO> openAllDraft() {
		// TODO Auto-generated method stub
		List<SalesmanListPO> polist = new ArrayList<SalesmanListPO>();
		List<SalesmanListVO> volist = new ArrayList<SalesmanListVO>();
		try {
			polist = service.openAllDraft();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
	//		return volist;
		}
		for(SalesmanListPO po : polist){
			volist.add(poToVo(po));
		}
		return volist;
	}
	
	
public abstract SalesmanListPO voToPo(SalesmanListVO vo);
public abstract SalesmanListVO poToVo(SalesmanListPO po);

/**
 * @param i
 * @return
 */
public SalesmanItemPO itemVoToPo(SalesmanItemVO i) {
	// TODO Auto-generated method stub
	return new SalesmanItemPO(i.getId(),i.getName(),i.getType(),i.getPrice(),i.getAmount(),i.getSum(),i.getNotes());
}


/**
 * @param i
 * @return
 */
public SalesmanItemVO itemPoToVo(SalesmanItemPO i) {
	// TODO Auto-generated method stub
	return new SalesmanItemVO(i.getId(),i.getName(),i.getType(),i.getPrice(),i.getAmount(),i.getSum(),i.getNotes());
}


/**
 * @param po
 * @return
 */
public List<SalesmanItemVO> generateVoList(SalesmanListPO po) {
	List<SalesmanItemPO> polist = po.getSaleListItems();
	List<SalesmanItemVO> volist = new ArrayList<SalesmanItemVO>();

	if(polist == null)
		volist = null;
	else{
	for(SalesmanItemPO i:polist){
		volist.add(itemPoToVo(i));
	}
	}
	return volist;
}

/**
 * @param svo
 * @return
 */
public List<SalesmanItemPO> generatePoList(SalesmanListVO vo) {
	List<SalesmanItemVO> volist = vo.getSaleListItems();
	List<SalesmanItemPO> polist = new ArrayList<SalesmanItemPO>();
	
	if(volist == null)
		polist = null;
	else{
	for(SalesmanItemVO i:volist){
		polist.add(itemVoToPo(i));
	}
	}
	return polist;
}

}
