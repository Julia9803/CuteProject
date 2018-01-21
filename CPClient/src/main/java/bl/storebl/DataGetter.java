package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import PO.AlarmListPO;
import PO.PresentListPO;
import PO.ReportListPO;
import PO.StoreLogPO;
import PO.StorePO;
import VO.storeVO.AlarmListVO;
import VO.storeVO.PresentListVO;
import VO.storeVO.ReportListVO;
import VO.storeVO.StoreLogVO;
import VO.storeVO.StoreVO;
import VO.storeVO.storeRM;
import dataService.storeDataService.StoreDataService;
//import dataService.storeDataService.StoreDataService_Stub;
import network.storeRemoteHelper.StoreDataServiceHelper;
import util.State;
//import network.storeRemoteHelper.StoreDataServiceHelper;
import util.StoreListType;

public class DataGetter  {
    //用于获取数据，在开发时先写好这个类，方便测试驱动。
    /*
    *这是一个工具类，用于从底层获得数据
    * 写这个类主要是因为数据库现在还没写好，接口层还没写，故而用它做一个桥梁
    * 等数据库写好了再用它去调用数据库的实现就可以（事实上二者最终可以合并）
    *  王瑞华 161250143 2017年12月2日
     */
	//StoreDataService sds=new StoreDataService_Stub();
	
	StoreDataServiceHelper helper=StoreDataServiceHelper.getInstance();
	StoreDataService sds=helper.getStoreDataService();
	
     LinkedList<AlarmListVO> getAllAlarmList() {
         LinkedList<AlarmListVO> voList=new LinkedList<AlarmListVO>();
         LinkedList<AlarmListPO> poList;
         
		try {
			poList = sds.getAlarmListPO();
			for(int i=poList.size()-1;i>=0;i--){
	        	 //倒序处理一下，最近的单据最先显示
	        	 AlarmListVO vo=new AlarmListVO(poList.get(i).alarmNum, poList.get(i).currentNum,
	        			 poList.get(i).id, poList.get(i).goodsID, poList.get(i).goodsName);
	        	 voList.add(vo);
	         }
		} catch (RemoteException e) {
			System.out.println("库存方法异常1：得到报警单失败");
		}
         
         return voList;
     }
     ArrayList<ReportListVO> getReportList(StoreListType type, State st) {
         ArrayList<ReportListVO> voList=new      ArrayList<ReportListVO>();
         try{
         ArrayList<ReportListPO> poList=sds.getReportListPO(type, st);
         
         for(int i=poList.size()-1;i>=0;i--){
        	 ReportListVO vo=new ReportListVO (poList.get(i).actualNum, poList.get(i).Num, poList.get(i).goodsID, poList.get(i).listID, poList.get(i).GoodsName);
        	 vo.operator=poList.get(i).operator;
        	 vo.time=poList.get(i).time;
        	 vo.st=poList.get(i).st;
        	 vo.statetype=poList.get(i).statetype;
        	 vo.delta=poList.get(i).delta;
        	 voList.add(vo);
         }
         }catch(RemoteException e){
        	 System.out.println("库存方法异常2：得到报告单失败");

         }
             return voList;
     }
    ArrayList<PresentListVO> getPresentList(State st) {
    	ArrayList<PresentListVO> voList=new ArrayList<PresentListVO>();
    	try{
        ArrayList<PresentListPO> poList=sds.getPresentListPO(st);
        
        for(int i=poList.size()-1;i>=0;i--){
       	 //倒序处理一下，最近的单据最先显示
        PresentListVO vo=new PresentListVO(poList.get(i).listID, poList.get(i).id,poList.get(i).num , poList.get(i).name, poList.get(i).VIPname);
        vo.setTime(poList.get(i).time);
        vo.setOperator(poList.get(i).operator);
        vo.statetype=poList.get(i).statetype;
        
        voList.add(vo);
        }
    	}catch(RemoteException e){
       	 System.out.println("库存方法异常3：得到赠送单失败");

        }
         return voList;
    }

    public String calcID(StoreListType lt)  {
    	String s="";
        try {
        	if(sds==null){
        		System.out.println("sds为空");
        	}
		s= sds.calcID(lt);
		} catch (RemoteException e) {
			System.out.println("库存方法异常4：计算单据编号失败");
		}
    	return s;
    }
    
    public storeRM checkID(List<String> id) {
    	//用于检查一组id是否存在，若有一个id不存在，则返回wrong_id
    	try{
    	for(int i=0;i<id.size();i++){
    		if(sds.checkID(id.get(i))==false){
    			return storeRM.ID_NOT_EXIST;
    		}
    	}
    	}catch (RemoteException e) {
			System.out.println("库存方法异常5:检查库存数量失败");
		}
    	return storeRM.SUCCESS;
    }
    
    public storeRM checkID(String id) {
    	
    	try {
			if(sds.checkID(id)){
				return storeRM.SUCCESS;
			}else{
				
				return storeRM.ID_NOT_EXIST;
			}
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
    	return storeRM.ID_NOT_EXIST;
    	//用于检查一个ID是否存在，若不存在，则返回wrong_id
		//这里检查的是库存项的ID，不是表单的ID
    }
    
    public storeRM checkAlarm(String id ,int subber) {
    	//用于检查库存在减掉某个值之后的状态，可能不足，也可能触发报警，没问题的话返回success
    	
    	StoreVO vo=null;
		vo = getStoreVO(id);
    	if(vo==null){
    		return storeRM.ID_NOT_EXIST;//防御式编程一下
    	}
    	if(vo.Num-subber<0){
    		return storeRM.STORE_NOT_ENOUGH;
    	}else if(vo.Num-subber<=vo.alarmNum){
    		return storeRM.ALARM;
    	}else{
    		return storeRM.SUCCESS;
    	}
		
    	
    }
    
    public StoreVO getStoreVO(String id) {
    	//用于查单个库存项
    	StorePO po=null;
    	try {
			po=sds.getStorePO(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	StoreVO vo=new StoreVO(po.name, po.ID, po.alarmNum, po.Num);
    	vo.averagePrice=po.averagePrice;
    	
    	return vo;
    }
    public ArrayList<StoreVO> getAllStoreVO() {
    	ArrayList<StoreVO> voArr=new ArrayList<StoreVO>();
    	
    	ArrayList<StorePO> poArr;
		try {
			poArr = sds.getAllStorePO();
	    	for(int i=0;i<poArr.size();i++){
	    		StoreVO vo=new StoreVO(poArr.get(i).name,poArr.get(i).ID,poArr.get(i).alarmNum,poArr.get(i).Num);
	    		vo.averagePrice=poArr.get(i).averagePrice;
	    		voArr.add(vo);
	    	}
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}

    	

    	return voArr;
    }
   public ReportListVO getReportListVO(String id) {
    	//查找单个库存报告单对象
	   ReportListPO po=null;
	   try {
		po=sds.getSingleReportList(id);
	} catch (RemoteException e) {
		e.printStackTrace();
	}
	   ReportListVO vo=new ReportListVO (po.actualNum, po.Num, po.goodsID, po.listID, po.GoodsName);
	   vo.time=po.time;
	   vo.operator=po.operator;
	   vo.st=po.st;
	   vo.delta=po.delta;
	   vo.statetype=po.statetype;
		return vo;
    	
    }
    public PresentListVO getPresentListVO(String id) {
    	//查找单个库存赠送单对象
    	PresentListPO po=null;
    	try {
			po=sds.getSinglePresentList(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	PresentListVO vo=new PresentListVO(po.listID, po.id,po.num , po.name, po.VIPname);
    	vo.operator=po.operator;
    	vo.statetype=po.statetype;
    	vo.time=po.time;
    	
		return vo;
    	
    }
    
    public ArrayList<StoreLogVO> getLogs(String beginTime,String endTime) {
    	ArrayList<StoreLogVO> voArr=new ArrayList<StoreLogVO>();
    	try{
    	ArrayList<StoreLogPO> poArr=sds.getStoreLogPO(beginTime,endTime);
    	
    	for(int i=0;i<poArr.size();i++){
    		StoreLogVO vo=new StoreLogVO();
    		vo.id=poArr.get(i).id;
    		vo.name=poArr.get(i).name;
    		vo.num=poArr.get(i).num;
    		vo.price=poArr.get(i).price;
    		vo.time=poArr.get(i).time;
    		vo.type=poArr.get(i).type;
    		voArr.add(vo);
    	}
    	}catch (RemoteException e) {
			e.printStackTrace();
		}
    	return voArr;
    }
}
