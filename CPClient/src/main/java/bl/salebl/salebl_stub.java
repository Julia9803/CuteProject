//package bl.salebl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import VO.VIPVO.VIPVO;
//import VO.goodsVO.GoodsVO;
//import VO.presentVO.PresentResultVO;
//import VO.saleVO.SaleListVO;
//import VO.saleVO.SaleReturnListVO;
//import VO.saleVO.SaleVO;
//import VO.saleVO.SalesmanListType;
//import VO.saleVO.SalesmanListVO;
//import VO.saleVO.StockListVO;
//import VO.saleVO.StockReturnListVO;
//import blservice.saleblservice.SaleBLService;
//import util.ResultMessage;
//
//public class salebl_stub implements SaleBLService{
//
//	List<SaleListVO> saleList = new ArrayList<SaleListVO>();
//	List<SaleReturnListVO> saleReturnList = new ArrayList<SaleReturnListVO>();
//	List<StockListVO> stockList = new ArrayList<StockListVO>();
//	List<StockReturnListVO> stockReturnList = new ArrayList<StockReturnListVO>();
//	List<SalesmanListVO> list = new ArrayList<SalesmanListVO>();
//	List<VIPVO> viplist = new ArrayList<VIPVO>();
//	List<GoodsVO> goods = new ArrayList<GoodsVO>();
//	
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleListBLService#createSaleList()
//	 */
//	@Override
//	public String createSaleList() {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleListBLService#openSaleDraftList()
//	 */
//	@Override
//	public List<SaleListVO> openSaleDraftList() {
//		// TODO Auto-generated method stub
//		return saleList;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleListBLService#saveSaleDraftList(VO.SaleListVO)
//	 */
//	@Override
//	public ResultMessage saveSaleDraftList(SaleListVO vo) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleListBLService#commitSaleList(VO.SaleListVO)
//	 */
//	@Override
//	public ResultMessage commitSaleList(SaleListVO vo) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleListBLService#findPresent(VO.SaleVO)
//	 */
//	@Override
//	public PresentResultVO findPresent(SaleVO vo) {
//		// TODO Auto-generated method stub
//		return new PresentResultVO();
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleReturnListBLService#createSaleReturnList()
//	 */
//	@Override
//	public String createSaleReturnList() {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleReturnListBLService#openSaleReturnDraftList()
//	 */
//	@Override
//	public List<SaleReturnListVO> openSaleReturnDraftList() {
//		// TODO Auto-generated method stub
//		return saleReturnList;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleReturnListBLService#saveSaleReturnDraftList(VO.SaleReturnListVO)
//	 */
//	@Override
//	public ResultMessage saveSaleReturnDraftList(SaleReturnListVO vo) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleReturnListBLService#commitSaleReturnList(VO.SaleReturnListVO)
//	 */
//	@Override
//	public ResultMessage commitSaleReturnList(SaleReturnListVO vo) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.StockBLService#createStockList()
//	 */
//	@Override
//	public String createStockList() {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.StockBLService#openStockDraftList()
//	 */
//	@Override
//	public List<StockListVO> openStockDraftList() {
//		// TODO Auto-generated method stub
//		return stockList;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.StockBLService#commitStockList(VO.StockListVO)
//	 */
//	@Override
//	public ResultMessage commitStockList(StockListVO vo) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.StockBLService#saveStockDraftList(VO.StockListVO)
//	 */
//	@Override
//	public ResultMessage saveStockDraftList(StockListVO vo) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.StockReturnBLService#createStockReturnList()
//	 */
//	@Override
//	public String createStockReturnList() {
//		// TODO Auto-generated method stub
//		return "0001";
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.StockReturnBLService#openStockReturnDraftList()
//	 */
//	@Override
//	public List<StockReturnListVO> openStockReturnDraftList() {
//		// TODO Auto-generated method stub
//		return stockReturnList;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.StockReturnBLService#saveStockReturnDraftList(VO.StockReturnListVO)
//	 */
//	@Override
//	public ResultMessage saveStockReturnDraftList(StockReturnListVO vo) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.StockReturnBLService#commitStockReturnList(VO.StockReturnListVO)
//	 */
//	@Override
//	public ResultMessage commitStockReturnList(StockReturnListVO vo) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleBLService#openDraftList()
//	 */
//	@Override
//	public List<SalesmanListVO> openDraftList() {
//		// TODO Auto-generated method stub
//		return list;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleBLService#findVIP(java.lang.String, java.lang.String)
//	 */
//	@Override
//	public List<VIPVO> findVIP(String info,SalesmanListType type) {
//		// TODO Auto-generated method stub
//		return viplist;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleBLService#findGoods(java.lang.String, java.lang.String)
//	 */
//	@Override
//	public List<GoodsVO> findGoods(String info) {
//		// TODO Auto-generated method stub
//		return goods;
//	}
//
//	/* (non-Javadoc)
//	 * @see blservice.saleblservice.SaleBLService#openCommitted()
//	 */
//	@Override
//	public List<SalesmanListVO> openCommitted() {
//		// TODO Auto-generated method stub
//		return list;
//	}
//
////	public ListInitVO createList(ListType type) {
////		// TODO Auto-generated method stub
////		ListInitVO vo = null;
////		return vo;
////	}
////
////	public Map<ListType, String> openDraftList() {
////		// TODO Auto-generated method stub
////		return null;
////	}
////
////	public SaleListVO openList(ListType t, String id) {
////		// TODO Auto-generated method stub
////		SaleListVO vo = null;
////	
////		return vo;
////	}
////
////	public void saveList(ListType type, SaleListVO vo) {
////		// TODO Auto-generated method stub
////		System.out.println("invoking succeed"+"- saveList");
////		
////	}
////
////	public void commitList(ListType type, SaleListVO vo) {
////		// TODO Auto-generated method stub
////		System.out.println("invoking succeed"+"- commitList");
////	}
////
////	public Map<String, String> searchMember(int id, String name) {
////		// TODO Auto-generated method stub
////		return null;
////	}
////
////	public VIPVO getMember(int id) {
////		// TODO Auto-generated method stub
////		VIPVO mv=new VIPVO("161250143", "wangruihua", "123456", "chairman");
////		return mv;
////	}
////
////	public Map<String, String> findGoods(String id, String name) {
////		// TODO Auto-generated method stub
////		return null;
////	}
////
////	public GoodsVO getGoods(String id) {
////		// TODO Auto-generated method stub
////		GoodsVO gv=new GoodsVO("小灯","X系列灯具","1","1","1",20,50,100,80);
////		return gv;
////	}
////
////	public SalePresentVO getPresent(SaleListVO vo) {
////		// TODO Auto-generated method stub
////		SalePresentVO sv=null;
////		return sv;
////	}
////
////	public double getTotal(ListType type, SaleListVO vo) {
////		// TODO Auto-generated method stub
////		return -1;
////	}
//
//	
//}
