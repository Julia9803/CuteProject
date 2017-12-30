package dataService.saleDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public interface SaleProjectionDataService extends Remote,Serializable{
	/*
	 * 把所有销售单遍历一遍，累加一下每张单据的折让后金额，返回加起来的数值
	 */
      public double getSalesIncome() throws RemoteException;//获取折让后销售总收入
      
      /*
       * 把所有销售单遍历一遍，累加一下每张单据总共折让了多少钱，返回加起来的数值
       */
      public double getSalesDiscount() throws RemoteException;//获取销售折让总额
      
      /*
       * 把所有销售退货单据遍历一遍，计算单据金额之和
       */
      public double getSalesReturnOutcome() throws RemoteException;//获取销售退货总支出
      
      /*
       * 把所有进货退货单据遍历一遍，计算所有单据金额之和
       */
      public double getStockReturnIncome() throws RemoteException;//获取进货退货总收入
      
      /*
       * 把所有进货单遍历一遍，计算所有单据金额之和
       */
      public double getStockOutcome() throws RemoteException;//获取进货总支出
}
