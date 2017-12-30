package bl.storebl;

import VO.listVO.InfoListVO;
import VO.storeVO.PresentListVO;
import resultmessage.ResultMessage;
import util.GreatListType;

public class PresentList extends StoreList {
	PresentListVO vo;
	
	PresentList(PresentListVO vo){
		this.vo=vo;
	}
	public ResultMessage commit(){
		String info="";
		info="赠送给  "+vo.VIPname+"  ";
		for(int i=0;i<vo.num.size();i++){
			info=info+vo.name.get(i)+Integer.toString(vo.num.get(i))+"个"+"  ";
		}
		infoList.register(new InfoListVO(vo.listID,GreatListType.PRESENT,vo.operator,info));
		return ResultMessage.SUCCESS;
	}
	
}
