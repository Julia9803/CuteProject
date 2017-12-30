package bl.VIPbl;

import PO.VIPPO;
import VO.VIPVO.VIPVO;
import blservice.VIPblservice.VIPBLService;
import dataService.VIPDataService.VIPDataService;
import dataService.goodsDataService.GoodsDataService;
import network.VIPRemoteHelper.VIPDataServiceHelper;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import resultmessage.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia98 on 2017/12/13.
 */
public class VIPBLServiceImpl implements VIPBLService {
    VIPDataServiceHelper vipDataServiceHelper;
    VIPDataService vipDataService = VIPDataServiceHelper.getInstance().getVIPDataService();

    VIPVO vipvo1 = new VIPVO("00000001"
            ,"分类1"
            ,"级别1"
            ,"姓名1"
            ,"18800000000"
            ,"123456789@qq.com"
            ,"地址1"
            ,"210046"
            ,100
            ,1000
            ,100
            ,"业务员1");

    VIPVO vipvo2 = new VIPVO("00000002"
            ,"分类2"
            ,"级别2"
            ,"姓名2"
            ,"18800000001"
            ,"223456789@qq.com"
            ,"地址2"
            ,"210046"
            ,200
            ,2000
            ,200
            ,"业务员1");
    /**
     * 前置条件	用户选择新建客户
     * 后置条件	系统显示客户电话和编号
     *
     * @return VIPBLServiceImpl ID
     * @throws RemoteException 
     */
    @Override
    public String newVIPID(VIPVO vo) throws RemoteException {
        return vipDataService.newVIPID(voToPO(vo));
    }

    @Override
    public VIPVO getVIP(String name) throws RemoteException {
        //return vipvo1;//这个是假的
        return poToVO(vipDataService.getVIP(name));//这个是真的
    }

    /**
     * 前置条件	用户输入信息模糊查找客户
     * 后置条件	系统显示模糊查找后符合要求的客户列表
     *
     * @param info
     * @param type
     * @return
     */
    @Override
    public ArrayList<VIPVO> findVIP(String info, String type) throws RemoteException {
        //ArrayList<VIPVO> vipvos = new ArrayList<>();
        //vipvos.add(vipvo1);
        //vipvos.add(vipvo2);
        //return vipvos;//这个是假的
        //以下是真的
        
        ArrayList<VIPPO> list = (ArrayList<VIPPO>) vipDataService.findVIP(info,type);
        ArrayList<VIPVO> ret = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            ret.add(poToVO(list.get(i)));
        }
        return ret;
    }

    /**
     * 前置条件	用户选择删除客户
     * 后置条件	系统更新客户列表
     *
     * @param name
     * @return
     */
    @Override
    public ResultMessage deleteVIP(String name) throws RemoteException {
        vipDataService.deleteVIP(name);
        return ResultMessage.SUCCESS;
    }

    /**
     * 前置条件	用户选择修改客户信息
     * 后置条件	系统更新客户信息
     *
     * @param vo
     * @return
     * @throws RemoteException 
     */
    @Override
    public ResultMessage modifyVIP(VIPVO vo) throws RemoteException {
        vipDataService.modifyVIP(voToPO(vo));
        return ResultMessage.SUCCESS;
    }

    private VIPVO poToVO(VIPPO vipPO){
        VIPVO vo = new VIPVO(vipPO.getId()
                ,vipPO.getCategory()
                ,vipPO.getGrade()
                ,vipPO.getName()
                ,vipPO.getPhoneNumber()
                ,vipPO.getEmail()
                ,vipPO.getAddress()
                ,vipPO.getPostCode()
                ,vipPO.getCollection()
                ,vipPO.getCollectionLimit()
                ,vipPO.getPayment()
                ,vipPO.getClerk());
        vo.setAutoId(vipPO.getAutoId());
        vo.setState(vipPO.getState());
        return vo;
    }

    private VIPPO voToPO(VIPVO vipVO){
       VIPPO po = new VIPPO(vipVO.getId()
                ,vipVO.getCategory()
                ,vipVO.getGrade()
                ,vipVO.getName()
                ,vipVO.getPhoneNumber()
                ,vipVO.getEmail()
                ,vipVO.getAddress()
                ,vipVO.getPostCode()
                ,vipVO.getCollection()
                ,vipVO.getCollectionLimit()
                ,vipVO.getPayment()
                ,vipVO.getClerk()
                ,null);
       po.setAutoId(vipVO.getAutoId());
       po.setState(vipVO.getState());
       return po;
    }
}
