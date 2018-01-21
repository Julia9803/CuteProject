package blservice.goodsblservice;

import java.rmi.RemoteException;
import java.util.List;

import VO.goodsVO.GoodsVO;

/**
 * Created by julia98 on 2017/12/14.
 * 模糊查询商品的包间接口 供其他包调用
 */
public interface GoodsFuzzySearch {

    /**
     * 以商品ID模糊查找
     * @param idInfo
     * @return 符合条件的商品列表
     * @throws RemoteException 
     */
    public List<GoodsVO> getGoodsInID(String idInfo) throws RemoteException;

    /**
     * 以商品名称模糊查找
     * @param goodsNameInfo
     * @return 符合条件的商品列表
     * @throws RemoteException 
     */
    public List<GoodsVO> getGoodsInGoodsName(String goodsNameInfo) throws RemoteException;

    /**
     * 以商品分类模糊查找
     * @param goodsCategoryInfo
     * @return 符合条件的商品列表
     * @throws RemoteException 
     */
    public List<GoodsVO> getGoodsInCategory(String goodsCategoryInfo) throws RemoteException;


}
