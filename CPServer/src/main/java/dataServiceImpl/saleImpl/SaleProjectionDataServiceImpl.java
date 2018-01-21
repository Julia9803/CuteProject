package dataServiceImpl.saleImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import PO.SaleListPO;
import PO.SaleReturnListPO;
import PO.StockListPO;
import PO.StockReturnListPO;
import dataHelper.service.BasicUtil;
import dataHelper.service.ProjectionClauseGenerator;
import dataHelper.serviceImpl.HibernateProjectionClauseGenerator;
import dataHelper.serviceImpl.HibernateUtil;
import dataHelper.serviceImpl.ProjectionClause;
import dataService.saleDataService.SaleProjectionDataService;

/**     
* @author 李安迪
* @date 2017年12月28日
* @description
*/
public class SaleProjectionDataServiceImpl extends UnicastRemoteObject implements SaleProjectionDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5462307776539975797L;
	BasicUtil<SaleListPO> saleListUtil;
	BasicUtil<SaleReturnListPO> saleReturnListUtil;
	BasicUtil<StockListPO> stockListUtil;
	BasicUtil<StockReturnListPO> stockReturnListUtil;
	
	ProjectionClauseGenerator projectionClauseGenerator;

	/**
	 * @throws RemoteException
	 */
	public SaleProjectionDataServiceImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
		saleListUtil = new HibernateUtil<SaleListPO>(SaleListPO.class);
		saleReturnListUtil = new HibernateUtil<SaleReturnListPO>(SaleReturnListPO.class);
		stockListUtil = new HibernateUtil<StockListPO>(StockListPO.class);
		stockReturnListUtil = new HibernateUtil<StockReturnListPO>(StockReturnListPO.class);

		projectionClauseGenerator = new HibernateProjectionClauseGenerator();
	}



	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleProjectionDataService#getSalesIncome()
	 */
	@Override
	public double getSalesIncome() throws RemoteException {
		// TODO Auto-generated method stub
		ProjectionClause p = projectionClauseGenerator.calSum("sum");
		return saleListUtil.Projection(p);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleProjectionDataService#getSalesDiscount()
	 */
	@Override
	public double getSalesDiscount() throws RemoteException {
		// TODO Auto-generated method stub
		ProjectionClause p = projectionClauseGenerator.calSum("rebate");
		return saleListUtil.Projection(p);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleProjectionDataService#getSalesReturnOutcome()
	 */
	@Override
	public double getSalesReturnOutcome() throws RemoteException {
		// TODO Auto-generated method stub
		ProjectionClause p = projectionClauseGenerator.calSum("sum");
		return saleReturnListUtil.Projection(p);

	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleProjectionDataService#getStockReturnIncome()
	 */
	@Override
	public double getStockReturnIncome() throws RemoteException {
		// TODO Auto-generated method stub
		ProjectionClause p = projectionClauseGenerator.calSum("sum");
		return stockReturnListUtil.Projection(p);

	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleProjectionDataService#getStockOutcome()
	 */
	@Override
	public double getStockOutcome() throws RemoteException {
		// TODO Auto-generated method stub
		ProjectionClause p = projectionClauseGenerator.calSum("sum");
		return stockListUtil.Projection(p);
	}

}
