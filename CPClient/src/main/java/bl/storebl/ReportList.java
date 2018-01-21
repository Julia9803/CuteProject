package bl.storebl;

import VO.listVO.InfoListVO;
import VO.listVO.ListRM;
import VO.storeVO.ReportListVO;
import VO.storeVO.storeRM;
import blservice.storeblservice.ApproveReportList;
import resultmessage.ResultMessage;
import util.GreatListType;
import util.State;
import util.StoreListType;

public class ReportList extends StoreList implements ApproveReportList {
    /*
    * 王瑞华 161250143 2017年12月2日
     */
    ReportListVO vo;
    Store_InterfaceImpl impl=new Store_InterfaceImpl();
    
    public ReportList(ReportListVO vo){
        this.vo=vo;
    }
    public ReportList(){}
    public ResultMessage commit(){
        //单据如果编辑完直接提交，需要从界面层自动先做一个保存草稿的操作。这个操作很关键。
        //提交的操作步骤是先把这个VO查到，然后调用注册接口
    	String info="";
    	GreatListType glt;
    	if(vo.st.equals(StoreListType.LOSS)){
         glt=GreatListType.LOSS;
         info=vo.GoodsName+"   "+"报损"+Integer.toString(vo.delta)+"个";
    	}else {
    		glt=GreatListType.OVERFLOW;
    		info=vo.GoodsName+"   "+"报溢"+Integer.toString(vo.delta)+"个";
    	}
    	
    	
        infoList.register(new InfoListVO(vo.listID, glt,vo.operator,info));
        //写一下商品名称和商品数量就行
        return ResultMessage.SUCCESS;
    }
	@Override
	public ListRM approveReportList(ReportListVO vo, boolean b) {
		this.vo=vo;
		if(b==false){
			infoList.modify(false, vo.listID);
			vo.statetype=State.IsRefused;
			impl.ds.replaceReportListVO(vo);
			return ListRM.SUCCESS;
		}else{
			return successfulApproved();
		}
		
		
	}
	
	@Override
	public ListRM Approve(String id){
		this.vo=impl.dg.getReportListVO(id);
		
		return successfulApproved();
		
	}
	
	private ListRM successfulApproved(){
		vo.statetype=State.IsApproved;
		if(vo.st.equals(StoreListType.OVERFLOW)){
			double price=impl.dg.getStoreVO(vo.goodsID).averagePrice;
			impl.plusNumber(vo.goodsID, vo.delta, GreatListType.OVERFLOW, price);
			impl.ds.replaceReportListVO(vo);
			infoList.modify(true, vo.listID);
		}else{
			storeRM r=impl.minusNumber(vo.goodsID, vo.delta, GreatListType.LOSS);
			//这是防御式编程的最后一道防线，防止有人报损的时候故意把实际数量填成负数。
			if(r.equals(storeRM.STORE_NOT_ENOUGH)){
				return ListRM.STORE_NOT_ENOUGH;
			}else{
				impl.ds.replaceReportListVO(vo);
				infoList.modify(true, vo.listID);
			}
		}
		return ListRM.SUCCESS;
		
	}

}
