//package bl.presentbl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import VO.presentVO.PresentForMembershipVO;
//import VO.presentVO.PresentForSpecialPackageVO;
//import VO.presentVO.PresentForSumVO;
//import VO.presentVO.PresentVO;
//import blservice.presentblservice.PresentBLService;
//import util.ResultMessage;
//
///**     
//* @author 李安迪
//* @date 2017年11月10日
//* @description
//*/
//public class PresentBLService_Stub implements PresentBLService{
//
//	List<PresentForMembershipVO> ListForMembership = new ArrayList<PresentForMembershipVO>();
//	List<PresentForSpecialPackageVO> ListForSpecialPackage = new ArrayList<PresentForSpecialPackageVO>();
//	List<PresentForSumVO> ListForSum = new ArrayList<PresentForSumVO>();
//	List<PresentVO> ListForAll = new ArrayList<PresentVO>();
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForMembershipBLService#allPresentForMembership()
//	 */
//	@Override
//	public List<PresentForMembershipVO> allPresentForMembership() {
//		// TODO Auto-generated method stub
//		return ListForMembership;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForMembershipBLService#addPresentForMembership(VO.PresentForMembershipVO)
//	 */
//	@Override
//	public ResultMessage addPresentForMembership(PresentForMembershipVO vo) {
//		// TODO Auto-generated method stub
//
//		return ResultMessage.SUCCESS;
//		
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForMembershipBLService#deletePresentForMembership(java.lang.String)
//	 */
//	@Override
//	public ResultMessage deletePresentForMembership(String id) {
//		// TODO Auto-generated method stub
//		if(id == "0001")
//			return ResultMessage.FAILED;//现在销售单里有的策略不能删除
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForMembershipBLService#savePresentForMembership(VO.PresentForMembershipVO)
//	 */
//	@Override
//	public ResultMessage savePresentForMembership(PresentForMembershipVO vo) {
//		// TODO Auto-generated method stub
//		if(vo.getPresentName() == "双十一")
//			return ResultMessage.EXIST;
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForSpecialPackageBLService#allPresentForSpecialPackage()
//	 */
//	@Override
//	public List<PresentForSpecialPackageVO> allPresentForSpecialPackage() {
//		// TODO Auto-generated method stub
//		return ListForSpecialPackage;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForSpecialPackageBLService#addPresentForSpecialPackage(VO.PresentForSpecialPackageVO)
//	 */
//	@Override
//	public ResultMessage addPresentForSpecialPackage(PresentForSpecialPackageVO vo) {
//		// TODO Auto-generated method stub
//
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForSpecialPackageBLService#deletePresentForSpecialPackage(java.lang.String)
//	 */
//	@Override
//	public ResultMessage deletePresentForSpecialPackage(String id) {
//		// TODO Auto-generated method stub
//		if(id == "0001")
//			return ResultMessage.FAILED;//现在销售单里有的策略不能删除
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForSpecialPackageBLService#savePresentForSpecialPackage(VO.PresentForSpecialPackageVO)
//	 */
//	@Override
//	public ResultMessage savePresentForSpecialPackage(PresentForSpecialPackageVO vo) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForSumBLService#allPresentForSum()
//	 */
//	@Override
//	public List<PresentForSumVO> allPresentForSum() {
//		// TODO Auto-generated method stub
//		return ListForSum;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForSumBLService#addPresentForSum(VO.PresentForSumVO)
//	 */
//	@Override
//	public ResultMessage addPresentForSum(PresentForSumVO vo) {
//		// TODO Auto-generated method stub
//
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForSumBLService#deletePresentForSum(java.lang.String)
//	 */
//	@Override
//	public ResultMessage deletePresentForSum(String id) {
//		// TODO Auto-generated method stub
//		if(id == "0001")
//			return ResultMessage.FAILED;//现在销售单里有的策略不能删除
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentForSumBLService#savePresentForSum(VO.PresentForSumVO)
//	 */
//	@Override
//	public ResultMessage savePresentForSum(PresentForSumVO vo) {
//		// TODO Auto-generated method stub
//		if(vo.getPresentName() == "双十一")
//			return ResultMessage.EXIST;
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentBLService#allStrategy()
//	 */
//	@Override
//	public List<PresentVO> allStrategy() {
//		// TODO Auto-generated method stub
//		return ListForAll;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.presentblservice.PresentBLService#getStrategy(VO.SaleVO)
//	 */
////	@Override
////	public List<PresentVO> getStrategy(SaleVO vo) {
////		// TODO Auto-generated method stub
////		return ListForAll;
////	}
//
//}
