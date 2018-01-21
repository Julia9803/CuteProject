package blservice.goodsblservice;

import java.rmi.RemoteException;

import resultmessage.ResultMessage;

/**
 * Created by julia98 on 2018/1/1.
 * 提供给其他包使用的设置商品最近进价和售价的接口
 */
public interface GoodsRecent {
    public ResultMessage setGoodsRecentBuyPrice(double recentBuyPriceice,String goodsName, String goodsCategory) throws RemoteException;
    public ResultMessage setGoodsRecentSellPrice(double recentSellPrice,String goodsName, String goodsCategory) throws RemoteException;
}
