package bl.listbl;

import PO.InfoListPO;
import VO.listVO.InfoListVO;
import VO.listVO.ListRM;
import dataService.listDataService.ListDataService;

public class InfoList_Impl implements InfoList {
	ListDataService listDataService;//需要初始化一下

	@Override
	public ListRM register(InfoListVO vo) {
		// 注册信息表
		InfoListPO po=new InfoListPO(vo.id, vo.type, vo.operator, vo.note);
		listDataService.addInfoList(po);
		
		return ListRM.SUCCESS;
	}

	@Override
	public ListRM modify(boolean b, String id) {
		// 修改信息表
		if(b==true){
			listDataService.changeToApproved(id);
		}else{
			
			listDataService.removeInfoList(id);
		}
		return ListRM.SUCCESS;
	}

}
