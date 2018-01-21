package network.userRemoteHelper;

import java.rmi.Remote;

import dataService.userDataService.MessageDataService;
import network.DataServiceHelper;

public class MessageDataServiceHelper implements DataServiceHelper{
	private MessageDataService messageDataService ;
	private static final String serviceName = "MessageDataService";
	
	private static MessageDataServiceHelper messageRemoteHelper = new MessageDataServiceHelper();
	public static MessageDataServiceHelper getInstance(){
		return messageRemoteHelper;
	}
	
	private MessageDataServiceHelper(){
	}
	
	@Override
	public String getServiceName(){
		return serviceName;
	}
	
	@Override
	public void setRemote(Remote remote){
		messageDataService = (MessageDataService)remote;
	}
	
	public MessageDataService getDataService(){
		return messageDataService;
	}
	
}
