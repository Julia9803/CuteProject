package network;

import java.rmi.Remote;

/**
 * 尴尬
 * 泛型类不能有静态的泛型变量，好像无法实现单件
 * 故此类暂时作废
 */
public class GeneralDataServiceHelper<T extends Remote>{
	private T dataService ;
	
	//此处应该为静态
	public GeneralDataServiceHelper<T> helper = new GeneralDataServiceHelper<T>();
	
	public static <T extends Remote> GeneralDataServiceHelper<T> getInstance(){
		return null;
	}
	
	private GeneralDataServiceHelper(){
	}
	
	public void setService(T service){
		dataService = service;
	}
	
	public T getDataService(){
		return dataService;
	}
	
}
