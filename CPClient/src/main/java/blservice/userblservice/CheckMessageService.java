package blservice.userblservice;

import java.util.List;

import VO.userVO.MessageVO;
import util.UserType;

public interface CheckMessageService {
	public List<MessageVO> checkMessage(UserType type);
}
