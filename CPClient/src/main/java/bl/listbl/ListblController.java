package bl.listbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InfoListPO;
import VO.listVO.BussinessSituationListVO;
import VO.listVO.InfoListVO;
import VO.listVO.ListRM;
import VO.listVO.SalesDetailListVO;
import bl.salebl.GetSalesDetailsImpl;
import bl.salebl.SaleListBLServiceImpl;
import bl.salebl.SaleReturnListBLServiceImpl;
import bl.salebl.SalesBussinessSituation_Impl;
import bl.salebl.StockListBLServiceImpl;
import bl.salebl.StockReturnListBLServiceImpl;
import bl.storebl.PresentList;
import bl.storebl.ReportList;
import bl.storebl.StoreBussinessSituation_Impl;
import blservice.listblservice.Listblservice;
import blservice.serviceFactory.FinanceListApproveFactory;
import dataService.listDataService.ListDataService;
//import dataService.listDataService.ListDataService_Stub;
import network.listRemoteHelper.ListDataServiceHelper;
import resultmessage.ApproveRM;
import util.ExcelUtil;
import util.GreatListType;

public class ListblController implements Listblservice {
    /*
    * 表单类对上层的控制器，负责实现表单查看和导出功能
    * 表单类的部分逻辑是为其他包提供的，控制器不需要知道和调用这些逻辑。典型代表是过审批逻辑。
    * 表单审批和表单导出被委托出去了，所以其实现由其他包完成。这种做法是符合信息隐藏原则和职责分配原则的
    * 两张大的报表需要向其他包索要数据，建议其他包（销售、商品）写一个对应接口，直接把VO传输过来
    * 王瑞华 161250143  2017年12月1日
     */
	


	ListDataServiceHelper helper=ListDataServiceHelper.getInstance();
    ListDataService listDataService=helper.getListDataService();
    Approvable approvable;
    @Override
    public ArrayList<InfoListVO> openInfoList() {
    	ArrayList<InfoListVO> arr1 =new ArrayList<InfoListVO>();
    	
    	ArrayList<InfoListPO> arr0;
		try {
			arr0 = listDataService.openInfoList();
	    	for(int i=0;i<arr0.size();i++){
	    		//倒序操作一下，使得最近加进来的VO靠前显示
	    		//这步倒序操作可能起了反作用，因为VBOX自带倒序...
	    		InfoListVO v=new InfoListVO(arr0.get(i).id,arr0.get(i).type,arr0.get(i).operator,arr0.get(i).note);
	    		arr1.add(v);
	    	}
		} catch (RemoteException e) {
			
			e.printStackTrace();
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
    public ListRM bussinessSituationToExcel ( String path) {
    	if(path==null||!path.endsWith(".xls")){
    		return ListRM.WRONG_LISTTYPE;    //防御式编程一下
    	}
        
    	ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
    	ArrayList<String> a1=new ArrayList<String>();
    	ArrayList<String> a2=new ArrayList<String>();
    	a1.add("商品报溢收入");
    	a1.add("折让后销售收入");
    	a1.add("进货退货收入");
    	a1.add("折让总额");
    	a1.add("总收入");
    	a1.add("商品报损支出");
    	a1.add("进货支出");
    	a1.add("销售退货支出");
    	a1.add("赠出商品总额");
    	a1.add("总支出");
    	a1.add("净利润");
    	for(int i=1;i<=11;i++){
    		a2.add("0");
    	}
    	result.add(a1);
    	result.add(a2);
    	ExcelUtil.writeExcel(result, path);
        return ListRM.WRONG_LISTTYPE;
    }

	@Override
	public ArrayList<InfoListVO> openApproved() {
    	ArrayList<InfoListVO> arr1 =new ArrayList<InfoListVO>();
    	
		ArrayList<InfoListPO> arr0;
		try {
			arr0 = listDataService.openApproved();
	    	for(int i=arr0.size()-1;i>=0;i--){
	    		//倒序操作一下，使得最近加进来的VO靠前显示
	    		InfoListVO v=new InfoListVO(arr0.get(i).id,arr0.get(i).type,arr0.get(i).operator,arr0.get(i).note);
	    		arr1.add(v);
	    	}
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}


        return arr1;
	}

	@Override
	public ApproveRM approve(String id, GreatListType type) {
		if(type.equals(GreatListType.PRESENT)){
			approvable=new PresentList();
			ListRM rm=approvable.Approve(id);
			if(rm.equals(ListRM.SUCCESS)){
				return ApproveRM.OK;
			}
			else{return ApproveRM.INSUFFICIENT_STOCK_GOODS;}
		}else if(type.equals(GreatListType.OVERFLOW)||type.equals(GreatListType.LOSS)){
			approvable=new ReportList();
			ListRM rm=approvable.Approve(id);
			if(rm.equals(ListRM.SUCCESS)){
				return ApproveRM.OK;
			}
			else{return ApproveRM.INSUFFICIENT_STOCK_GOODS;}
		}else if(type.equals(GreatListType.SALE)){
			approvable=new SaleListBLServiceImpl();
			ListRM rm=approvable.Approve(id);
			if(rm.equals(ListRM.SUCCESS)){
				return ApproveRM.OK;
			}
			else{return ApproveRM.INSUFFICIENT_STOCK_GOODS;}			
		}else if(type.equals(GreatListType.SALE_RETURN)){
			approvable=new SaleReturnListBLServiceImpl();
			ListRM rm=approvable.Approve(id);
			if(rm.equals(ListRM.SUCCESS)){
				return ApproveRM.OK;
			}
			else{return ApproveRM.INSUFFICIENT_STOCK_GOODS;}
		}else if(type.equals(GreatListType.STOCK)){
			approvable=new StockListBLServiceImpl();
			ListRM rm=approvable.Approve(id);
			if(rm.equals(ListRM.SUCCESS)){
				return ApproveRM.OK;
			}
			else{return ApproveRM.INSUFFICIENT_STOCK_GOODS;}	
		}else if(type.equals(GreatListType.STOCK_RETURN)){
			approvable=new StockReturnListBLServiceImpl();
			ListRM rm=approvable.Approve(id);
			if(rm.equals(ListRM.SUCCESS)){
				return ApproveRM.OK;
			}
			else{return ApproveRM.INSUFFICIENT_STOCK_GOODS;}	
		}
		else if(type.equals(GreatListType.COLLECTMONEY)){
			approvable=FinanceListApproveFactory.getCollectionApprovableService();
			ListRM rm=approvable.Approve(id);
			if(rm.equals(ListRM.SUCCESS)){
				return ApproveRM.OK;
			}
			else{return ApproveRM.WRONG;}
		}
		else if(type.equals(GreatListType.PAYMENT)){
			approvable=FinanceListApproveFactory.getPaymentApprovableService();
			ListRM rm=approvable.Approve(id);
			if(rm.equals(ListRM.SUCCESS)){
				return ApproveRM.OK;
			}
			else{return ApproveRM.WRONG;}
		}
		else if(type.equals(GreatListType.CASHEXPENSE)){
			approvable=FinanceListApproveFactory.getCashExpenseApprovableService();
			ListRM rm=approvable.Approve(id);
			System.out.println(rm);
			if(rm.equals(ListRM.SUCCESS)){
				return ApproveRM.OK;
			}
			else{return ApproveRM.WRONG;}
		}
		return null;
	}
}
