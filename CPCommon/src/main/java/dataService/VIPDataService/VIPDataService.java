package dataService.VIPDataService;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.VIPPO;
import resultmessage.ResultMessage;

public interface VIPDataService extends Remote,Serializable{
    /**
     * 前置条件	用户选择新建客户
     * 后置条件	系统显示客户电话和编号
     * @return VIPBLServiceImpl ID
     */
    public String newVIPID(VIPPO po) throws RemoteException;

    /**
     * 前置条件	用户输入信息模糊查找客户
     * 后置条件	系统显示模糊查找后符合要求的客户列表
     * 
     * 经测试，info为null时，返回空list；info为""时，返回全部
     * 
     * @param info
     * @param type
     * @return
     */
    public List findVIP(String info, String type) throws RemoteException;

    /**
     * 前置条件	用户选择获取客户信息
     * 后置条件	系统显示客户信息
     * @param name
     * @return
     */
    public VIPPO getVIP(String name) throws RemoteException;

    /**
     * 前置条件	用户选择删除客户
     * 后置条件	系统更新客户列表
     * @param name
     * @return
     */
    public ResultMessage deleteVIP(String name) throws RemoteException;

    /**
     * 前置条件	用户选择修改客户信息
     * 后置条件	系统更新客户信息
     * @param vo
     * @return
     */
    public ResultMessage modifyVIP(VIPPO vo) throws RemoteException;

}
