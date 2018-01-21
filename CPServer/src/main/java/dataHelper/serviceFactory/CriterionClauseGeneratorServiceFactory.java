package dataHelper.serviceFactory;

import dataHelper.service.CriterionClauseGenerator;
import dataHelper.serviceImpl.HibernateCriterionClauseGenerator;

public class CriterionClauseGeneratorServiceFactory {
	public static CriterionClauseGenerator getService(){
		return new HibernateCriterionClauseGenerator();
	}
}
