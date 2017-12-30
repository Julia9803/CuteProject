package blservice.goodsblservice;

import java.rmi.RemoteException;
import java.util.List;

import PO.GoodsCategoryPO;
import VO.goodsVO.GoodsCategoryVO;
import VO.goodsVO.GoodsVO;
import resultmessage.ResultMessage;

/**     
* @author 李安迪
* @date 2017年10月22日
* @description
*/
public interface GoodsBLService {
    public int newGoodsCategoryAutoId(GoodsCategoryVO vo) throws RemoteException;
	public String newGoodsID(GoodsVO vo) throws RemoteException;
	public List<GoodsVO> findGoods(String info,String type) throws RemoteException;
	public GoodsVO getGoods(String name,String category) throws RemoteException;
	public ResultMessage deleteGoods(String category,String name) throws RemoteException;//修改接口 把入口参数变更为分类名+商品名 之前为商品ID 我是在商品目录里面删除的 商品ID不利于调用
	public ResultMessage modifyGoods(GoodsVO vo) throws RemoteException;
	public ResultMessage deleteGoodsCategory(GoodsCategoryVO vo) throws RemoteException;
	public ResultMessage modifyGoodsCategory(GoodsCategoryVO newVO) throws RemoteException;
    public GoodsCategoryVO getCategory(String goodsCategoryName,String parentName) throws RemoteException;
	public List getAllCategory(String node) throws RemoteException;
}