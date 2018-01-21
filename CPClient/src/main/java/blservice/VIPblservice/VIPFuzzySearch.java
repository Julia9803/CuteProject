package blservice.VIPblservice;

import java.rmi.RemoteException;
import java.util.List;

import VO.VIPVO.VIPVO;

/**
 * Created by julia98 on 2017/12/14.
 * 模糊查询会员的包间接口 供其他包调用
 */
public interface VIPFuzzySearch {

    /**
     * 以会员ID模糊查找
     * @param idInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInID(String idInfo) throws RemoteException;

    /**
     * 以会员姓名模糊查找
     * @param nameInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInName(String nameInfo) throws RemoteException;

    /**
     * 以会员电话模糊查找
     * @param phoneNumberInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInPhoneNumber(String phoneNumberInfo) throws RemoteException;

    /**
     * 以会员分类模糊查找
     * @param categoryInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInType(String categoryInfo) throws RemoteException;

    /**
     * 在进货商中以会员ID模糊查找
     * @param idInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInIDOnlySeller(String idInfo) throws RemoteException;

    /**
     * 在进货商中以会员姓名模糊查找
     * @param nameInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInNameOnlySeller(String nameInfo) throws RemoteException;

    /**
     * 在销售商中以会员电话模糊查找
     * @param phoneNumberInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInPhoneNumberOnlySeller(String phoneNumberInfo) throws RemoteException;

    /**
     * 在销售商中以会员ID模糊查找
     * @param idInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInIDOnlyRetailer(String idInfo) throws RemoteException;

    /**
     * 在销售商中以会员姓名模糊查找
     * @param nameInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInNameOnlyRetailer(String nameInfo) throws RemoteException;

    /**
     * 在销售商中以会员电话模糊查找
     * @param phoneNumberInfo
     * @return 符合条件的会员列表
     */
    public List<VIPVO> getVIPInPhoneNumberOnlyRetailer(String phoneNumberInfo) throws RemoteException;


}
