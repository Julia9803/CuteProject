package bl.userbl;

import PO.user.UserPO;
import VO.userVO.UserVO;

public class VOPOTransformer {
	public UserVO poTovo(UserPO po){
		return new UserVO(po.getId(),po.getName(),po.getPassword(),
				po.getType(),po.getGrade(),po.getPermission());
	}
	
	public UserPO voTopo(UserVO vo){
		return new UserPO(vo.getId(),vo.getName(),vo.getPassword(),
				vo.getType(),vo.getGrade(),vo.getPermission());
	}
}
