package dataService.goodsDataService;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.GoodsCategoryPO;
import PO.GoodsPO;
import resultmessage.ResultMessage;

public interface GoodsDataService extends Remote,Serializable {
    public int newGoodsCategoryAutoId(GoodsCategoryPO po) throws RemoteException;
    public String newGoodsID(GoodsPO po) throws RemoteException;
    public List<GoodsPO> findGoods(String info, String type) throws RemoteException;
    public GoodsPO getGoods(String name, String category) throws RemoteException;
    public ResultMessage deleteGoods(String category, String name) throws RemoteException;
    public ResultMessage modifyGoods(GoodsPO po) throws RemoteException;
    public ResultMessage deleteGoodsCategory(GoodsCategoryPO po) throws RemoteException;
    public ResultMessage modifyGoodsCategory(GoodsCategoryPO newVO) throws RemoteException;
    public GoodsCategoryPO getCategory(String goodsCategoryName,String parentName) throws RemoteException;
    public List getAllCategory(String node) throws RemoteException;
}
