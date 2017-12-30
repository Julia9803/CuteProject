package blservice.presentblservice;

import java.util.List;

import VO.presentVO.PresentForMembershipVO;
import VO.presentVO.PresentForSpecialPackageVO;
import VO.presentVO.PresentForSumVO;
import VO.presentVO.PresentVO;
import resultmessage.ResultMessage;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description ui和bl之间的接口
*/
public interface PresentBLService{
	
	public List<PresentVO> allStrategy();
	
	public List<PresentForMembershipVO> allPresentForMembership();
	public ResultMessage addPresentForMembership(PresentForMembershipVO vo);
	public ResultMessage deletePresentForMembership(String id);
	public ResultMessage savePresentForMembership(PresentForMembershipVO vo);

	public List<PresentForSpecialPackageVO> allPresentForSpecialPackage();
	public ResultMessage addPresentForSpecialPackage(PresentForSpecialPackageVO vo);
	public ResultMessage deletePresentForSpecialPackage(String id);
	public ResultMessage savePresentForSpecialPackage(PresentForSpecialPackageVO vo);
	
	public List<PresentForSumVO> allPresentForSum();
	public ResultMessage addPresentForSum(PresentForSumVO vo);
	public ResultMessage deletePresentForSum(String id);
	public ResultMessage savePresentForSum(PresentForSumVO vo);


}
