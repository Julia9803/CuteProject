package blservice.userblservice;

import VO.userVO.MessageVO;
import util.UserType;

public interface SendMessageService {
	public void sendMessage(MessageVO messagevo, UserType role);
}
