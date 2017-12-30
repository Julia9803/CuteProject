package ui.managerUI;

import VO.presentVO.PresentVO;
import resultmessage.DataRM;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description
*/
public interface Strategy {
	void initData(SinglePresentController controller,PresentVO vo);
	DataRM cancel(SinglePresentEditableController controller);
}
