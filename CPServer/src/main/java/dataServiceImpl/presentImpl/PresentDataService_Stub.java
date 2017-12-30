//package dataServiceImpl.presentImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import PO.PresentForMembershipPO;
//import PO.PresentForSpecialPackagePO;
//import PO.PresentForSumPO;
//import PO.PresentPO;
////import PO.VIPGrade;
//import dataService.presentDataService.PresentDataService;
//
///**     
//* @author 李安迪
//* @date 2017年11月10日
//* @description
//*/
//public class PresentDataService_Stub implements PresentDataService{
//	List<PresentForMembershipPO> ListForMembership = new ArrayList<PresentForMembershipPO>();
//	List<PresentForSpecialPackagePO> ListForSpecialPackage = new ArrayList<PresentForSpecialPackagePO>();
//	List<PresentForSumPO> ListForSum = new ArrayList<PresentForSumPO>();
//	List<PresentPO> ListForAll = new ArrayList<PresentPO>();
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForMembershipDataService#insert(PO.PresentForMembershipPO)
//	 */
//	public String insert(PresentForMembershipPO po) {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForMembershipDataService#deletePresentForMembership(java.lang.String)
//	 */
//	public boolean deletePresentForMembership(String id) {
//		// TODO Auto-generated method stub
//		if(id == "0001")
//		return false;
//		else
//			return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForMembershipDataService#update(PO.PresentForMembershipPO)
//	 */
//	public boolean update(PresentForMembershipPO po) {
//		// TODO Auto-generated method stub
//		if(po.getId() == "0001")
//		return false;//如果已经被删除，不能更新
//		else
//			return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForMembershipDataService#getPresentForMembership()
//	 */
//	public List<PresentForMembershipPO> getPresentForMembership() {
//		// TODO Auto-generated method stub
//		return ListForMembership;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForMembershipDataService#getPresentForMembership(PO.VIPGrade)
//	 */
//	/*public List<PresentForMembershipPO> getPresentForMembership(VIPGrade grade) {
//		// TODO Auto-generated method stub
//		return ListForMembership;
//	}*/
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSpecialPackageDataService#insert(PO.PresentForSpecialPackagePO)
//	 */
//	public String insert(PresentForSpecialPackagePO po) {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSpecialPackageDataService#deletePresentForSpecialPackage(java.lang.String)
//	 */
//	public boolean deletePresentForSpecialPackage(String id) {
//		// TODO Auto-generated method stub
//		if(id == "0001")
//		return false;
//		else
//			return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSpecialPackageDataService#update(PO.PresentForSpecialPackagePO)
//	 */
//	public boolean update(PresentForSpecialPackagePO po) {
//		// TODO Auto-generated method stub
//		if(po.getId() == "0001")
//		return false;//如果已经被删除，不能更新，如果重名，不能更新
//		else
//			return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSpecialPackageDataService#getPresentForSpecialPackage()
//	 */
//	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage() {
//		// TODO Auto-generated method stub
//		return ListForSpecialPackage;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSpecialPackageDataService#getPresentForSpecialPackage(java.util.List)
//	 */
//	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<String> GoodsID) {
//		// TODO Auto-generated method stub
//		return ListForSpecialPackage;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSumDataService#insert(PO.PresentForSumPO)
//	 */
//	public String insert(PresentForSumPO po) {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSumDataService#deletePresentForSum(java.lang.String)
//	 */
//	public boolean deletePresentForSum(String id) {
//		// TODO Auto-generated method stub
//		if(id == "0001")
//		return false;
//		else
//			return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSumDataService#update(PO.PresentForSumPO)
//	 */
//	public boolean update(PresentForSumPO po) {
//		// TODO Auto-generated method stub
//		if(po.getId() == "0001")
//		return false;//如果已经被删除，不能更新
//		else
//			return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSumDataService#getPresentForSum()
//	 */
//	public List<PresentForSumPO> getPresentForSum() {
//		// TODO Auto-generated method stub
//		return ListForSum;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentForSumDataService#getPresentForSum(int)
//	 */
//	public List<PresentForSumPO> getPresentForSum(int sum) {
//		// TODO Auto-generated method stub
//		return ListForSum;
//	}
//
//	/* (non-Javadoc)
//	 * @see presentdataservice.PresentDataService#get()
//	 */
//	public List<PresentPO> get() {
//		// TODO Auto-generated method stub
//		return ListForAll;
//	}
//
//}
