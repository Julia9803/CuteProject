package blservice.presentblservice;

import java.util.List;

import VO.presentVO.PresentForSumVO;
import resultmessage.DataRM;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public interface PresentForSumBLService {
	public List<PresentForSumVO> getAll();
	public int getId();
	public DataRM delete(int id);
	public DataRM save(PresentForSumVO vo);
}
