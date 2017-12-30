package network;

/**
 * 在这写一下说明
 * 同一个包可能有多个dataservice，每个dataservice写一个helper类，然后在{@see ServerConnector}中建立连接。
 * bl层在需要服务时就找对应的remotehelper就行了，具体找他是直接要服务还是通过一个工厂要服务就可以自行发挥了。
 * 
 * @author zxy
 * 
 */
public @interface ReadMeAboutRMI {

}
