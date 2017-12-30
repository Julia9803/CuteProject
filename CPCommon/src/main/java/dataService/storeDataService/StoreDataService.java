package dataService.storeDataService;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.LinkedList;

import PO.AlarmListPO;
import PO.PresentListPO;
import PO.ReportListPO;
import util.State;
import PO.StoreLogPO;
import PO.StorePO;
import util.StoreListType;
public interface StoreDataService extends Remote,Serializable{
	
	
  public boolean checkID(String id);//检查某个库存项目ID 是否存在
  public StorePO getStorePO(String id);//把单个库存项抓上来，不存在的话返回NULL(检查过ID，所以其实不会不存在)
  public String calcID(StoreListType lt);//根据不同的单据类型，计算单据编号
  public LinkedList<AlarmListPO> getAlarmListPO();
  public ArrayList<PresentListPO> getPresentListPO(State st);
  public ArrayList<ReportListPO> getReportListPO(StoreListType type, State st);
  public PresentListPO getSinglePresentList(String id);
  public ReportListPO getSingleReportList(String id);
  public ArrayList<StoreLogPO> getStoreLogPO(String beginTime,String endTime);
  public ArrayList<StorePO> getAllStorePO();
  
  //----------------------------------------------
  
  public boolean insertStoreItem(StorePO po);
  public boolean replaceStoreItem(StorePO po);//替换一个数据表项，如果表项不存在，则不能成功替换。
  public void addAlarmList(AlarmListPO po);//新增一个库存报警单
  public boolean insertReportList(ReportListPO po);
  public boolean replaceReportList(ReportListPO po);
  public boolean insertPresentList(PresentListPO po);
  public boolean replacePresentList(PresentListPO po);
  public void addStoreLogPO(StoreLogPO po);
  
}
