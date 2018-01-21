package ui.managerUI;

import VO.presentVO.PresentVO;
import blservice.presentblservice.PresentForSpecialPackageBLService;
import resultmessage.DataRM;
import ui.commonUI.PromptHelper;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description
*/
public class PresentForSpecialPackageNewStrategy implements Strategy{

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#initData(ui.managerUI.SinglePresentController)
	 */
	@Override
	public void initData(SinglePresentController controller,PresentVO vo) {
		// TODO Auto-generated method stub
		
		System.out.println("init data");
		
		assert(vo == null);
		
		PresentForSpecialPackageController specialPackageController = (PresentForSpecialPackageController)controller;
		
		PresentForSpecialPackageBLService service = specialPackageController.getService();
		
		int id = service.getId();
		
		if(id>=0)
		specialPackageController.setId(id);
		else{
			PromptHelper.showPrompt(DataRM.FAILED);
		}

		
	    
	}

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#cancel(ui.managerUI.SinglePresentController)
	 */
	@Override
	public DataRM cancel(SinglePresentEditableController controller) {
		// TODO Auto-generated method stub
		PresentForSpecialPackageController specialPackageController = (PresentForSpecialPackageController)controller;
		
		PresentForSpecialPackageBLService service = specialPackageController.getService();
		
		int id = specialPackageController.getId();
		
		return service.delete(id);
		
	}

}
