package blservice.VIPblservice;

import java.rmi.RemoteException;

import resultmessage.ResultMessage;

/**
 * Created by julia98 on 2018/1/1.
 * 给其他包使用的 修改会员应收应付的接口
 */
public interface VIPCollectionModify {
    public ResultMessage setVIPCollection(String vipName,double collection) throws RemoteException;
    public ResultMessage setVIPPayment(String vipName,double payment) throws RemoteException;
    public double getVIPCollection(String vipName) throws RemoteException;
    public double getVIPPayment(String vipName) throws RemoteException;
    public double checkVIPCollectionLimit(String vipName) throws RemoteException;
}
