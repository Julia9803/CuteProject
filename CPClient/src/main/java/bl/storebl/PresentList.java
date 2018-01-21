package bl.storebl;

import VO.listVO.InfoListVO;
import VO.listVO.ListRM;
import VO.storeVO.PresentListVO;
import blservice.storeblservice.ApprovePresentList;
import resultmessage.ResultMessage;
import util.GreatListType;
import util.State;

public class PresentList extends StoreList implements ApprovePresentList{
    Store_InterfaceImpl impl=new Store_InterfaceImpl();
	PresentListVO vo;
	
	PresentList(PresentListVO vo){
		this.vo=vo;
	}
	public PresentList(){
		
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
	
	@Override
	public ListRM approvePresentList(PresentListVO vo, boolean b) {
		this.vo=vo;
		if(b==false){
			infoList.modify(false, vo.listID);
			vo.statetype=State.IsRefused;
			impl.ds.replacePresentListVO(vo);
			return ListRM.SUCCESS;
		}else{
          return successfulApproved();
		}
		
	}
	
	@Override
	public ListRM Approve(String id){
		this.vo=impl.dg.getPresentListVO(id);
        return successfulApproved();
	}
	
	private ListRM successfulApproved(){
		//如果库存不足，不对数据库进行任何操作，只告诉界面层库存是不足的。
		if(impl.check(vo.id, vo.num)==false){
			return ListRM.STORE_NOT_ENOUGH;
		}else{
		vo.statetype=State.IsApproved; 
		impl.ds.replacePresentListVO(vo);//修改VO状态并向数据库刷新VO
		
		infoList.modify(true, vo.listID);//修改表单信息表
		
		for(int i=0;i<vo.id.size();i++){
			impl.minusNumber(vo.id.get(i), vo.num.get(i), GreatListType.PRESENT);
			//逐个调用减小商品数量的方法。
		}
		return ListRM.SUCCESS;
		}
	}
}
