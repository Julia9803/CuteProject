package dataHelper.serviceFactory;

import dataHelper.service.BasicUtil;
import dataHelper.serviceImpl.HibernateUtil;

public class BasicUtilServiceFactory {
	public static <T> BasicUtil<T> getService(Class<T> type){
		return new HibernateUtil<T>(type);
	}
}
