package bl.goodsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import VO.goodsVO.GoodsVO;
import blservice.goodsblservice.GoodsFuzzySearch;

/**
 * Created by julia98 on 2017/12/15.
 */
public class GoodsFuzzySearchImpl implements GoodsFuzzySearch {
    GoodsBLServiceImpl goodsBLService = new GoodsBLServiceImpl();
    GoodsVO goodsVO1 = new GoodsVO("00000000"
            ,"台灯"
            ,"学习台灯"
            ,"3"
            ,20
            ,100
            ,20
            ,100);

    GoodsVO goodsVO2 = new GoodsVO("00000001"
            ,"台灯"
            ,"护眼台灯"
            ,"3"
            ,21
            ,101
            ,21
            ,101);
    ArrayList<GoodsVO> goodsVOArrayList = new ArrayList<>();
    /**
     * 以商品ID模糊查找
     *
     * @param idInfo
     * @return 符合条件的商品列表
     * @throws RemoteException 
     */
    @Override
    public List<GoodsVO> getGoodsInID(String idInfo) throws RemoteException {
        //goodsVOArrayList.add(goodsVO1);
        //goodsVOArrayList.add(goodsVO2);
        //return goodsVOArrayList;
        return goodsBLService.findGoods(idInfo,"goodsID");
    }

    /**
     * 以商品名称模糊查找
     *
     * @param goodsNameInfo
     * @return 符合条件的商品列表
     * @throws RemoteException 
     */
    @Override
    public List<GoodsVO> getGoodsInGoodsName(String goodsNameInfo) throws RemoteException {
        //goodsVOArrayList.add(goodsVO1);
        //goodsVOArrayList.add(goodsVO2);
        //return goodsVOArrayList;
        return goodsBLService.findGoods(goodsNameInfo,"goodsName");
    }

    /**
     * 以商品分类模糊查找
     *
     * @param goodsCategoryInfo
     * @return 符合条件的商品列表
     * @throws RemoteException 
     */
    @Override
    public List<GoodsVO> getGoodsInCategory(String goodsCategoryInfo) throws RemoteException {
        //goodsVOArrayList.add(goodsVO1);
        //goodsVOArrayList.add(goodsVO2);
        //return goodsVOArrayList;
        return goodsBLService.findGoods(goodsCategoryInfo,"goodsCategory");
    }
}
