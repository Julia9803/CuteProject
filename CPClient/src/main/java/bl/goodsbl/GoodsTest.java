package bl.goodsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.goodsVO.GoodsVO;
import network.ServerConnector;

public class GoodsTest {
	ServerConnector connector=new  ServerConnector();
	Goods goods=new Goods();
  public static void main(String [] args){
	  
	  GoodsTest test=new GoodsTest();
	  ArrayList<GoodsVO> vo=null;
	  try {
		vo=test.goods.findGoods("1", "goodsID");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  System.out.println(vo==null);
  }
}
