package bl.accountbl;

import java.util.ArrayList;
import java.util.List;

import VO.VIPVO.VIPVO;
import VO.accountVO.AccountVO;
import VO.accountVO.CashExpenseListVO;
import VO.accountVO.CollectionListVO;
import VO.accountVO.FinanceListVO;
import VO.accountVO.InitAccountVO;
import VO.accountVO.PaymentListVO;
import VO.accountVO.TransferItemVO;
import VO.goodsVO.GoodsVO;
import blservice.accountblservice.AccountBLService;
import blservice.accountblservice.AccountManagementService;
import resultmessage.ApproveRM;
import resultmessage.CommitListRM;
import resultmessage.DeleteListRM;
import resultmessage.ResultMessage;
import resultmessage.SaveListRM;
import util.State;

public class AccountBLService_Stub implements AccountBLService, AccountManagementService{
	
	protected static final GoodsVO goodsvo = null;
	protected static final VIPVO vipvo = null;
	protected static final AccountVO accountvo = new AccountVO("老张",10000);
	protected static final TransferItemVO transferItemvo = new TransferItemVO("老张",1000,"首付款");
	protected static final List<TransferItemVO> transferItemvoList = new ArrayList<TransferItemVO>();
	static {
		transferItemvoList.add(transferItemvo);
	}
	protected static final CollectionListVO collectionListvo = 
			new CollectionListVO("SKD-20171111-00011","007","大师","小王","小王的编号",transferItemvoList,1000,State.IsApproved);
	protected static final PaymentListVO paymentListvo = null;
	protected static final CashExpenseListVO cashExpenseListvo = null;
	protected static final String collectionListID = "SKD-20171111-00011";
	protected static final String paymentListID = "FKD-20171111-00011";
	protected static final String cashExpenseListID = "XJFYD-20171111-00011";
	
	@Override
	public List<GoodsVO> getGoodsInfo() {
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		list.add(goodsvo);
		return list;
	}

	@Override
	public List<VIPVO> getVIPInfo() {
		List<VIPVO> list = new ArrayList<VIPVO>();
		list.add(vipvo);
		return list;
	}

	@Override
	public ResultMessage saveInitAccountInfo(InitAccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage initAndSaveAccount(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteAccount(String name) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyAccount(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<AccountVO> findAccount() {
		List<AccountVO> list = new ArrayList<AccountVO>();
		list.add(accountvo);
		return list;
	}

	@Override
	public String newPaymentList() {
		return paymentListID;
	}

	@Override
	public String newCollectionList() {
		return collectionListID;
	}

	@Override
	public String newCashExpenseList() {
		return cashExpenseListID;
	}

	@Override
	public List<FinanceListVO> openDraft() {
		List<FinanceListVO> list = new ArrayList<FinanceListVO>();
		list.add(paymentListvo);
		list.add(collectionListvo);
		list.add(cashExpenseListvo);
		return list;
	}

	@Override
	public List<CollectionListVO> openCollectionDraft() {
		List<CollectionListVO> list = new ArrayList<CollectionListVO>();
		list.add(collectionListvo);		
		return list;
	}

	@Override
	public List<PaymentListVO> openPaymentDraft() {
		List<PaymentListVO> list = new ArrayList<PaymentListVO>();
		list.add(paymentListvo);
		return list;
	}

	@Override
	public List<CashExpenseListVO> openCashExpenseDraft() {
		List<CashExpenseListVO> list = new ArrayList<CashExpenseListVO>();
		list.add(cashExpenseListvo);
		return list;
	}

	@Override
	public List<FinanceListVO> openComitted() {
		return null;
	}

	@Override
	public List<PaymentListVO> openPaymentComitted() {
		return null;
	}

	@Override
	public List<CollectionListVO> openCollectionComitted() {
		List<CollectionListVO> list = new ArrayList<CollectionListVO>();
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);

		System.out.println(list.size());
		return list;
	}

	@Override
	public List<CashExpenseListVO> openCashExpenseComitted() {
		return null;
	}

	@Override
	public SaveListRM savePaymentList(PaymentListVO vo) {
		return SaveListRM.SUCCESS;
	}

	@Override
	public SaveListRM saveCollectionList(CollectionListVO vo) {
		return SaveListRM.SUCCESS;
	}

	@Override
	public SaveListRM saveCashExpenseList(CashExpenseListVO vo) {
		return SaveListRM.SUCCESS;
	}

	@Override
	public DeleteListRM deletePaymentList(String id) {
		return DeleteListRM.SUCCESS;
	}

	@Override
	public DeleteListRM deleteCollectionList(String id) {
		return  DeleteListRM.SUCCESS;
	}

	@Override
	public DeleteListRM deleteCashExpenseList(String id) {
		return  DeleteListRM.SUCCESS;
	}

	@Override
	public List<VIPVO> findVIP(String info) {
		List<VIPVO> list = new ArrayList<VIPVO>();
		list.add(vipvo);
		return list;
	}

	@Override
	public CommitListRM commitPaymentList(PaymentListVO vo) {
		return CommitListRM.SUCCESS;
	}

	@Override
	public CommitListRM commitCollectionList(CollectionListVO vo) {
		return CommitListRM.SUCCESS;
	}

	@Override
	public CommitListRM commitCashExpenseList(CashExpenseListVO vo) {
		return CommitListRM.SUCCESS;
	}

	@Override
	public String newList() {
		return collectionListID;
	}

	@Override
	public DeleteListRM delete(String id) {
		return DeleteListRM.SUCCESS;
	}

	@Override
	public SaveListRM save(FinanceListVO vo) {
		return SaveListRM.SUCCESS;
	}

	@Override
	public CommitListRM commit(FinanceListVO vo) {
		return CommitListRM.SUCCESS;
	}

	@Override
	public List<? extends FinanceListVO> openCommitted() {
		List<CollectionListVO> list = new ArrayList<CollectionListVO>();
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);
		list.add(collectionListvo);

		System.out.println(list.size());
		return list;
	}

	@Override
	public void endService() {
		
	}

	@Override
	public ApproveRM approve(FinanceListVO vo) {
		return null;
	}

	@Override
	public void reject(FinanceListVO vo) {
		
	}

	@Override
	public List<AccountVO> getAllAccount() {
		List<AccountVO> list = new ArrayList<AccountVO>();
		list.add(accountvo);
		return list;
	}

	@Override
	public void saveAllAccount(List<AccountVO> l) {
		
	}

	@Override
	public AccountVO getAccount(String accountName) {
		return null;
	}

	@Override
	public void update(AccountVO vo) {
		
	}

	@Override
	public FinanceListVO getList(String id) {
		return null;
	}
	
	
	
}