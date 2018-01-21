package bl.goodsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.GoodsCategoryPO;
import VO.goodsVO.GoodsCategoryVO;
import dataService.goodsDataService.GoodsDataService;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import resultmessage.ResultMessage;

/**
 * Created by julia98 on 2017/12/14.
 * 处理商品分类的增删改查逻辑
 */
public class GoodsCategory {
    GoodsDataService goodsDataService = GoodsDataServiceHelper.getInstance().getGoodsDataService();

    public ResultMessage deleteGoodsCategory(GoodsCategoryVO vo) throws RemoteException{
        goodsDataService.deleteGoodsCategory(voToPO(vo));
        return ResultMessage.SUCCESS;

    }

    public ResultMessage modifyGoodsCategory(GoodsCategoryVO newVO) throws RemoteException{
        goodsDataService.modifyGoodsCategory(voToPO(newVO));
        return ResultMessage.SUCCESS;

    }

    public ArrayList<GoodsCategoryVO> getAllCategory(String node) throws RemoteException{
    	//加一行输出
    	System.out.println("bl.goodsbl.GoodsCategory 获取所有商品分类");
    	//for(int i =0;i<goodsDataService.getAllCategory(node).size();i++) {
    	//	System.out.println(goodsDataService.getAllCategory(node).get(i));
    	//}
    	ArrayList<GoodsCategoryVO> list = new ArrayList<>();
        ArrayList<GoodsCategoryPO> allCategory = (ArrayList<GoodsCategoryPO>) goodsDataService.getAllCategory(node);
		for(int i =0;i<allCategory.size();i++) {
			list.add(poToVO(allCategory.get(i)));
		}
        return list;
    }

    public GoodsCategoryVO getCategory(String goodsCategoryName,String parentName) throws RemoteException {
        return poToVO(goodsDataService.getCategory(goodsCategoryName,parentName));
    }

    public int newGoodsCategoryAutoId(GoodsCategoryVO vo)  {
        try {
        	System.out.println(voToPO(vo).getGoodsCategoryName());
        	System.out.println(goodsDataService);
			return goodsDataService.newGoodsCategoryAutoId(voToPO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
    }

    private GoodsCategoryPO voToPO(GoodsCategoryVO vo){
        GoodsCategoryPO po = new GoodsCategoryPO(vo.getGoodsCategoryName(),vo.getParentName(),null);
        po.setAutoId(vo.getAutoId());
        po.setState(vo.getState());
        return po;
    }

    private GoodsCategoryVO poToVO(GoodsCategoryPO po){
        GoodsCategoryVO vo = new GoodsCategoryVO(po.getGoodsCategoryName(),po.getParentName());
        vo.setAutoId(po.getAutoId());
        vo.setState(po.getState());
        return vo;
    }

}
