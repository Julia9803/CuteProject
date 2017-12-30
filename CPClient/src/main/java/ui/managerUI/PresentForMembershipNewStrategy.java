package ui.managerUI;

import VO.presentVO.PresentVO;
import blservice.presentblservice.PresentForMembershipBLService;
import blservice.presentblservice.PresentForSumBLService;
import resultmessage.DataRM;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description
*/
public class PresentForMembershipNewStrategy implements Strategy{

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#initData(ui.managerUI.SinglePresentController)
	 */
	@Override
	public void initData(SinglePresentController controller,PresentVO vo) {
		// TODO Auto-generated method stub
		
		System.out.println("init data");
		
		assert(vo == null);
		
		PresentForMembershipController membershipController = (PresentForMembershipController)controller;
		
		PresentForMembershipBLService service = membershipController.getService();
		
		int id = service.getId();
		
		if(id>=0)
		membershipController.setId(id);
		else{
			membershipController.showInformationDialog(DataRM.FAILED);
		}

		
	    
	}

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#cancel(ui.managerUI.SinglePresentController)
	 */
	@Override
	public DataRM cancel(SinglePresentEditableController controller) {
		// TODO Auto-generated method stub
		PresentForMembershipController membershipController = (PresentForMembershipController)controller;
		
		PresentForMembershipBLService service = membershipController.getService();
		
		int id = membershipController.getId();
		
		return service.delete(id);
		
	}

}
