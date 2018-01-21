package blservice.serviceFactory;

import bl.userbl.MessageCenter;
import blservice.userblservice.CheckMessageService;
import blservice.userblservice.SendMessageService;

public class MessageServiceFactory {
	public static SendMessageService getSendMessageService(){
		return new MessageCenter();
	}
	
	public static CheckMessageService getCheckMessageService(){
		return new MessageCenter();
	}
}
