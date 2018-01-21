package bl.storebl;


import java.util.ArrayList;
import java.util.LinkedList;

import VO.listVO.ListRM;
import VO.storeVO.AlarmListVO;
import VO.storeVO.PresentListVO;
import VO.storeVO.ReportListVO;
import VO.storeVO.StoreVO;
import VO.storeVO.storeCheckVO;
import VO.storeVO.storeInventoryVO;
import VO.storeVO.storeRM;
import bl.goodsbl.GetGoodsInfo_Impl;
import blservice.storeblservice.StoreBLService;
import util.ExcelUtil;
import util.State;
import util.StoreListType;

public class StoreblController implements StoreBLService{
    //控制器，负责分发库存类的职责
    // 王瑞华 161250143 2017年12月2日
    DataGetter getter=new DataGetter();
    DataSetter setter =new DataSetter();
    @Override
    public LinkedList<AlarmListVO> openAlarmList() {
        //查看全部库存报警单
        return getter.getAllAlarmList();
    }

    @Override
    public ArrayList<ReportListVO> openReportList(StoreListType lt, State st) {
        //查看库存报告单
        return getter.getReportList(lt,st);
    }

    @Override
    public ArrayList<PresentListVO> openPresentList(State st) {
        //查看赠送单
        return getter.getPresentList(st);
    }

    @Override
    public String toExcel(storeInventoryVO vo,String path) {
    	if(path==null||!path.endsWith(".xls")){
    		return "地址错误";    //防御式编程一下
    	}
        //导出当日库存快照
    	ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
    	ArrayList<String> arr0=new ArrayList<String>();
    	arr0.add("行号");
    	arr0.add("商品编号");
    	arr0.add("商品名称");
    	arr0.add("库存数量");
    	arr0.add("库存均价");
    	arr0.add("型号");
    	arr0.add("出厂日期");
    	result.add(arr0);
    	int t=1;
    	for(int i=0;i<vo.Model.size();i++){
    		ArrayList<String> arr1=new ArrayList<String>();
    		arr1.add(Integer.toString(t));
    		arr1.add(vo.storeVO_Arr.get(i).ID);
    		arr1.add(vo.storeVO_Arr.get(i).name);
    		arr1.add(Integer.toString(vo.storeVO_Arr.get(i).Num));
    		arr1.add(Double.toString(vo.storeVO_Arr.get(i).averagePrice));
    		
    		arr1.add(vo.Model.get(i));
    		arr1.add(vo.Date.get(i));
    		result.add(arr1);
    		t++;
    		}
    	
    	ExcelUtil.writeExcel(result, path);
    	return "导出成功！";
    }

    @Override
    public String newList(StoreListType type) {
        return getter.calcID(type);
    }

    @Override
    public ListRM saveReportList( ReportListVO vo) {
    	//保存草稿单：
    	//再次说明：保存并提交这个操作需要手动调用保存并手动调用提交
    	vo.statetype=State.IsDraft;
        return setter.insertReportListVO(vo);
    }


    @Override
    public ListRM savePresentList(PresentListVO vo) {
    	vo.statetype=State.IsDraft;
        return setter.insertPresentListVO(vo);
    }

    @Override
    public ListRM commit(StoreListType type, String ID) {
    	if(type.equals(StoreListType.PRESENT)){
            PresentListVO vo =getter.getPresentListVO(ID);
            PresentList pl=new PresentList(vo);
            pl.commit();
            vo.statetype=State.IsCommitted;
            setter.replacePresentListVO(vo);
            return ListRM.SUCCESS;
            
    	}else if(type.equals(StoreListType.OVERFLOW)||type.equals(StoreListType.LOSS)){
    		ReportListVO vo=getter.getReportListVO(ID);
    		ReportList rl=new ReportList(vo);
    		rl.commit();
    		vo.statetype=State.IsCommitted;
    		setter.replaceReportListVO(vo);
    		
    		return ListRM.SUCCESS;
    	}else{
        return ListRM.WRONG_LISTTYPE;
    	}
    }



    @Override
    public storeCheckVO store_check(String begintime, String endTime) {
    	storeCheckVO vo=new storeCheckVO(getter.getLogs(begintime, endTime));
        return vo;
    }

    @Override
    public storeInventoryVO store_inventory() {
    	GetGoodsInfo getgoodsinfo=new GetGoodsInfo_Impl();
    	storeInventoryVO vo=new storeInventoryVO();
    	vo.storeVO_Arr=getter.getAllStoreVO();
    	
    	ArrayList<String> id=new ArrayList<String>();
    	for(int i=0;i<vo.storeVO_Arr.size();i++){
    		id.add(vo.storeVO_Arr.get(i).ID);
    	}
    	vo.Date=getgoodsinfo.getDate_byID(id);
    	vo.Model=getgoodsinfo.getModel_byID(id);
        return vo;
    }

	@Override
	public StoreVO getStoreVO(String id) {
		if(getter.checkID(id).equals(storeRM.SUCCESS)){
			return getter.getStoreVO(id);
		}
		return null;
	}
}
