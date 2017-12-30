package bl.goodsbl;

import VO.goodsVO.GoodsCategoryVO;
import VO.goodsVO.GoodsVO;
import blservice.goodsblservice.GoodsBLService;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import resultmessage.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia98 on 2017/12/11.
 */
public class GoodsBLServiceImpl implements GoodsBLService {
    GoodsDataServiceHelper goodsDataServiceHelper;
    Goods goods = new Goods();
    GoodsCategory goodsCategory = new GoodsCategory();

    GoodsVO goodsVO1 = new GoodsVO("00000001"
            ,"分类1"
            ,"名称1"
            ,"类型1"
            ,100
            ,200
            ,100
            ,200);

    GoodsVO goodsVO2 = new GoodsVO("00000002"
            ,"分类2"
            ,"名称2"
            ,"类型2"
            ,100
            ,200
            ,100
            ,200);


    @Override
    public int newGoodsCategoryAutoId(GoodsCategoryVO vo) throws RemoteException {
        return goodsCategory.newGoodsCategoryAutoId(vo);
    }

    @Override
    public String newGoodsID(GoodsVO goodsVO) throws RemoteException{
        return goods.newGoodsID(goodsVO);
    }

    @Override
    public List<GoodsVO> findGoods(String info, String type) throws RemoteException{
        //ArrayList<GoodsVO> goodsVOS = new ArrayList<>();
        //goodsVOS.add(goodsVO1);
        //goodsVOS.add(goodsVO2);
        //return goodsVOS;
        return goods.findGoods(info, type);
    }

    @Override
    public GoodsVO getGoods(String name, String category) throws RemoteException {
        return goods.getGoods(name, category);
    }
    
    @Override
    public ResultMessage deleteGoods(String category, String name) throws RemoteException {
        return goods.deleteGoods(category, name);
    }

    @Override
    public ResultMessage modifyGoods(GoodsVO vo) throws RemoteException {
        return goods.modifyGoods(vo);
    }

    @Override
    public ResultMessage deleteGoodsCategory(GoodsCategoryVO vo) throws RemoteException {
        return goodsCategory.deleteGoodsCategory(vo);
    }

    @Override
    public ResultMessage modifyGoodsCategory(GoodsCategoryVO newVO) throws RemoteException {
        return goodsCategory.modifyGoodsCategory(newVO);
    }

    @Override
    public GoodsCategoryVO getCategory(String goodsCategoryName, String parentName) throws RemoteException {
        return goodsCategory.getCategory(goodsCategoryName,parentName);
    }

    @Override
    public List getAllCategory(String node) throws RemoteException {
        return goodsCategory.getAllCategory(node);
    }
}
