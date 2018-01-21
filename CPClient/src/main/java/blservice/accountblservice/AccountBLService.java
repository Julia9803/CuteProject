package blservice.accountblservice;

import java.util.List;

import VO.VIPVO.VIPVO;
import VO.accountVO.AccountVO;
import VO.accountVO.CashExpenseListVO;
import VO.accountVO.CollectionListVO;
import VO.accountVO.FinanceListVO;
import VO.accountVO.InitAccountVO;
import VO.accountVO.PaymentListVO;
import VO.goodsVO.GoodsVO;
import resultmessage.CommitListRM;
import resultmessage.DeleteListRM;
import resultmessage.ResultMessage;
import resultmessage.SaveListRM;
/**
 * 这个接口作为测试时的桩接口用
 * 实际没有用了
 * @author  julia98
 * @author  zxy			
 */
public interface AccountBLService extends FinanceListService{
	
	/*
	 * 期初建账相关
	 */
	
	//得到所有商品
	public List<GoodsVO> getGoodsInfo();
	
	//得到所有会员信息
	 public List<VIPVO> getVIPInfo();
	
	//保存期初建账信息
	 public ResultMessage saveInitAccountInfo(InitAccountVO vo);
	
	 /*
	  * 账户管理相关
	  */
	 
	//添加账户
	 public ResultMessage initAndSaveAccount(AccountVO vo);
	 
	//删除账户
	public ResultMessage deleteAccount(String name);
	
	//修改账户
	public ResultMessage modifyAccount(AccountVO vo);
	
	//得到所有账户信息
	@Override
	public List<AccountVO> findAccount();
	
	/*
	 * 单据相关
	 */
	
	//新建单据
	public String newPaymentList();
	public String newCollectionList();
	public String newCashExpenseList();
	
	//打开草稿单
	@Override
	public List<FinanceListVO> openDraft();
	public List<CollectionListVO> openCollectionDraft();
	public List<PaymentListVO> openPaymentDraft();
	public List<CashExpenseListVO> openCashExpenseDraft();
	
	//打开已提交单
	public List<FinanceListVO> openComitted();
	public List<PaymentListVO> openPaymentComitted();
	public List<CollectionListVO> openCollectionComitted();
	public List<CashExpenseListVO> openCashExpenseComitted();
	
	
	//保存单据
	public SaveListRM savePaymentList(PaymentListVO vo);
	public SaveListRM saveCollectionList(CollectionListVO vo);
	public SaveListRM saveCashExpenseList(CashExpenseListVO vo);
	
	
	//删除单据
	public DeleteListRM deletePaymentList(String id);
	public DeleteListRM deleteCollectionList(String id);
	public DeleteListRM deleteCashExpenseList(String id);
	
	//查找会员
	public List<VIPVO> findVIP(String info);
	
	//查找账户的方法上面已声明过
	
	//提交单据
	public CommitListRM commitPaymentList(PaymentListVO vo);
	public CommitListRM commitCollectionList(CollectionListVO vo);
	public CommitListRM commitCashExpenseList(CashExpenseListVO vo);
	
	
}