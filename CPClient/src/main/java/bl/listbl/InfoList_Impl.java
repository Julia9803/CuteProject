package bl.listbl;

import java.rmi.RemoteException;

import PO.InfoListPO;
import VO.listVO.InfoListVO;
import VO.listVO.ListRM;
import dataService.listDataService.ListDataService;
import network.listRemoteHelper.ListDataServiceHelper;
import util.State;

public class InfoList_Impl implements InfoList {
	ListDataServiceHelper helper=ListDataServiceHelper.getInstance();
    ListDataService listDataService=helper.getListDataService();

	@Override
	public ListRM register(InfoListVO vo) {
		// 注册信息表
		InfoListPO po=new InfoListPO(vo.id, vo.type, vo.operator, vo.note);
		po.state=State.IsCommitted;
		try {
			listDataService.addInfoList(po);
		} catch (RemoteException e) {
		
			e.printStackTrace();
		}
		
		return ListRM.SUCCESS;
	}

	@Override
	public ListRM modify(boolean b, String id) {
		// 修改信息表
		if(b==true){
			try {
				listDataService.changeToApproved(id);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}else{
			
			try {
				listDataService.removeInfoList(id);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return ListRM.SUCCESS;
	}

}
