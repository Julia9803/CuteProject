package ui.salesmanUI;

import VO.saleVO.SalesmanListVO;
import blservice.saleblservice.SaleUniBLService;
import resultmessage.DataRM;
import ui.commonUI.PromptHelper;

/**     
* @author 李安迪
* @date 2018年1月8日
* @description 判断id合法性，若合法，改变id或赋值新id
*/
public class IdChecker {
	public static boolean checkId(SaleUniBLService uniBLService,SalesmanListVO vo) {
		String id;
		id = uniBLService.getId();
		if(id == null || id.length() == 0)
		{
			PromptHelper.showPrompt(DataRM.NET_FAILED);

			return false;
		}
		
		if(id == global.ListGlobalVariables.LIST_FULL)
		{
			PromptHelper.showPrompt(DataRM.LIST_FULL);

			return false;
			
		}
		
		vo.setId(id);
		return true;
	}
	public static boolean checkId(SaleUniBLService uniBLService,String id) {
		if(id == null || id.length() == 0)
		{
			PromptHelper.showPrompt(DataRM.NET_FAILED);

			return false;
		}
		
		if(id == global.ListGlobalVariables.LIST_FULL)
		{
			PromptHelper.showPrompt(DataRM.LIST_FULL);

			return false;
			
		}
		

		return true;
	}
	
}
