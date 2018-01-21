package blservice.storeblservice;

import java.util.ArrayList;
import java.util.LinkedList;

import VO.listVO.ListRM;
import VO.storeVO.AlarmListVO;
import VO.storeVO.PresentListVO;
import VO.storeVO.ReportListVO;
import VO.storeVO.StoreVO;
import VO.storeVO.storeCheckVO;
import VO.storeVO.storeInventoryVO;
import util.State;
import util.StoreListType;


/**     
* @author 李安迪/王瑞华
* @date 2017年11月15日
* @description
*/
public interface StoreBLService {

	public LinkedList<AlarmListVO> openAlarmList();//打开全部库存报警单
	public ArrayList<ReportListVO> openReportList(StoreListType type, State st);//返回指定状态的库存报损或报溢单

	public ArrayList<PresentListVO> openPresentList(State st);//返回指定状态的库存赠送单
	public String toExcel(	storeInventoryVO vo,String path);  //将库存盘点的内容导出到Excel表内
	public String newList(StoreListType type); //新建单据，并自动计算单据编号
	public ListRM saveReportList ( ReportListVO vo);  //保存库存报损或报溢单
	public ListRM savePresentList ( PresentListVO vo); //保存库存赠送单
	public ListRM commit (StoreListType type , String ID); //提交单据
	 public storeCheckVO store_check(String begintime,String endTime); //库存查看
	 public storeInventoryVO store_inventory(); //库存盘点
	 
	public StoreVO getStoreVO(String id);//根据商品ID 得到其库存项
	
}
