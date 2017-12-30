//package dataServiceImpl.presentImpl;
//
//import PO.PresentForMembershipPO;
//import PO.PresentForSpecialPackagePO;
//import PO.PresentForSumPO;
//import dataService.presentDataService.PresentDataService;
//
///**     
//* @author 李安迪
//* @date 2017年11月10日
//* @description
//*/
//public class PresentDataService_Driver {
////  PresentBLService service = new PresentBLServiceImpl();
//  PresentDataService service = new PresentDataService_Stub();
//
//  public void drive(){
//	  if(service.getPresentForMembership()!=null)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  if(service.getPresentForSpecialPackage()!=null)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  if(service.getPresentForSum()!=null)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  if(!service.deletePresentForMembership("0001"))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(!service.deletePresentForSpecialPackage("0001"))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(!service.deletePresentForSum("0001"))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(!service.update(new PresentForMembershipPO("0001", null, null, null, 0, null, 0, 0)))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(!service.update(new PresentForSpecialPackagePO("0001", null, null, null, 0)))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(!service.update(new PresentForSumPO("0001", null, null, 0, null, 0)))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(service.deletePresentForMembership("0002"))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(service.deletePresentForSpecialPackage("0002"))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(service.deletePresentForSum("0002"))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(service.update(new PresentForMembershipPO("0002", null, null, null, 0, null, 0, 0)))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(service.update(new PresentForSpecialPackagePO("0002", null, null, null, 0)))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(service.update(new PresentForSumPO("0002", null, null, 0, null, 0)))
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//  }
//}
