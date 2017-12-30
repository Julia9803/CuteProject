//package dataServiceImpl.saleImpl;
//
//import PO.SaleListPO;
//import PO.SaleReturnListPO;
//import PO.StockListPO;
//import PO.StockReturnListPO;
//import dataService.saleDataService.SaleDataService;
//
///**     
//* @author 李安迪
//* @date 2017年11月10日
//* @description
//*/
//public class saledata_driver {
// SaleDataService service = new saledata_stub();
// public void drive(){
//	 if(service.insert(new SaleListPO()) == "0001")
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.insert(new SaleReturnListPO()) == "0001")
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.insert(new StockListPO()) == "0001")
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.insert(new StockReturnListPO()) == "0001")
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 
//	 if(service.deleteSaleList("0001"))
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.deleteSaleReturnList("0001"))
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.deleteStockList("0001"))
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.deleteStockReturnList("0001"))
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	
//	 if(service.get(null)!=null)
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.getSaleList(null)!=null)
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.getSaleReturnList(null)!=null)
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.getStockList(null)!=null)
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.getStockReturnList(null)!=null)
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 
//	 if(service.update(new SaleListPO()))
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.update(new SaleReturnListPO()))
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.update(new StockListPO()))
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
//	 if(service.update(new StockReturnListPO()))
//		 System.out.println("success");
//	 else
//		 System.out.println("fail");
// }
//}
