//package bl.presentbl;
//
//import VO.presentVO.PresentForMembershipVO;
//import VO.presentVO.PresentForSpecialPackageVO;
//import VO.presentVO.PresentForSumVO;
//import blservice.presentblservice.PresentBLService;
//import util.ResultMessage;
//
///**     
//* @author 李安迪
//* @date 2017年11月10日
//* @description
//*/
//public class PresentBLService_Driver {
////  PresentBLService service = new PresentBLServiceImpl();
//  PresentBLService service = new PresentBLService_Stub();
//
//  public void drive(){
//	  
//	  
//	  if(service.addPresentForMembership(null) == ResultMessage.SUCCESS)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  if(service.addPresentForSpecialPackage(null) == ResultMessage.SUCCESS)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  if(service.addPresentForSum(null) == ResultMessage.SUCCESS)
//		  System.out.println("Success");
//	  else {
//		  System.out.println("Fail");
//	  }
//	
//	  if(service.allPresentForMembership()!=null)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  if(service.allPresentForSpecialPackage()!=null)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  if(service.allPresentForSum()!=null)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  
//	  if(service.allStrategy()!=null)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  
////	  if(service.getStrategy(null)!=null)
////		  System.out.println("Success");
////	  else
////		  System.out.println("Fail");
//	  PresentForMembershipVO p1vo1 = new PresentForMembershipVO("0001", "双十一", null, null, null, null, 0, null, 0, 0);
//	  PresentForMembershipVO p1vo2 = new PresentForMembershipVO("0002", null, null, null, null, null, 0, null, 0, 0);
//	  PresentForSpecialPackageVO p2vo1 = new PresentForSpecialPackageVO("0001", "双十一", null, null, null, null, 0);
//	  PresentForSpecialPackageVO p2vo2 = new PresentForSpecialPackageVO("0002", "", null, null, null, null, 0);
//	  PresentForSumVO p3vo1 = new PresentForSumVO("0001", "双十一", null, null, null, 0, null, 0);
//	  PresentForSumVO p3vo2 = new PresentForSumVO(null, null, null, null, null, 0, null, 0);
//	  
//	  if(service.savePresentForMembership(p1vo1) == ResultMessage.EXIST)
//		  System.out.println("present exist");
//	  else
//		  System.out.println("Fail");
//	  
//	 if(service.savePresentForSpecialPackage(p2vo1) == ResultMessage.EXIST)
//		  System.out.println("present exist");
//	  else
//		  System.out.println("Fail");
//	  if(service.savePresentForSum(p3vo1) == ResultMessage.EXIST)
//		  System.out.println("present exist");
//	  else
//		  System.out.println("Fail");
//	  
//	  if(service.savePresentForMembership(p1vo2) == ResultMessage.SUCCESS)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  
//	  if(service.savePresentForSpecialPackage(p2vo2) == ResultMessage.SUCCESS)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  
//	  if(service.savePresentForSum(p3vo2) == ResultMessage.SUCCESS)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");
//	  
//	  if(service.deletePresentForMembership("0001") == ResultMessage.FAILED)
//		  System.out.println("fail to delete");
//	  else
//		  System.out.println("Fail");
//	  
//	  if(service.deletePresentForSpecialPackage("0001") == ResultMessage.FAILED)
//		  System.out.println("fail to delete");
//	  else
//		  System.out.println("Fail");
//	  
//	  if(service.deletePresentForSum("0001") == ResultMessage.FAILED)
//		  System.out.println("fail to delete");
//	  else
//		  System.out.println("Fail");
//	  
//	  
//	  if(service.deletePresentForMembership("0002") == ResultMessage.SUCCESS)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");		
//	  if(service.deletePresentForSpecialPackage("0002") == ResultMessage.SUCCESS)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//	  if(service.deletePresentForSum("0002") == ResultMessage.SUCCESS)
//		  System.out.println("Success");
//	  else
//		  System.out.println("Fail");	
//  }
//  
//
//}
