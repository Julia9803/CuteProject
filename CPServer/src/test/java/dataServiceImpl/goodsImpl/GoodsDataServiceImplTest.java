package dataServiceImpl.goodsImpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import PO.GoodsCategoryPO;
import PO.GoodsPO;
import util.GoodsUtil;

/**
 * Created by julia98 on 2017/12/26.
 */
public class GoodsDataServiceImplTest {
    GoodsCategoryPO po1 = new GoodsCategoryPO("A灯","根目录",GoodsUtil.EXIST);
    GoodsCategoryPO po2 = new GoodsCategoryPO("B灯","根目录",GoodsUtil.EXIST);
    GoodsCategoryPO po3 = new GoodsCategoryPO("C灯","根目录",GoodsUtil.EXIST);
    GoodsCategoryPO po4 = new GoodsCategoryPO("D灯","根目录",GoodsUtil.EXIST);
    GoodsPO goodsPO1 = new GoodsPO("1"
            ,"A灯"
            ,"商品名称"
            ,"商品种类"
            ,0
            ,0
            ,0
            ,0,GoodsUtil.EXIST);
    GoodsPO goodsPO2 = new GoodsPO("2"
            ,"B灯"
            ,"护眼灯"
            ,"商品种类"
            ,0
            ,0
            ,0
            ,0,GoodsUtil.EXIST);
    List<GoodsCategoryPO> poList;
    
    @org.junit.Test
    public void newGoodsID() throws Exception {
    	//for(int i =0;i<100;i++) {
    		goodsPO2.setGoodsName("B灯" + 2);
      	assertEquals("",new GoodsDataServiceImpl().newGoodsID(goodsPO2));
    	//}
    }

    @org.junit.Test
    public void findGoods() throws Exception {
    	//assertEquals(goodsPO2,new GoodsDataServiceImpl().findGoods("商品分类", "商品名称"));
    //	assertEquals(goodsPO2,new GoodsDataServiceImpl().findGoods("2", "goodsID"));
    }

    @org.junit.Test
    public void getGoods() throws Exception {  
    //	assertEquals(goodsPO,new GoodsDataServiceImpl().getGoods("商品名称", "商品分类"));
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
    public void newGoodsCategoryAutoId() throws Exception {
        //assertEquals(1,new GoodsDataServiceImpl().newGoodsCategoryAutoId(po4));
        //assertEquals(2,new GoodsDataServiceImpl().newGoodsCategoryAutoId(po2));
        //assertEquals(3,new GoodsDataServiceImpl().newGoodsCategoryAutoId(po3));
        //assertEquals(4,new GoodsDataServiceImpl().newGoodsCategoryAutoId(po1));
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
    	   // assertEquals("节能灯1",new GoodsDataServiceImpl().getAllCategory("根目录").get(0));
    }
}