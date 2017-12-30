package bl.VIPbl;

import VO.VIPVO.VIPVO;
import blservice.VIPblservice.VIPBLService;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by julia98 on 2017/12/26.
 */
public class VIPFuzzySearchImpl implements VIPFuzzySearch{

    VIPBLService vipblService = new VIPBLServiceImpl();
    /**
     * 以会员ID模糊查找
     *
     * @param idInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInID(String idInfo) throws RemoteException {
        return vipblService.findVIP(idInfo,"id");
    }

    /**
     * 以会员姓名模糊查找
     *
     * @param nameInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInName(String nameInfo) throws RemoteException {
        return vipblService.findVIP(nameInfo,"name");
    }

    /**
     * 以会员电话模糊查找
     *
     * @param phoneNumberInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInPhoneNumber(String phoneNumberInfo) throws RemoteException {
        return vipblService.findVIP(phoneNumberInfo,"phoneNumber");
    }

    /**
     * 以会员分类模糊查找
     *
     * @param categoryInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInType(String categoryInfo) throws RemoteException {
        return vipblService.findVIP(categoryInfo,"category");
    }

    /**
     * 在进货商中以会员ID模糊查找
     *
     * @param idInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInIDOnlySeller(String idInfo) throws RemoteException {
        List<VIPVO> list1 = getVIPInType("进货商");
        List<VIPVO> list2 = getVIPInID(idInfo);
        return magicMethod(list1,list2);
    }

    /**
     * 在进货商中以会员姓名模糊查找
     *
     * @param nameInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInNameOnlySeller(String nameInfo) throws RemoteException {
        List<VIPVO> list1 = getVIPInType("进货商");
        List<VIPVO> list2 = getVIPInName(nameInfo);
        return magicMethod(list1,list2);
    }

    /**
     * 在进货商中以会员电话模糊查找
     *
     * @param phoneNumberInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInPhoneNumberOnlySeller(String phoneNumberInfo) throws RemoteException {
        List<VIPVO> list1 = getVIPInType("进货商");
        List<VIPVO> list2 = getVIPInPhoneNumber(phoneNumberInfo);
        return magicMethod(list1,list2);
    }

    /**
     * 在销售商中以会员ID模糊查找
     *
     * @param idInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInIDOnlyRetailer(String idInfo) throws RemoteException {
        List<VIPVO> list1 = getVIPInType("销售商");
        List<VIPVO> list2 = getVIPInID(idInfo);
        return magicMethod(list1,list2);
    }

    /**
     * 在销售商中以会员姓名模糊查找
     *
     * @param nameInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInNameOnlyRetailer(String nameInfo) throws RemoteException {
        List<VIPVO> list1 = getVIPInType("销售商");
        List<VIPVO> list2 = getVIPInName(nameInfo);
        return magicMethod(list1,list2);
    }

    /**
     * 在销售商中以会员电话模糊查找
     *
     * @param phoneNumberInfo
     * @return 符合条件的会员列表
     */
    @Override
    public List<VIPVO> getVIPInPhoneNumberOnlyRetailer(String phoneNumberInfo) throws RemoteException {
        List<VIPVO> list1 = getVIPInType("销售商");
        List<VIPVO> list2 = getVIPInPhoneNumber(phoneNumberInfo);
        return magicMethod(list1,list2);
    }

    private List<VIPVO> magicMethod(List<VIPVO> list1,List<VIPVO> list2){
        List<VIPVO> list = null;
        for(int i =0;i<list1.size();i++){
            for(int j = 0;j<list2.size();j++) {
                if (list1.get(i) == list2.get(j)) {
                    list.add(list1.get(i));
                }
            }
        }
        return list;
    }
}
