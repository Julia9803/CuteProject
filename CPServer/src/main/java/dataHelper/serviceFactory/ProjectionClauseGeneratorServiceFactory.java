package dataHelper.serviceFactory;

import dataHelper.service.ProjectionClauseGenerator;
import dataHelper.serviceImpl.HibernateProjectionClauseGenerator;

public class ProjectionClauseGeneratorServiceFactory {
	public static ProjectionClauseGenerator getService(){
		return new HibernateProjectionClauseGenerator();
	}
}
