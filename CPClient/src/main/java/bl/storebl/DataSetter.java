package bl.storebl;

import java.rmi.RemoteException;

import PO.AlarmListPO;
import PO.PresentListPO;
import PO.ReportListPO;
import PO.StoreLogPO;
import PO.StorePO;
import VO.listVO.ListRM;
import VO.storeVO.AlarmListVO;
import VO.storeVO.PresentListVO;
import VO.storeVO.ReportListVO;
import VO.storeVO.StoreLogVO;
import VO.storeVO.StoreVO;
import VO.storeVO.storeRM;
import dataService.storeDataService.StoreDataService;
//import dataService.storeDataService.StoreDataService_Stub;
import network.storeRemoteHelper.StoreDataServiceHelper;

public class DataSetter {
   //用于调用数据层接口中的方法，向数据层插入数据
	//工具类，为方便测试和优化结构写的。
	//王瑞华 2017年12月3日
	//StoreDataService sds=new StoreDataService_Stub();
	StoreDataServiceHelper helper=StoreDataServiceHelper.getInstance();
	StoreDataService sds=helper.getStoreDataService();
	DataGetter dg=new DataGetter();
	public storeRM insertStoreVO(StoreVO vo){
	//向数据库中插入一个库存项目，若该ID不存在，则允许插入，否则不允许。
		//其实我觉得ID合法性也有必要检查一下
		//数据层写好了以后就可以直接调数据库的方法
		StorePO po=new StorePO();
		po.alarmNum=vo.alarmNum;
		po.averagePrice=vo.averagePrice;
		po.ID=vo.ID;
		po.name=vo.name;
		po.Num=vo.Num;
		try {
			if(sds.insertStoreItem(po)){
			return storeRM.SUCCESS;
			}else {
				
				return storeRM.ID_EXIST;
			}
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return storeRM.ID_EXIST;
		}
		
	}
	
	public storeRM addStore(String id,int adder,double price){
		//向库存里添加某种商品的数量
		//其实同时应该记录一下为什么添加，有三种原因，报溢、销售退货、进货
		//只要ID对，加是一定会成功的。
		StoreVO vo=dg.getStoreVO(id);
		StorePO po=new StorePO();
		po.alarmNum=vo.alarmNum;
		po.ID=vo.ID;
		
		po.name=vo.name;
		vo.calcAveragePrice(vo.Num, adder, vo.averagePrice, price);
		po.averagePrice=vo.averagePrice;
		po.Num=vo.Num+adder;
		
		try {
			if(sds.replaceStoreItem(po)){
			    return storeRM.SUCCESS;
			}else{
				return storeRM.ID_NOT_EXIST;
			}
		} catch (RemoteException e) {
						e.printStackTrace();
						return storeRM.ID_EXIST;
		}
		
	}
	
	public storeRM subStore(String id,int subber){
		//向数据库减少某种商品的数量
		//在调用这个方法之前已经进行了前置条件检查，所以是一定会成功的。
		StoreVO vo=dg.getStoreVO(id);
		StorePO po=new StorePO();
		po.alarmNum=vo.alarmNum;
		po.ID=vo.ID;
		
		po.name=vo.name;
		po.averagePrice=vo.averagePrice;//商品在减少时均价不会变化。
		po.Num=vo.Num-subber;
		try {
			if(sds.replaceStoreItem(po)){
			    return storeRM.SUCCESS;
			}else{
				return storeRM.ID_NOT_EXIST;
			}
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return storeRM.ID_EXIST;
		}
	}
	
	public void insertAlarmListVO (AlarmListVO vo){
		//向数据库插入库存报警单值对象
		AlarmListPO po=new AlarmListPO();
		po.alarmNum=vo.alarmNum;
		po.currentNum=vo.currentNum;
		po.goodsID=vo.goodsID;
		po.id=vo.listID;
	
		po.goodsName=vo.goodsName;
		try {
			sds.addAlarmList(po);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
	}
	
	public ListRM insertReportListVO(ReportListVO vo){
		ReportListPO po=new ReportListPO();
		po.actualNum=vo.actualNum;
		po.delta=vo.delta;
		po.goodsID=vo.goodsID;
		po.GoodsName=vo.GoodsName;
		po.st=vo.st;
		po.statetype=vo.statetype;
		po.time=vo.time;
		po.Num=vo.Num;
		po.operator=vo.operator;
		po.listID=vo.listID;
		try {
			if(sds.insertReportList(po)){
				
				return ListRM.SUCCESS;
			}else {
				return ListRM.WRONG_LISTTYPE;
			}
		} catch (RemoteException e) {

			e.printStackTrace();
			return ListRM.WRONG_LISTTYPE;
		}
		//向数据库中插入库存报告单的值对象（保存状态为草稿）
	}
	public ListRM insertPresentListVO(PresentListVO vo){
		PresentListPO po=new PresentListPO ();
		po.id=vo.id;
		po.name=vo.name;
		po.listID=vo.listID;
		po.num=vo.num;
		po.operator=vo.operator;
		po.time=vo.time;
		po.statetype=vo.statetype;
		po.VIPname=vo.VIPname;
           try {
			if(sds.insertPresentList(po)){
				
				return ListRM.SUCCESS;
			}else {
				return ListRM.WRONG_LISTTYPE;
			}
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return ListRM.WRONG_LISTTYPE;
		}
	}
	
	public ListRM replaceReportListVO(ReportListVO vo){
		ReportListPO po=new ReportListPO();
		po.actualNum=vo.actualNum;
		po.delta=vo.delta;
		po.goodsID=vo.goodsID;
		po.GoodsName=vo.GoodsName;
		po.st=vo.st;
		po.statetype=vo.statetype;
		po.time=vo.time;
		po.Num=vo.Num;
		po.operator=vo.operator;
		po.listID=vo.listID;
		try {
			if(sds.replaceReportList(po)){
				
				return ListRM.SUCCESS;
			}else {
				return ListRM.WRONG_LISTTYPE;
			}
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return ListRM.WRONG_LISTTYPE;
		}
		
		//向数据库中插入库存报告单的值对象（保存状态为草稿）
	}
	public ListRM replacePresentListVO(PresentListVO vo){
		PresentListPO po=new PresentListPO ();
		po.id=vo.id;
		po.name=vo.name;
		po.listID=vo.listID;
		po.num=vo.num;
		po.operator=vo.operator;
		po.time=vo.time;
		po.statetype=vo.statetype;
		po.VIPname=vo.VIPname;
           try {
			if(sds.replacePresentList(po)){
				
				return ListRM.SUCCESS;
			}else {
				return ListRM.WRONG_LISTTYPE;
			}
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return ListRM.WRONG_LISTTYPE;
		}
	}
	public void addStoreLog(StoreLogVO vo){
		StoreLogPO po=new StoreLogPO();
		po.id=vo.id;
		po.name=vo.name;
		po.num=vo.num;
		po.time=vo.time;
		po.type=vo.type;
		po.price=vo.price;
		try {
			sds.addStoreLogPO(po);
		} catch (RemoteException e) {
	
			e.printStackTrace();
		}
	}
}
