package bl.storebl;

import java.util.ArrayList;

public interface GetGoodsInfo {
//库存盘点的时候需要商品的两项信息 ，请写商品的同学帮忙实现一下
	public ArrayList<String> getModel_byID(ArrayList<String > id);//获取每个商品的型号
	public ArrayList<String> getDate_byID(ArrayList<String > id);//获取每个商品的出厂日期
}
