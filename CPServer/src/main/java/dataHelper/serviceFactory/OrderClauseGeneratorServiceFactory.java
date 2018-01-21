package dataHelper.serviceFactory;

import dataHelper.service.OrderClauseGenerator;
import dataHelper.serviceImpl.HibernateOrderClauseGenerator;

public class OrderClauseGeneratorServiceFactory {
	public static OrderClauseGenerator getService(){
		return new HibernateOrderClauseGenerator();
	}
}
