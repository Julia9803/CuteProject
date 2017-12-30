package blservice.presentblservice;

import java.util.List;

import VO.presentVO.PresentForSpecialPackageVO;
import resultmessage.DataRM;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public interface PresentForSpecialPackageBLService {
	public List<PresentForSpecialPackageVO> getAll();
	public int getId();
	public DataRM delete(int id);
	public DataRM save(PresentForSpecialPackageVO vo);
}
