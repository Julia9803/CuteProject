package blservice.serviceFactory;

import bl.userbl.AdministratorServiceImpl;
import bl.userbl.PersonalInfoServiceImpl;
import blservice.userblservice.AdministratorService;
import blservice.userblservice.PersonalInfoService;

public class UserBLFactory {
	public static AdministratorService getAdministratorService(){
		return new AdministratorServiceImpl();
	}
	
	public static PersonalInfoService getPersonalInfoService(){
		return new PersonalInfoServiceImpl();
	}
}
