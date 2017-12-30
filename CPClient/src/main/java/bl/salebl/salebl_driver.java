//package bl.salebl;
//
//
//import util.ResultMessage;
//public class salebl_driver {
//	
//	salebl_stub service;
//
//	public void drive(){
//		if(service.commitSaleList(null)==ResultMessage.SUCCESS)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.commitSaleReturnList(null)==ResultMessage.SUCCESS)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.commitStockList(null)==ResultMessage.SUCCESS)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.commitStockReturnList(null)==ResultMessage.SUCCESS)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.saveSaleDraftList(null)==ResultMessage.SUCCESS)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.saveSaleReturnDraftList(null)==ResultMessage.SUCCESS)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.saveStockDraftList(null)==ResultMessage.SUCCESS)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.saveStockReturnDraftList(null)==ResultMessage.SUCCESS)
//			System.out.println("success");
//		else
//			System.out.println("fail");		
//		if(service.createSaleList() == "0001")
//			System.out.println("success");
//		else
//			System.out.println("fail");	
//		if(service.createSaleReturnList() == "0001")
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.createStockList() == "0001")
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.createStockReturnList() == "0001")
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.findGoods(null) != null)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		if(service.findPresent(null) != null)
//		System.out.println("success");
//	else
//		System.out.println("fail");
//		
//		if(service.findVIP(null,null) != null)
//		System.out.println("success");
//	else
//		System.out.println("fail");
//		
//		if(service.openDraftList()!=null)
//			System.out.println("success");
//		else
//			System.out.println("fail");	
//		if(service.openSaleDraftList()!=null)
//			System.out.println("success");
//		else
//			System.out.println("fail");	
//		if(service.openSaleReturnDraftList()!=null)
//			System.out.println("success");
//		else
//			System.out.println("fail");	
//		if(service.openStockReturnDraftList()!=null)
//			System.out.println("success");
//		else
//			System.out.println("fail");	
//		if(service.openStockDraftList()!=null)
//			System.out.println("success");
//		else
//			System.out.println("fail");	
//	}
//    	 
//   
//
//}
//
