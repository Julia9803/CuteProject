package dataService.presentDataService;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.List;

import PO.PresentForMembershipPO;
import PO.PresentForSpecialPackagePO;
import PO.PresentForSumPO;
import PO.PresentPO;
import resultmessage.DataRM;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description
*/
public interface PresentDataService extends Remote,Serializable{
	public List<PresentPO> get();
	
	public DataRM insert(PresentForMembershipPO po);
	public DataRM deletePresentForMembership(String id);
	public DataRM update(PresentForMembershipPO po);
	public List<PresentForMembershipPO> getPresentForMembership();
	public List<PresentForMembershipPO> getPresentForMembership(VIPGrade grade);
	
	public DataRM insert(PresentForSpecialPackagePO po);
	public DataRM deletePresentForSpecialPackage(String id);
	public DataRM update(PresentForSpecialPackagePO po);
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage();
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<String> GoodsID);
	
	public DataRM insert(PresentForSumPO po);
	public DataRM deletePresentForSum(String id);
	public DataRM update(PresentForSumPO po);
	public List<PresentForSumPO> getPresentForSum();
	public List<PresentForSumPO> getPresentForSum(int sum);
	
}
