package blservice.storeblservice;

import java.util.ArrayList;
import java.util.LinkedList;
import util.State;
import VO.listVO.ListRM;
import VO.storeVO.*;
import util.StoreListType;


/**     
* @author 李安迪/王瑞华
* @date 2017年11月15日
* @description
*/
public interface StoreBLService {
	/*public String createList(ListType type);
	public Map<ListType, String> openDraftList();
	public StoreListVO openList(ListType type, String id);
	public void saveList(ListType type, ListVO vo);
	public void commitList(ListType type, ListVO vo);
	public Map<String,String> findGoods(String id, String name);
	public GoodsVO getGoods(String id);
	public int getStoreNumber(String id);
	public int getOverflowNumber(int numberInReality);
	public int getLossNumber(int numberInReality);
	public Set<StoreVO> check();
	public StoreViewVO view(StoreViewStandardVO vo, Date begin, Date end);
	public void setAlert(Map<String, Integer> alertMap);
	*/
	//下面按照详细设计文档中规定的store提供的接口进行了描述，有几个存疑的地方。
	public LinkedList<AlarmListVO> openAlarmList();
	public ArrayList<ReportListVO> openReportList(StoreListType type, State st);

	public ArrayList<PresentListVO> openPresentList(State st);
	public String toExcel(	InventoryVO vo);
	public String newList(StoreListType type);
	public ListRM saveReportList ( ReportListVO vo);
	public ListRM savePresentList ( PresentListVO vo);
	public ListRM commit (StoreListType type , String ID);
	 public storeCheckVO store_check(String begintime,String endTime);
	 public storeInventoryVO store_inventory();
	
}
