package network;

import java.rmi.Remote;

public interface DataServiceHelper {
	public String getServiceName();		//这个seriviceName是服务端和客户端要遵守的协议，目前代码上没有办法进行限制
	
	public void setRemote(Remote remote);
}
