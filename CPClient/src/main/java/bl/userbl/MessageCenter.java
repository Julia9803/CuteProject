package bl.userbl;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import PO.user.MessagePO;
import VO.userVO.MessageVO;
import blservice.userblservice.CheckMessageService;
import blservice.userblservice.SendMessageService;
import dataService.userDataService.MessageDataService;
import network.userRemoteHelper.MessageDataServiceHelper;
import util.UserType;

public class MessageCenter implements SendMessageService, CheckMessageService{

	MessageDataService service = MessageDataServiceHelper.getInstance().getDataService();
	@Override
	public void sendMessage(MessageVO vo, UserType type) {
		try {
			service.insert(new MessagePO(vo.getTitle(),vo.getContent(),vo.getDate(),type));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MessageVO> checkMessage(UserType type) {
		try {
			List<MessagePO> poList = service.getAllMessage(type);
			return poList.stream()
				.map(e -> new MessageVO(e.getTitle(),e.getContent(),e.getDate()))
				.collect(Collectors.toList());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
