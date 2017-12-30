package bl.storebl;

import VO.listVO.InfoListVO;

import VO.storeVO.ReportListVO;
import resultmessage.ResultMessage;
import util.StoreListType;
import util.GreatListType;

public class ReportList extends StoreList  {
    /*
    * 王瑞华 161250143 2017年12月2日
     */
    ReportListVO vo;
    
    public ReportList(ReportListVO vo){
        this.vo=vo;
    }
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

}
