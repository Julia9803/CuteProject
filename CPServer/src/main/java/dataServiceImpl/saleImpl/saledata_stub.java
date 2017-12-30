//package dataServiceImpl.saleImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import PO.GoodsPO;
//import PO.ListPO;
//import PO.SaleListPO;
//import PO.SaleReturnListPO;
//import PO.SalesmanListPO;
//import PO.State;
//import PO.StockListPO;
//import PO.StockReturnListPO;
//import PO.VIPPO;
//import dataService.saleDataService.SaleDataService;
//
//public class saledata_stub implements SaleDataService{
//	List<SaleListPO> saleList = new ArrayList<SaleListPO>();
//	List<SaleReturnListPO> saleReturnList = new ArrayList<SaleReturnListPO>();
//	List<StockListPO> stockList = new ArrayList<StockListPO>();
//	List<StockReturnListPO> stockReturnList = new ArrayList<StockReturnListPO>();
//	List<SalesmanListPO> list = new ArrayList<SalesmanListPO>();
//	List<VIPPO> viplist = new ArrayList<VIPPO>();
//	List<GoodsPO> goods = new ArrayList<GoodsPO>();
//	/* (non-Javadoc)
//	 * @see saledataservice.SaleListDataService#insert(PO.SaleListPO)
//	 */
//	public String insert(SaleListPO po) {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.SaleListDataService#deleteSaleList(java.lang.String)
//	 */
//	public boolean deleteSaleList(String id) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.SaleListDataService#update(PO.SaleListPO)
//	 */
//	public boolean update(SaleListPO po) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.SaleListDataService#getSaleList(PO.State)
//	 */
//	public List<SaleListPO> getSaleList(State state) {
//		// TODO Auto-generated method stub
//		return saleList;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.SaleReturnListDataService#insert(PO.SaleReturnListPO)
//	 */
//	public String insert(SaleReturnListPO po) {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.SaleReturnListDataService#deleteSaleReturnList(java.lang.String)
//	 */
//	public boolean deleteSaleReturnList(String id) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.SaleReturnListDataService#update(PO.SaleReturnListPO)
//	 */
//	public boolean update(SaleReturnListPO po) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.SaleReturnListDataService#getSaleReturnList(PO.State)
//	 */
//	public List<SaleReturnListPO> getSaleReturnList(State state) {
//		// TODO Auto-generated method stub
//		return saleReturnList;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.StockListDataService#insert(PO.StockListPO)
//	 */
//	public String insert(StockListPO po) {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.StockListDataService#deleteStockList(java.lang.String)
//	 */
//	public boolean deleteStockList(String id) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.StockListDataService#update(PO.StockListPO)
//	 */
//	public boolean update(StockListPO po) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.StockListDataService#getStockList(PO.State)
//	 */
//	public List<StockListPO> getStockList(State state) {
//		// TODO Auto-generated method stub
//		return stockList;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.StockReturnListDataService#insert(PO.StockReturnListPO)
//	 */
//	public String insert(StockReturnListPO po) {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.StockReturnListDataService#deleteStockReturnList(java.lang.String)
//	 */
//	public boolean deleteStockReturnList(String id) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.StockReturnListDataService#update(PO.StockReturnListPO)
//	 */
//	public boolean update(StockReturnListPO po) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.StockReturnListDataService#getStockReturnList(PO.State)
//	 */
//	public List<StockReturnListPO> getStockReturnList(State state) {
//		// TODO Auto-generated method stub
//		return stockReturnList;
//	}
//
//	/* (non-Javadoc)
//	 * @see saledataservice.SaleDataService#get(PO.State)
//	 */
//	public List<SalesmanListPO> get(State state) {
//		// TODO Auto-generated method stub
//		return list;
//	}
//
////	public String insert(SalesmanListPO po) {
////		// TODO Auto-generated method stub
////		System.out.println("inserting succeed");
////		return "success";
////	}
////
////	public String delete(SalesmanListPO po) {
////		// TODO Auto-generated method stub
////		System.out.println("deleting succeed");
////		return "success";
////	}
////
////	public String update(SalesmanListPO po) {
////		// TODO Auto-generated method stub
////		System.out.println("updating succeed");
////		return "success";
////	}
////
////	public String find(SalesmanListPO po) {
////		// TODO Auto-generated method stub
////		System.out.println("finding succeed");
////		return "success";
////	}
//
//}
