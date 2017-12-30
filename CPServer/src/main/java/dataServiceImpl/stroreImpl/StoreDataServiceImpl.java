package dataServiceImpl.stroreImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;

import PO.AlarmListPO;
import PO.PresentListPO;
import PO.ReportListPO;
import PO.StoreLogPO;
import PO.StorePO;
import dataHelper.HibernateUtil_Green;
import util.State;
import dataService.storeDataService.StoreDataService;
import util.StoreListType;
public class StoreDataServiceImpl  implements  StoreDataService {






	@Override
	public boolean checkID(String id) {
		// 这个方法应该是库存项专用的，不过也可以把它改成通用的
		return false;
	}

	@Override
	public StorePO getStorePO(String id) {
		HibernateUtil_Green<StorePO> util=new HibernateUtil_Green<StorePO>(StorePO.class);
		StorePO po=util.get(id);
		return po;
	}

	@Override
	public String calcID(StoreListType lt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<AlarmListPO> getAlarmListPO() {
		HibernateUtil_Green<AlarmListPO> util= new HibernateUtil_Green<AlarmListPO>(AlarmListPO.class);
		LinkedList<AlarmListPO> list=(LinkedList<AlarmListPO>) util.getList();
		return list;
	}

	@Override
	public ArrayList<PresentListPO> getPresentListPO(State st) {
		HibernateUtil_Green<PresentListPO> util= new HibernateUtil_Green<PresentListPO>(PresentListPO.class);
		ArrayList<PresentListPO> list= (ArrayList<PresentListPO>) util.getList();
		ArrayList<PresentListPO> list1=new ArrayList<PresentListPO> ();
		for(int i=0;i<list.size();i++){
			if(list.get(i).statetype.equals(st)){
				list1.add(list.get(i));
			}
		}
		return list1;
	}

	@Override
	public ArrayList<ReportListPO> getReportListPO(StoreListType type, State st) {
		HibernateUtil_Green<ReportListPO> util=new HibernateUtil_Green<ReportListPO>(ReportListPO.class);
		ArrayList<ReportListPO> list =(ArrayList<ReportListPO>) util.getList();
		ArrayList<ReportListPO> list1=new ArrayList<ReportListPO>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).statetype.equals(st)&&list.get(i).st.equals(type)){
				list1.add(list.get(i));
			}
		}
		return list1;
	}

	@Override
	public PresentListPO getSinglePresentList(String id) {
		HibernateUtil_Green<PresentListPO> util= new HibernateUtil_Green<PresentListPO>(PresentListPO.class);
		PresentListPO po=util.get(id);
		return po;
	}

	@Override
	public ReportListPO getSingleReportList(String id) {
		HibernateUtil_Green<ReportListPO> util=new HibernateUtil_Green<ReportListPO>(ReportListPO.class);
		ReportListPO po=util.get(id);
		return po;
	}

	@Override
	public ArrayList<StoreLogPO> getStoreLogPO(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StorePO> getAllStorePO() {
		HibernateUtil_Green<StorePO> util= new HibernateUtil_Green<StorePO>(StorePO.class);
		ArrayList<StorePO> poList=(ArrayList<StorePO>)util.getList();
		return poList;
	}

	@Override
	public boolean insertStoreItem(StorePO po) {
		HibernateUtil_Green<StorePO> util= new HibernateUtil_Green<StorePO>(StorePO.class);
        return util.insert(po);

	}

	@Override
	public boolean replaceStoreItem(StorePO po) {
		HibernateUtil_Green<StorePO> util= new HibernateUtil_Green<StorePO>(StorePO.class);
		return util.update(po);

	}

	@Override
	public void addAlarmList(AlarmListPO po) {
		HibernateUtil_Green<AlarmListPO> util= new HibernateUtil_Green<AlarmListPO>(AlarmListPO.class);
		util.insert(po);
		
	}

	@Override
	public boolean insertReportList(ReportListPO po) {
		HibernateUtil_Green<ReportListPO> util=new HibernateUtil_Green<ReportListPO>(ReportListPO.class);
		return util.insert(po);

	}

	@Override
	public boolean replaceReportList(ReportListPO po) {
		HibernateUtil_Green<ReportListPO> util=new HibernateUtil_Green<ReportListPO>(ReportListPO.class);
		return util.update(po);

	}

	@Override
	public boolean insertPresentList(PresentListPO po) {
		HibernateUtil_Green<PresentListPO> util= new HibernateUtil_Green<PresentListPO>(PresentListPO.class);
		return util.insert(po);

	}

	@Override
	public boolean replacePresentList(PresentListPO po) {
		HibernateUtil_Green<PresentListPO> util= new HibernateUtil_Green<PresentListPO>(PresentListPO.class);
		return util.update(po);

	}

	@Override
	public void addStoreLogPO(StoreLogPO po) {
		HibernateUtil_Green<StoreLogPO> util= new HibernateUtil_Green<StoreLogPO>(StoreLogPO.class);
		util.insert(po);
		
	}
    
}
