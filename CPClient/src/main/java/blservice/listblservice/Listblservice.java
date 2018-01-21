package blservice.listblservice;

import java.util.ArrayList;

import VO.listVO.BussinessSituationListVO;
import VO.listVO.InfoListVO;
import VO.listVO.ListRM;
import VO.listVO.SalesDetailListVO;
import resultmessage.ApproveRM;
import util.GreatListType;

public interface Listblservice {
    /*
    *表单这个类大部分的职责都委托出去了,比如审批的实现，导出的实现。
    * 在计算的时候也需要使用销售、商品的方法。所以表单自己的层间API降低了很多
    * 王瑞华 161250143 2017年12月1日
     */
    public ArrayList<InfoListVO> openInfoList() ;//经营历程表查看
    public ArrayList<InfoListVO> openApproved() ;//查看已经审批通过的经营历程表
    public ArrayList<SalesDetailListVO> openSaleDetailList() ; //销售明细表查看
    public BussinessSituationListVO openBussinessSituationList(); //经营情况表查看
    public ListRM bussinessSituationToExcel (String path) ; // 表单导出
    public ApproveRM approve(String id,GreatListType type); //批量审批
}
