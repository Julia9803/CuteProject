package bl.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.PresentResultPO;
import PO.SaleListPO;
import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import VO.GoodsInSaleVO;
import VO.listVO.InfoListVO;
import VO.listVO.ListRM;
import VO.presentVO.PresentResultVO;
import VO.saleVO.SaleListVO;
import VO.saleVO.SaleVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import VO.storeVO.PresentListVO;
import VO.storeVO.storeRM;
import bl.VIPbl.VIPCollectionModifyImpl;
import bl.goodsbl.GoodsRecentImpl;
import bl.listbl.Approvable;
import bl.listbl.InfoList_Impl;
import bl.presentbl.PresentBLInfoImpl;
import bl.storebl.Store_Interface;
import bl.storebl.Store_InterfaceImpl;
import bl.utility.GoodsInSaleVoTransPo;
import blservice.VIPblservice.VIPCollectionModify;
import blservice.goodsblservice.GoodsRecent;
import blservice.presentblservice.PresentBLInfo;
import blservice.saleblservice.SaleListBLService;
import dataService.saleDataService.SaleListDataService;
import network.saleRemoteHelper.SaleListDataServiceHelper;
import resultmessage.DataRM;
import resultmessage.ResultMessage;
import util.DateUtil;
import util.GreatListType;
import util.State;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleListBLServiceImpl implements SaleListBLService,Approvable{

	SaleListDataService service = SaleListDataServiceHelper.getInstance().getSaleListDataService();
	InfoList_Impl info = new InfoList_Impl();
	
	Store_Interface storeChange = new Store_InterfaceImpl();
	GoodsRecent goodsRecentChange = new GoodsRecentImpl();
	VIPCollectionModify vipChange = new VIPCollectionModifyImpl();
	
	@Override
	public String getId() {
		try {
			System.out.println(service);
			String id = service.insert();
			System.out.println(id);
			return id;
		//	return presentForSumDataService.insert();
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public SalesmanListVO get(String id){
		try {
			return poToVo(service.get(id));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#delete(java.lang.String)
	 */
	@Override
	public DataRM delete(String id) {
		try {
			return service.delete(id);
		} catch (RemoteException e) {
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
	public DataRM approve(SalesmanListVO vo,boolean isWriteoff){
		
	double collection = 0;
		//检查库存是否足够
		storeRM storeRm = storeRM.SUCCESS;
		List<String> id = new ArrayList<String>();
		List<Integer> subber = new ArrayList<Integer>();
		if(!isWriteoff){	
		for(SalesmanItemVO i : vo.getSaleListItems()){
			id.add(i.getId());
			subber.add(i.getAmount());
		}
		boolean checkResult = storeChange.check(id, subber);
		if(checkResult == false){
			return DataRM.STOCK_FAILED;
		}
		
		//检查客户应收应付

		try {
			double limit = vipChange.checkVIPCollectionLimit(vo.getMemberName());
			collection = vipChange.getVIPCollection(vo.getMemberName());
			double sum = vo.getSum();
			
			if(limit < collection + sum)
				return DataRM.VIP_FAILED;
		} catch (RemoteException e1) {
			e1.printStackTrace();
			return DataRM.NET_FAILED;
		}
		
		}
		try {
			vo.setState(State.IsApproved);
			DataRM rm = service.save(voToPo(vo));
			ResultMessage resultRm = ResultMessage.SUCCESS;
			if(rm == DataRM.SUCCESS){	
				for(SalesmanItemVO i : vo.getSaleListItems()){
				//减少库存
					storeRm = storeChange.minusNumber(i.getId(), i.getAmount(), GreatListType.STOCK);
					if(storeRm != storeRM.SUCCESS){
						return DataRM.FAILED;
					}
					
					//更改最近售价	
					resultRm = goodsRecentChange.setGoodsRecentSellPrice(i.getPrice(), i.getName(), null);
					if(resultRm != ResultMessage.SUCCESS){
						return DataRM.FAILED;
					}
				}
				//修改应收
					resultRm = vipChange.setVIPCollection(vo.getMemberName(), vo.getSum()+collection);
					if(resultRm != ResultMessage.SUCCESS){
						return DataRM.FAILED;
					}
				//通知销售人员
				//生成库存赠送单
					if(!isWriteoff){
				SaleListVO svo = (SaleListVO)vo;
				PresentListVO presentList = new PresentListVO();
				presentList.VIPname = svo.getMemberName();
				PresentResultVO pvo = svo.getPresentResultVO();
				if(pvo != null){
				if(pvo.getPresentList()!=null)
				for(GoodsInSaleVO i : pvo.getPresentList()){
					presentList.id.add(i.getId());
					presentList.num.add(i.getAmount());
					presentList.name.add(i.getGoodsName());
				}
				boolean createPresentList = storeChange.createPresentList_auto(presentList);
				
					}
					}
				//发消息
				if(!isWriteoff){
				new ListToMessage().sendMessage((SaleListVO)vo);
				info.modify(true, vo.getId());
				}
				
			}
			return rm;
		} catch (RemoteException e) {
			e.printStackTrace();
			return DataRM.NET_FAILED;
		} 
	}
	
	@Override
	public DataRM reject(SalesmanListVO vo){
		try {
			vo.setState(State.IsRefused);
			DataRM returnMessage =  service.save(voToPo(vo));
			if(returnMessage == DataRM.SUCCESS){
					info.modify(false, vo.getId());
				}
			return returnMessage;

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
			DataRM returnMessage =  service.commit(voToPo(vo));
			if(returnMessage == DataRM.SUCCESS){
				info.register(new InfoListVO(vo.getId(),GreatListType.SALE,vo.getOperator(),vo.getNotes()));
			}
			
			return returnMessage;

		} catch (RemoteException e) {
			e.printStackTrace();
			return DataRM.FAILED;
		}
	}

	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleUniBLService#openAllDraft()
	 */
	@Override
	public List<SalesmanListVO> openAllDraft() {
		List<SalesmanListPO> polist = new ArrayList<SalesmanListPO>();
		List<SalesmanListVO> volist = new ArrayList<SalesmanListVO>();
		try {
			polist = service.openAllDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
	//		return volist;
		}
		if(polist == null)
			return null;
		for(SalesmanListPO po : polist){
			System.out.println(po);
			volist.add(poToVo(po));
		}
		return volist;
	}

/**
 * @param i
 * @return
 */
public SalesmanItemPO itemVoToPo(SalesmanItemVO i) {
	if(i == null)
		return null;
	return new SalesmanItemPO(i.getId(),i.getName(),i.getType(),i.getPrice(),i.getAmount(),i.getSum(),i.getNotes());
}


/**
 * @param i
 * @return
 */
public SalesmanItemVO itemPoToVo(SalesmanItemPO i) {
	if(i == null)
		return null;
	return new SalesmanItemVO(i.getId(),i.getName(),i.getType(),i.getPrice(),i.getAmount(),i.getSum(),i.getNotes());
}


/**
 * @param po
 * @return
 */
public List<SalesmanItemVO> generateVoList(SalesmanListPO po) {
	if(po == null)
		return null;
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
	if(vo == null)
		return null;
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

	public SalesmanListPO voToPo(SalesmanListVO vo) {
		if(vo == null)
			return null;
		
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
		return new SaleListPO(svo.getId(),svo.getState(),
				DateUtil.getDateFromListID(svo.getId()),svo.getOperatorGrade(),
				svo.getMemberID(),svo.getMemberName(),svo.getGrade(),svo.getOperator(),svo.getOperatorId(),
				svo.getRealOperator(),svo.getWarehouse(),svo.getNotes(),polist,svo.getSum(),
				svo.getSumBeforeRebate(),svo.getRebate(),svo.getVoucher(),voToPo(svo.getPresentResultVO()));
	}



	public SalesmanListVO poToVo(SalesmanListPO po) {
		SaleListPO spo = (SaleListPO)po;
		if(po == null)
			return null;
		List<SalesmanItemPO> polist = spo.getSaleListItems();
		List<SalesmanItemVO> volist = new ArrayList<SalesmanItemVO>();

		if(polist == null)
			volist = null;
		else{
		for(SalesmanItemPO i:polist){
			volist.add(itemPoToVo(i));
		}
		}
		
		PresentResultVO vo = poToVo(spo.getPresentResultPO());
		System.out.println("in big"+vo);
		return new SaleListVO(spo.getId(), spo.getOperator(),spo.getOperatorId(), spo.getState(),spo.getOperatorGrade(),spo.getMemberID(), spo.getMemberName(),spo.getGrade(),spo.getRealOperator(), spo.getWarehouse(), spo.getNotes(), 
				volist, spo.getSum(), spo.getSumBeforeRebate(), 
				spo.getRebate(), spo.getVoucher(),poToVo(spo.getPresentResultPO()));
	}

	
	
	private PresentResultVO poToVo(PresentResultPO po){
		System.out.println(po);
		if(po != null){
			PresentResultVO vo = 
		new PresentResultVO(po.getPresentId(),po.getVoucher(),GoodsInSaleVoTransPo.GoodsInSalePoToVo(po.getPresentList()),po.getSum());
		System.out.println(vo.getPresentId());
		System.out.println(vo);
		return vo;
		
		}	else
			 return null;
	}
	
	private PresentResultPO voToPo(PresentResultVO vo){
		if(vo != null)
		
			return new PresentResultPO(vo.getPresentId(),vo.getVoucher(),GoodsInSaleVoTransPo.GoodsInSaleVoToPo(vo.getPresentList()),vo.getSum());
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see bl.listbl.Approvable#Approve(java.lang.String)
	 */
	@Override
	public ListRM Approve(String id) {
		DataRM rm = DataRM.FAILED;
		try {
			rm = approve(poToVo(service.get(id)),false);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ListRM.REFUSED;
		}
		if(rm == DataRM.SUCCESS){
			return ListRM.SUCCESS;
		}
		
		return ListRM.REFUSED;
	}

	/* (non-Javadoc)
	 * @see blservice.saleblservice.SaleListBLService#findPresent(VO.saleVO.SaleVO)
	 */
	@Override
	public PresentResultVO findPresent(SaleVO vo) {
		PresentBLInfo impl = new PresentBLInfoImpl();
		return impl.findPresent(vo);
	}


}
