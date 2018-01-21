package bl.goodsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.GoodsPO;
import VO.goodsVO.GoodsVO;
import dataService.goodsDataService.GoodsDataService;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import resultmessage.ResultMessage;

/**
 * Created by julia98 on 2017/12/14.
 * 处理商品的增删改查逻辑
 */
public class Goods {
    GoodsDataService goodsDataService = GoodsDataServiceHelper.getInstance().getGoodsDataService();

    public String newGoodsID(GoodsVO vo) throws RemoteException{
        return goodsDataService.newGoodsID(voToPO(vo));
    }

    public ArrayList<GoodsVO> findGoods(String info, String type) throws RemoteException {
        ArrayList<GoodsPO> findGoodsList = (ArrayList<GoodsPO>) goodsDataService.findGoods(info,type);
        ArrayList<GoodsVO> retFindGoodsList = new ArrayList<>();
        if( findGoodsList!=null){
        	//为防止空指针报错，加一条断言语句
        for(int i = 0;i<findGoodsList.size();i++){
            retFindGoodsList.add(poToVO(findGoodsList.get(i)));
        }
        }else{
        	System.out.println("没有找到对应商品！");
        }
        return retFindGoodsList;
    }

    public GoodsVO getGoods(String name,String category) throws RemoteException {
       	//return goodsVO;//tmp try
        return poToVO(goodsDataService.getGoods(name,category));
    }

    public ResultMessage deleteGoods(String category, String name) throws RemoteException {
        goodsDataService.deleteGoods(category,name);
        return ResultMessage.SUCCESS;

    }

    public ResultMessage modifyGoods(GoodsVO vo) throws RemoteException{
        goodsDataService.modifyGoods(voToPO(vo));
        return ResultMessage.SUCCESS;

    }

    //用于未经初始化的商品信息
    GoodsVO goodsVO = new GoodsVO("0"
            ,"商品分类"
            ,"商品名称"
            ,"商品种类"
            ,0
            ,0
            ,0
            ,0);

    public GoodsPO voToPO(GoodsVO goodsVO){
        GoodsPO po = new GoodsPO(goodsVO.getGoodsID()
                ,goodsVO.getGoodsCategory()
                ,goodsVO.getGoodsName()
                ,goodsVO.getGoodsType()
                ,goodsVO.getGoodsBuyPrice()
                ,goodsVO.getGoodsSellPrice()
                ,goodsVO.recentBuyPrice()
                ,goodsVO.recentSellPrice()
                ,null
        );
        po.setAutoId(goodsVO.getAutoId());
        po.setState(goodsVO.getState());
        return po;
    }

    public GoodsVO poToVO(GoodsPO goodsPO){
        GoodsVO vo = new GoodsVO(goodsPO.getGoodsID()
                ,goodsPO.getGoodsCategory()
                ,goodsPO.getGoodsName()
                ,goodsPO.getGoodsType()
                ,goodsPO.getGoodsBuyPrice()
                ,goodsPO.getGoodsSellPrice()
                ,goodsPO.getRecentBuyPrice()
                ,goodsPO.getRecentSellPrice());
        vo.setAutoId(goodsPO.getAutoId());
        vo.setState(goodsPO.getState());
        return vo;
    }
}
