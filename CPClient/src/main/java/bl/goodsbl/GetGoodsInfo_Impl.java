package bl.goodsbl;

import java.util.ArrayList;

import bl.storebl.GetGoodsInfo;

public class GetGoodsInfo_Impl implements GetGoodsInfo {
    /*
     * 库存盘点的时候需要下面的两个数据，请写商品的同学帮我实现一下。
     *  王瑞华。//你看下面GoodsFuzzySearch
     */
	@Override
	public ArrayList<String> getModel_byID(ArrayList<String> id) {
		//根据商品ID 获得商品的型号
		
		return null;
	}

	@Override
	public ArrayList<String> getDate_byID(ArrayList<String> id) {
		// 根据商品ID 获得商品的出厂日期
		
		return null;
	}

}
