package dataServiceImpl.goodsImpl;

import PO.GoodsCategoryPO;
import PO.GoodsPO;
import resultmessage.ResultMessage;
import util.GoodsUtil;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by julia98 on 2017/12/26.
 */
public class GoodsDataServiceImplTest {
    GoodsCategoryPO po = new GoodsCategoryPO("水晶灯","根节点",GoodsUtil.EXIST);
    GoodsCategoryPO po2 = new GoodsCategoryPO("豪华水晶灯2","水晶灯",GoodsUtil.EXIST);
    GoodsCategoryPO po3 = new GoodsCategoryPO("节能灯1","根节点",GoodsUtil.EXIST);
    GoodsCategoryPO po4 = new GoodsCategoryPO("123a","abc",GoodsUtil.EXIST);
    GoodsPO goodsPO = new GoodsPO("1"
            ,"商品分类"
            ,"商品名称"
            ,"商品种类"
            ,0
            ,0
            ,0
            ,0,GoodsUtil.EXIST);
    GoodsPO goodsPO2 = new GoodsPO("2"
            ,"商品分类"
            ,"护眼灯"
            ,"商品种类"
            ,0
            ,0
            ,0
            ,0,GoodsUtil.EXIST);
    List<GoodsCategoryPO> poList;
    
    @org.junit.Test
    public void newGoodsID() throws Exception {
    //	assertEquals("",new GoodsDataServiceImpl().newGoodsID(goodsPO));
    }

    @org.junit.Test
    public void findGoods() throws Exception {
    	//assertEquals(goodsPO2,new GoodsDataServiceImpl().findGoods("商品分类", "商品名称"));
    //	assertEquals(goodsPO2,new GoodsDataServiceImpl().findGoods("2", "goodsID"));
    }

    @org.junit.Test
    public void getGoods() throws Exception {  
    	assertEquals(goodsPO,new GoodsDataServiceImpl().getGoods("商品名称", "商品分类"));
    }

    @org.junit.Test
    public void deleteGoods() throws Exception {
    	//assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().deleteGoods("商品分类", "商品名称"));
    }

    @org.junit.Test
    public void modifyGoods() throws Exception {
    //	GoodsDataServiceImpl g = new GoodsDataServiceImpl();
    //GoodsPO	po = (GoodsPO)g.findGoods("护眼灯", "goodsName").get(0);
    //po.setGoodsCategory("学习灯");
    //po.setGoodsID("1001");
    	//assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().modifyGoods(po));
    }

    @org.junit.Test
    public void newGoodsCategory() throws Exception {
        //assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().newGoodsCategory(po4));
        //assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().newGoodsCategory(po2));
        //assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().newGoodsCategory(po3));
    }

    @org.junit.Test
    public void deleteGoodsCategory() throws Exception {
    //	GoodsDataServiceImpl g = new GoodsDataServiceImpl();
    //GoodsCategoryPO po =	(GoodsCategoryPO)g.getAllCategory("根节点").get(0);
    	//assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().deleteGoodsCategory(po));
    }

    @org.junit.Test
    public void modifyGoodsCategory() throws Exception {
    	//GoodsDataServiceImpl g = new GoodsDataServiceImpl();
    //GoodsCategoryPO po =	(GoodsCategoryPO)g.getAllCategory("根节点").get(0);
    //po.setGoodsCategoryName("节能灯2");
    	//assertEquals(ResultMessage.SUCCESS,new GoodsDataServiceImpl().modifyGoodsCategory(null, po));
    }

    @org.junit.Test
    public void getAllCategory() throws Exception {
    	   // assertEquals("节能灯1",new GoodsDataServiceImpl().getAllCategory("根节点").get(0));
    }
}