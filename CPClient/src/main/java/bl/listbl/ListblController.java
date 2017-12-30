package bl.listbl;

import VO.listVO.BussinessSituationListVO;
import VO.listVO.InfoListVO;
import VO.listVO.SalesDetailListVO;
import bl.salebl.GetSalesDetailsImpl;
import bl.salebl.SalesBussinessSituation_Impl;
import bl.storebl.StoreBussinessSituation_Impl;
import VO.listVO.ListRM;
import blservice.listblservice.Listblservice;
import dataService.listDataService.ListDataService;
import dataService.listDataService.ListDataService_Stub;
import util.GreatListType;
import java.util.ArrayList;
import PO.InfoListPO;

public class ListblController implements Listblservice {
    /*
    * 表单类对上层的控制器，负责实现表单查看和导出功能
    * 表单类的部分逻辑是为其他包提供的，控制器不需要知道和调用这些逻辑。典型代表是过审批逻辑。
    * 表单审批和表单导出被委托出去了，所以其实现由其他包完成。这种做法是符合信息隐藏原则和职责分配原则的
    * 两张大的报表需要向其他包索要数据，建议其他包（销售、商品）写一个对应接口，直接把VO传输过来
    * 王瑞华 161250143  2017年12月1日
     */
	

    //单据红冲的接口还没加，但理论上应该是我来写
    ListDataService listDataService=new ListDataService_Stub();
    @Override
    public ArrayList<InfoListVO> openInfoList() {
    	
    	ArrayList<InfoListPO> arr0 =listDataService.openInfoList();
    	ArrayList<InfoListVO> arr1 =new ArrayList<InfoListVO>();
    	for(int i=arr0.size()-1;i>=0;i--){
    		//倒序操作一下，使得最近加进来的VO靠前显示
    		InfoListVO v=new InfoListVO(arr0.get(i).id,arr0.get(i).type,arr0.get(i).operator,arr0.get(i).note);
    		arr1.add(v);
    	}
        return arr1;
    }

    @Override
    public ArrayList<SalesDetailListVO> openSaleDetailList() {
    	//销售明细查看
    	GetSalesDetails gsd=new GetSalesDetailsImpl();
    	
        return gsd.getSalesDetail();
    }

    @Override
    public BussinessSituationListVO openBussinessSituationList() {
    	//经营情况查看
    	SalesBussinessSituation sbs1=new SalesBussinessSituation_Impl();
    	StoreBussinessSituation sbs2=new StoreBussinessSituation_Impl();
    	BussinessSituationListVO vo=new BussinessSituationListVO ();
    	vo.lossOutcome=sbs2.getlossOutcome();
    	vo.overflowIncome=sbs2.getOverflowIncome();
    	vo.salesDiscount=sbs1.getSalesDiscount();
    	vo.salesIncome=sbs1.getSalesIncome();
    	vo.salesReturnOutcome=sbs1.getSalesReturnOutcome();
    	vo.stockOutcome=sbs1.getstockOutcome();
    	vo.stockReturnIncome=sbs1.getStockReturnIncome();
    	vo.calcIncome();
    	vo.calcOutCome();
        return vo;
    }

    @Override
    public ListRM toExcel (GreatListType type, String id) {

        return ListRM.WRONG_LISTTYPE;
    }

	@Override
	public ArrayList<InfoListVO> openApproved() {
		ArrayList<InfoListPO> arr0 =listDataService.openApproved();
    	ArrayList<InfoListVO> arr1 =new ArrayList<InfoListVO>();
    	for(int i=arr0.size()-1;i>=0;i--){
    		//倒序操作一下，使得最近加进来的VO靠前显示
    		InfoListVO v=new InfoListVO(arr0.get(i).id,arr0.get(i).type,arr0.get(i).operator,arr0.get(i).note);
    		arr1.add(v);
    	}
        return arr1;
	}
}
