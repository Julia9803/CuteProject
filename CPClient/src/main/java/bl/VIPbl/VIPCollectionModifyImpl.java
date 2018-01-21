package bl.VIPbl;

import java.rmi.RemoteException;

import VO.VIPVO.VIPVO;
import blservice.VIPblservice.VIPBLService;
import blservice.VIPblservice.VIPCollectionModify;
import resultmessage.ResultMessage;

/**
 * Created by julia98 on 2018/1/1.
 */
public class VIPCollectionModifyImpl implements VIPCollectionModify {
    VIPBLService vipblService = new VIPBLServiceImpl();

    @Override
    public ResultMessage setVIPCollection(String vipName, double collection) throws RemoteException {
        VIPVO vipvo = vipblService.getVIP(vipName);
        vipvo.setCollection(collection);
        vipblService.modifyVIP(vipvo);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage setVIPPayment(String vipName, double payment) throws RemoteException {
        VIPVO vipvo = vipblService.getVIP(vipName);
        vipvo.setPayment(payment);
        vipblService.modifyVIP(vipvo);
        return ResultMessage.SUCCESS;
    }

    @Override
    public double getVIPCollection(String vipName) throws RemoteException {
        VIPVO vipvo = vipblService.getVIP(vipName);
        return vipvo.getCollection();
    }

    @Override
    public double getVIPPayment(String vipName) throws RemoteException {
        VIPVO vipvo = vipblService.getVIP(vipName);
        return vipvo.getPayment();
    }

    @Override
	public double checkVIPCollectionLimit(String vipName) throws RemoteException {
		VIPVO vipvo = vipblService.getVIP(vipName);
		return vipvo.getCollectionLimit();
	}
}
