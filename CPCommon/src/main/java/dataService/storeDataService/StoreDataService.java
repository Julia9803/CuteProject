package dataService.storeDataService;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;

import PO.AlarmListPO;
import PO.PresentListPO;
import PO.ReportListPO;
import PO.StoreLogPO;
import PO.StorePO;
import util.State;
import util.StoreListType;
public interface StoreDataService extends Remote,Serializable{
	
	
  public boolean checkID(String id)throws RemoteException;//检查某个库存项目ID 是否存在
  public StorePO getStorePO(String id)throws RemoteException;//把单个库存项抓上来，不存在的话返回NULL(检查过ID，所以其实不会不存在)
  public String calcID(StoreListType lt)throws RemoteException;//根据不同的单据类型，计算单据编号
  public LinkedList<AlarmListPO> getAlarmListPO()throws RemoteException;
  public ArrayList<PresentListPO> getPresentListPO(State st)throws RemoteException;
  public ArrayList<ReportListPO> getReportListPO(StoreListType type, State st)throws RemoteException;
  public PresentListPO getSinglePresentList(String id)throws RemoteException;
  public ReportListPO getSingleReportList(String id)throws RemoteException;
  public ArrayList<StoreLogPO> getStoreLogPO(String beginTime,String endTime)throws RemoteException;
  public ArrayList<StorePO> getAllStorePO()throws RemoteException;
  
  //----------------------------------------------
  
  public boolean insertStoreItem(StorePO po)throws RemoteException;
  public boolean replaceStoreItem(StorePO po)throws RemoteException;//替换一个数据表项，如果表项不存在，则不能成功替换。
  public void addAlarmList(AlarmListPO po)throws RemoteException;//新增一个库存报警单
  public boolean insertReportList(ReportListPO po)throws RemoteException;
  public boolean replaceReportList(ReportListPO po)throws RemoteException;
  public boolean insertPresentList(PresentListPO po)throws RemoteException;
  public boolean replacePresentList(PresentListPO po)throws RemoteException;
  public void addStoreLogPO(StoreLogPO po)throws RemoteException;
  
}
