package bl.goodsbl;

import java.rmi.RemoteException;

import VO.goodsVO.GoodsVO;
import blservice.goodsblservice.GoodsBLService;
import blservice.goodsblservice.GoodsRecent;
import resultmessage.ResultMessage;

/**
 * Created by julia98 on 2018/1/1.
 */
public class GoodsRecentImpl implements GoodsRecent {
    GoodsBLService goodsBLService = new GoodsBLServiceImpl();

    @Override
    public ResultMessage setGoodsRecentBuyPrice(double recentBuyPriceice, String goodsName, String goodsCategory) throws RemoteException {
        GoodsVO goodsVO = goodsBLService.findGoods(goodsName,"goodsName").get(0);
        goodsVO.setRecentBuyPrice(recentBuyPriceice);
        goodsBLService.modifyGoods(goodsVO);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage setGoodsRecentSellPrice(double recentSellPrice, String goodsName, String goodsCategory) throws RemoteException {
        GoodsVO goodsVO = goodsBLService.findGoods(goodsName,"goodsName").get(0);
        goodsVO.setRecentBuyPrice(recentSellPrice);
        goodsBLService.modifyGoods(goodsVO);
        return ResultMessage.SUCCESS;
    }
}
