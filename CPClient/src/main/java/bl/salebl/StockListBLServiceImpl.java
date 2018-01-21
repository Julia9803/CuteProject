package bl.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import PO.StockListPO;
import VO.listVO.InfoListVO;
import VO.listVO.ListRM;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import VO.storeVO.storeRM;
import bl.VIPbl.VIPCollectionModifyImpl;
import bl.goodsbl.GoodsRecentImpl;
import bl.listbl.Approvable;
import bl.listbl.InfoList_Impl;
import bl.storebl.Store_Interface;
import bl.storebl.Store_InterfaceImpl;
import blservice.VIPblservice.VIPCollectionModify;
import blservice.goodsblservice.GoodsRecent;
import blservice.saleblservice.StockListBLService;
import dataService.saleDataService.StockListDataService;
import network.saleRemoteHelper.StockListDataServiceHelper;
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
public class StockListBLServiceImpl implements StockListBLService,Approvable{
	StockListDataService service = StockListDataServiceHelper.getInstance().getStockListDataService();
	InfoList_Impl info = new InfoList_Impl();

	Store_Interface storeChange = new Store_InterfaceImpl();
	GoodsRecent goodsRecentChange = new GoodsRecentImpl();

	VIPCollectionModify vipChange = new VIPCollectionModifyImpl();
	
	
	/* (non-Javadoc)
	 * @see bl.salebl.SaleUniBLServiceImpl#voToPo(VO.saleVO.SalesmanListVO)
	 */
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		try {
			System.out.println(service);
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
	public DataRM approve(SalesmanListVO vo,boolean isWriteoff){
		
		try {
			storeRM storeRm = storeRM.SUCCESS;
			List<String> id = new ArrayList<String>();
			List<Integer> subber = new ArrayList<Integer>();
			if(isWriteoff){
				
					for(SalesmanItemVO i : vo.getSaleListItems()){
						id.add(i.getId());
						subber.add(i.getAmount());
					}
					boolean checkResult = storeChange.check(id, subber);
					if(checkResult == false){
						return DataRM.STOCK_FAILED;
					}
				
			}
			vo.setState(State.IsApproved);
			DataRM rm = service.save(voToPo(vo));

			storeRm = storeRM.SUCCESS;
			ResultMessage resultRm = ResultMessage.SUCCESS;
			if(rm == DataRM.SUCCESS){
				
				for(SalesmanItemVO i : vo.getSaleListItems()){
				//增加库存
					storeRm = storeChange.plusNumber(i.getId(), i.getAmount(), GreatListType.STOCK, i.getPrice());
					System.out.println(i.getId()+ " " + i.getAmount()+" "+i.getPrice());
					if(storeRm != storeRM.SUCCESS){
						System.out.println("不能增加库存");
						return DataRM.FAILED;
					}
				//更改最近进价	
					resultRm = goodsRecentChange.setGoodsRecentBuyPrice(i.getPrice(), i.getName(), null);
					if(resultRm != ResultMessage.SUCCESS){
						System.out.println("不能修改进价");
						return DataRM.FAILED;
					}
				}
				//修改应付
					resultRm = vipChange.setVIPPayment(vo.getMemberName(), vo.getSum()+vipChange.getVIPPayment(vo.getMemberName()));
					if(resultRm != ResultMessage.SUCCESS){
						System.out.println("不能修改应付");
						return DataRM.FAILED;
					}				
				//发消息
					if(!isWriteoff){
					new ListToMessage().sendMessage((StockListVO)vo);
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
				info.register(new InfoListVO(vo.getId(),GreatListType.STOCK,vo.getOperator(),vo.getNotes()));
			}
			
			return returnMessage;
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
		if(polist != null)
		for(SalesmanListPO po : polist){
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
	public SalesmanListPO voToPo(SalesmanListVO vo) {
		if(vo == null)
			return null;
		StockListVO svo = (StockListVO)vo;
		List<SalesmanItemPO> polist = generatePoList(svo);
		return new StockListPO(svo.getId(),svo.getState(),DateUtil.getDateFromListID(svo.getId()),svo.getOperatorGrade(),svo.getMemberID(),svo.getMemberName(),svo.getOperator(),svo.getOperatorId(),svo.getRealOperator(),svo.getWarehouse(),svo.getNotes(),polist,svo.getSum());
	}



	public SalesmanListVO poToVo(SalesmanListPO po) {
		if(po == null)
			return null;
		StockListPO spo = (StockListPO)po;
		List<SalesmanItemVO> volist = generateVoList(po);
		//留了一个空项，看以后是存操作员的id还是名称
		return new StockListVO(spo.getId(), spo.getOperator(), spo.getOperatorId(), spo.getState(),spo.getOperatorGrade(),spo.getMemberID(), spo.getMemberName(),spo.getRealOperator(), spo.getWarehouse(), spo.getNotes(), volist, spo.getSum());
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
			return ListRM.REFUSED;
		}
		if(rm .equals(DataRM.SUCCESS) ){
			return ListRM.SUCCESS;
		}
		else{
			System.out.print("审批失败了");
		return ListRM.REFUSED;
		
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
}
