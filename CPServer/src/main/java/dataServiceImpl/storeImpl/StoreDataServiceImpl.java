package dataServiceImpl.storeImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import PO.AlarmListPO;
import PO.PresentListPO;
import PO.ReportListPO;
import PO.StoreListID;
import PO.StoreLogPO;
import PO.StorePO;
import dataHelper.serviceImpl.HibernateUtil_Green;
import dataService.storeDataService.StoreDataService;
import util.State;
import util.StoreListType;
public class StoreDataServiceImpl extends UnicastRemoteObject implements  StoreDataService {




	private static final long serialVersionUID = 1L;
	
	public StoreDataServiceImpl() throws RemoteException{
		super();
	}

	@Override
	public boolean checkID(String id) throws RemoteException{
		// 这个方法应该是库存项专用的，不过也可以把它改成通用的
		
		StorePO  po=getStorePO(id);
		if(po!=null){
			
			return true;
		}
		else{
		return false;
		}
	}

	@Override
	public StorePO getStorePO(String id) throws RemoteException{
		HibernateUtil_Green<StorePO> util=new HibernateUtil_Green<StorePO>(StorePO.class);
		StorePO po=util.get(id);

		return po;
	}

	@Override
	public String calcID(StoreListType lt) throws RemoteException{
		String s;
		String day=calcTime();
		HibernateUtil_Green<StoreListID> hug=new HibernateUtil_Green<StoreListID>(StoreListID.class);
		StoreListID slid=hug.get(lt.toString());
		if(slid.day==null||(!slid.day.equals(day))){
			slid.day=day;
			slid.num=2;
			s=slid.listName+"-"+day+"-00001";
			hug.update(slid);
			System.out.println("编号未增加");
		}else{
			String num=Integer.toString(slid.num);
			s=slid.listName+"-"+day;
			int tempsize=5-num.length();
			for(int i=0;i<tempsize;i++){
				num="0"+num;
			}
			s=s+"-"+num;
			slid.num++;
			hug.update(slid);
			System.out.println("编号已经增加");
		}
	
		return s;
	}

	@Override
	public LinkedList<AlarmListPO> getAlarmListPO() throws RemoteException{
		HibernateUtil_Green<AlarmListPO> util= new HibernateUtil_Green<AlarmListPO>(AlarmListPO.class);
		ArrayList<AlarmListPO> list= (ArrayList<AlarmListPO>)util.getList();
		LinkedList<AlarmListPO>list1=new LinkedList<AlarmListPO>();
		for(int i=0;i<list.size();i++){
			list1.add(list.get(i));
		}
	
		return list1;
	}

	@Override
	public ArrayList<PresentListPO> getPresentListPO(State st) throws RemoteException{
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
	public ArrayList<ReportListPO> getReportListPO(StoreListType type, State st) throws RemoteException{
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
	public PresentListPO getSinglePresentList(String id) throws RemoteException{
		HibernateUtil_Green<PresentListPO> util= new HibernateUtil_Green<PresentListPO>(PresentListPO.class);
		PresentListPO po=util.get(id);
		return po;
	}

	@Override
	public ReportListPO getSingleReportList(String id) throws RemoteException{
		HibernateUtil_Green<ReportListPO> util=new HibernateUtil_Green<ReportListPO>(ReportListPO.class);
		ReportListPO po=util.get(id);
		return po;
	}

	@Override
	public ArrayList<StoreLogPO> getStoreLogPO(String beginTime, String endTime) throws RemoteException{
		HibernateUtil_Green<StoreLogPO> util=new HibernateUtil_Green<StoreLogPO>(StoreLogPO.class);
		ArrayList<StoreLogPO> arr1=(ArrayList<StoreLogPO>)util.getList();
		ArrayList<StoreLogPO> arr2=new ArrayList<StoreLogPO>();
		beginTime=beginTime.replace("-", "");
		endTime=endTime.replace("-", "");
		for(int i=0;i<arr1.size();i++){
			String s0=arr1.get(i).time;
			String []x0=s0.split(" ");
		    s0=x0[0];
			s0=s0.replace("-", "");
			int temp=Integer.parseInt(s0);
			if(Integer.parseInt(beginTime)<=temp&&Integer.parseInt(endTime)>=temp){
				arr2.add(arr1.get(i));
			}
		}
		return arr2;
	}

	@Override
	public ArrayList<StorePO> getAllStorePO() throws RemoteException{
		HibernateUtil_Green<StorePO> util= new HibernateUtil_Green<StorePO>(StorePO.class);
		ArrayList<StorePO> poList=(ArrayList<StorePO>)util.getList();
		return poList;
	}

	@Override
	public boolean insertStoreItem(StorePO po) throws RemoteException{
		HibernateUtil_Green<StorePO> util= new HibernateUtil_Green<StorePO>(StorePO.class);
        return util.insert(po);

	}

	@Override
	public boolean replaceStoreItem(StorePO po) throws RemoteException{
		HibernateUtil_Green<StorePO> util= new HibernateUtil_Green<StorePO>(StorePO.class);
		return util.update(po);

	}

	@Override
	public void addAlarmList(AlarmListPO po) throws RemoteException{
		HibernateUtil_Green<AlarmListPO> util= new HibernateUtil_Green<AlarmListPO>(AlarmListPO.class);
		System.out.println("库存报警单增加的结果是："+util.insert(po));;
		
	}

	@Override
	public boolean insertReportList(ReportListPO po) throws RemoteException{
		HibernateUtil_Green<ReportListPO> util=new HibernateUtil_Green<ReportListPO>(ReportListPO.class);
		return util.insert(po);

	}

	@Override
	public boolean replaceReportList(ReportListPO po) throws RemoteException{
		HibernateUtil_Green<ReportListPO> util=new HibernateUtil_Green<ReportListPO>(ReportListPO.class);
		return util.update(po);

	}

	@Override
	public boolean insertPresentList(PresentListPO po) throws RemoteException{
		HibernateUtil_Green<PresentListPO> util= new HibernateUtil_Green<PresentListPO>(PresentListPO.class);
		return util.insert(po);

	}

	@Override
	public boolean replacePresentList(PresentListPO po) throws RemoteException{
		HibernateUtil_Green<PresentListPO> util= new HibernateUtil_Green<PresentListPO>(PresentListPO.class);
		return util.update(po);

	}

	@Override
	public void addStoreLogPO(StoreLogPO po) throws RemoteException{
		HibernateUtil_Green<StoreLogPO> util= new HibernateUtil_Green<StoreLogPO>(StoreLogPO.class);
		util.insert(po);
		
	}
	private String calcTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		String s=df.format(new Date());
		return s;
	}
    
}
