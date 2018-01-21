package ui.managerUI;

import VO.presentVO.PresentVO;
import blservice.presentblservice.PresentForSumBLService;
import resultmessage.DataRM;
import ui.commonUI.PromptHelper;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description
*/
public class PresentForSumNewStrategy implements Strategy{

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#initData(ui.managerUI.SinglePresentController)
	 */
	@Override
	public void initData(SinglePresentController controller,PresentVO vo) {
		// TODO Auto-generated method stub
		
		System.out.println("init data");
		
		assert(vo == null);
		
		PresentForSumController sumController = (PresentForSumController)controller;
		
		PresentForSumBLService service = sumController.getService();
		
		int id = service.getId();
		
		if(id>=0)
		sumController.setId(id);
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
		PresentForSumController sumController = (PresentForSumController)controller;
		
		PresentForSumBLService service = sumController.getService();
		
		int id = sumController.getId();
		
		return service.delete(id);
		
	}

}
