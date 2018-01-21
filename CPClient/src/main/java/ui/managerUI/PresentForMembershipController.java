package ui.managerUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

import VO.GoodsInSaleVO;
import VO.goodsVO.GoodsVO;
import VO.presentVO.PresentForMembershipVO;
import VO.presentVO.PresentVO;
import bl.goodsbl.GoodsFuzzySearchImpl;
import bl.presentbl.PresentBLFactory;
import bl.utility.GoodsVOTrans;
import blservice.goodsblservice.GoodsFuzzySearch;
import blservice.presentblservice.PresentForMembershipBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import resultmessage.DataRM;
import ui.commonUI.GoodsSearchResultWin;
import ui.commonUI.PromptHelper;
import util.DateUtil;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description
*/
public class PresentForMembershipController implements SinglePresentEditableController{
		
		@FXML protected Button cancelBtn;
		@FXML protected Button saveBtn;
		
		@FXML protected TextField searchField;
		@FXML protected Button searchBtn;
		@FXML protected VBox presentListVBox;
		
		@FXML protected TextField startYearField;
	    @FXML protected TextField startMonthField;
	    @FXML protected TextField startDayField;
	    @FXML protected TextField finishYearField;
	    @FXML protected TextField finishMonthField;
	    @FXML protected TextField finishDayField;

	    @FXML protected TextField totalField;
	    @FXML protected TextField voucherField;
	    @FXML protected TextField rebateField;
	    
	    @FXML protected ChoiceBox<String> gradeChoiceBox;
	    
	    @FXML protected Label nullErrorMessage;
	    @FXML protected Label dateErrorMessage;
	    @FXML protected Label totalErrorMessage;
	    @FXML protected Label voucherErrorMessage;
	    @FXML protected Label rebateErrorMessage;
	    
	    private static final String nullError = "请填写所有字段";
	    private static final String dateError = "日期格式错误";
	    private static final String totalError = "总额格式错误";
	    private static final String voucherError = "赠券金额格式错误";
	    private static final String rebateError = "折让金额格式错误";
	    
	    protected List<TextField> textFieldList;
	    
	    private static final String numberError = "商品数量数字格式错误";
	    protected List<PresentEditCellController> controllerList;

	    
	    private PresentForMembershipBLService service;
	    private Strategy strategy;
	    private GoodsFuzzySearch fuzzySearch;
	    
	    //暂存vo，传递给strategy
	    private PresentVO vo;
	    @FXML private ManagerController managerController;
        
		/**
         * 界面保存但不显示策略id
         */
        int id;
//        
//    	/**
//    	 *开始时间
//    	 */	
//    	Date startTime;
//    	/**
//    	 *结束时间
//    	 */	
//    	Date finishTime;
//    	/**
//    	 * 总额
//    	 */
//    	double total;
    	/**
    	 *赠品列表,临时作为静态变量保证程序不崩
    	 */	
    	List<GoodsInSaleVO> presentList;
    	/**
    	 * 待选择的商品列表
    	 */
    	List<GoodsInSaleVO> goodsList;
//    	/**
//    	 * 赠送代金券金额
//    	 */
//    	double voucher;
//       
//	    public void setManagerController(ManagerController managerController){
//	    	this.managerController = managerController;
//	    }
    	
       
        
        public PresentForMembershipBLService getService() {
			return service;
		}

		public void setService(PresentForMembershipBLService service) {
			this.service = service;
		}
		
	    public ManagerController getManagerController() {
			return managerController;
		}

		public void setManagerController(ManagerController managerController) {
			this.managerController = managerController;
		}

		public Strategy getStrategy() {
			return strategy;
		}

		public void setStrategy(Strategy strategy) {
			this.strategy = strategy;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

//		public Date getStartTime() {
//			return startTime;
//		}
//
//		public void setStartTime(Date startTime) {
//			this.startTime = startTime;
//		}
//
//		public Date getFinishTime() {
//			return finishTime;
//		}
//
//		public void setFinishTime(Date finishTime) {
//			this.finishTime = finishTime;
//		}
//
//		public double getTotal() {
//			return total;
//		}
//
//		public void setTotal(double total) {
//			this.total = total;
//		}
		@Override
		public void addToPresentList(GoodsInSaleVO vo){
			boolean dup = false;
				for(GoodsInSaleVO v : presentList){
					if(v.getId().equals(vo.getId())){
						v.setAmount(v.getAmount()+vo.getAmount());
						dup = true;
						break;
					}
				}
				if(!dup)
				this.presentList.add(vo);
//				this.presentList = new ArrayList<GoodsInSaleVO>(new LinkedHashSet<GoodsInSaleVO>(this.presentList));
				this.refresh();
				System.out.println(this.presentList);
		}
		@Override
		public void deleteFromPresentList(GoodsInSaleVO vo){
			this.presentList.remove(vo);
			this.refresh();
		}
		@Override
		public List<GoodsInSaleVO> getPresentList() {
			return presentList;
		}
//
		@Override
		public void setPresentList(List<GoodsInSaleVO> presentList) {
			this.presentList = presentList;
			this.refresh();
		}
//
//		public double getVoucher() {
//			return voucher;
//		}
//
//		public void setVoucher(double voucher) {
//			this.voucher = voucher;
//		}

		public PresentForMembershipController(Strategy strategy,ManagerController managerController){
			this.strategy = strategy;
			this.managerController = managerController;
			this.vo = null;
	    	service = PresentBLFactory.getPresentForMembershipBLService();
	    	fuzzySearch = new GoodsFuzzySearchImpl();
	    	this.goodsList = new ArrayList<GoodsInSaleVO>();
	    	this.presentList = new ArrayList<GoodsInSaleVO>();
	    	this.controllerList = new ArrayList<PresentEditCellController>();

		}
		public PresentForMembershipController(Strategy strategy,ManagerController managerController,PresentVO vo){
			this.strategy = strategy;
			this.managerController = managerController;
			this.vo = vo;
	    	service = PresentBLFactory.getPresentForMembershipBLService();
	    	fuzzySearch = new GoodsFuzzySearchImpl();
	    	this.goodsList = new ArrayList<GoodsInSaleVO>();
	    	this.presentList = new ArrayList<GoodsInSaleVO>();
	    	this.controllerList = new ArrayList<PresentEditCellController>();

		}		
		@Override
		@FXML
	    public void initialize(){
	    	
	    	System.out.println("init");
	    	
	    	textFieldList = new ArrayList<TextField>();
	    	//加入文本框列表
	    	textFieldList.add(startYearField);
	    	textFieldList.add(startMonthField);
	    	textFieldList.add(startDayField);
	    	textFieldList.add(finishYearField);
	    	textFieldList.add(finishMonthField);
	    	textFieldList.add(finishDayField);
	    	textFieldList.add(totalField);
	    	textFieldList.add(voucherField);
	    	textFieldList.add(rebateField);
	    	
	    	//初始化数值
	    	strategy.initData(this, vo);
	    	
	    	//把vo清空
	    	vo = null;
	    	
	    
	    }
				
		@FXML
		@Override
		public void save(){
			System.out.println("save presentForSum");
			/**
			 * 检查合法性
			 */
		    //清空提示信息
		    nullErrorMessage.setText("");
		    dateErrorMessage.setText("");
		    totalErrorMessage.setText("");
		    voucherErrorMessage.setText("");
		    
			//检查非空字段
		    for(TextField f:textFieldList){
//		    	System.out.println(f);
//		    	assert(f != null);
		    	String s = f.getText();
		    	if(s == null || s.length() == 0){
		    		nullErrorMessage.setText(nullError);
		    		return;	
		    	}
		    }

			//检查日期合法性
		    Date startTime = new Date();
		    Date finishTime = new Date();
			try{
		
			startTime = DateUtil.getDate(Integer.parseInt(startYearField.getText()),
					Integer.parseInt(startMonthField.getText()),Integer.parseInt(startDayField.getText()));
			finishTime = DateUtil.getDate(Integer.parseInt(finishYearField.getText()),
					Integer.parseInt(finishMonthField.getText()),Integer.parseInt(finishDayField.getText()));
			}catch(Exception e){
				dateErrorMessage.setText(dateError);
				System.out.println("can not convert to date");
				return;
			}
			
			if(!DateUtil.validStartAndFinish(startTime, finishTime))
			{
				dateErrorMessage.setText(dateError);
				System.out.println(startTime);
				System.out.println(finishTime);
				System.out.println("not valid start and finish");
				return;
			}
			//检查总额合法性
			String totalInString = totalField.getText();
			double total = 0;
			
			try{
//				if(!NumberUtil.isNotNegative(totalInString)){
//					totalErrorMessage.setText(totalError);
//					
//					return;
//				}else{
//					
//				}
					total = Double.parseDouble(totalInString);
				}catch(Exception e){
					totalErrorMessage.setText(totalError);
					return;
				}
			//检查赠券金额合法性
			String voucherInString = voucherField.getText();
			double voucher = 0;
			try{
//				if(!NumberUtil.isNotNegative(totalInString)){
//					totalErrorMessage.setText(totalError);
//					
//					return;
//				}else{
//					
//				}
					voucher = Double.parseDouble(voucherInString);
				}catch(Exception e){
					voucherErrorMessage.setText(voucherError);
					return;
				}

			//检查折让金额合法性
			String rebateInString = rebateField.getText();
			double rebate = 0;
			try{
//				if(!NumberUtil.isNotNegative(totalInString)){
//					totalErrorMessage.setText(totalError);
//					
//					return;
//				}else{
//					
//				}
					rebate = Double.parseDouble(rebateInString);
				}catch(Exception e){
					rebateErrorMessage.setText(rebateError);
					return;
				}
			//检查赠品清单合法性
			presentList.clear();
			for(PresentEditCellController c :controllerList){
				//更新vo数量
				c.vo.setAmount(Integer.parseInt(c.amount.getText()));
				presentList.add(c.vo);
				if(!c.isValid())
				{
					nullErrorMessage.setText(numberError);
					return;
				}
			}
			
			//检查会员等级合法性
			VIPGrade vipGrade = VIPGrade.getVIPGradeByString(gradeChoiceBox.getValue());
			
			//打包成vo
			PresentForMembershipVO vo = new PresentForMembershipVO(id,startTime, finishTime,vipGrade, total, presentList,voucher, rebate);
			
			//确认操作
			
			if(showConfirmDialog()){
			//传递vo到逻辑层	
			DataRM rm = service.save(vo);
			//显示信息弹窗
			PromptHelper.showPrompt(rm);
			//回到主界面
			back();
			}
		}
		//确认
		@Override
		public boolean showConfirmDialog(){
			System.out.println("confirming");
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,"确认此项操作？");
		    Optional<ButtonType> result = confirmation.showAndWait();
		    if(result.isPresent() && result.get() == ButtonType.OK){
		        return true;
		     }
		    else{
		    	return false;
		     }
		}
		//回到主界面
		@Override
		public void back(){
			managerController.centerPane.setCenter(null);
		}
		@FXML
		public void cancel(){
			System.out.println("cancel presentForSum");
			if(showConfirmDialog()){
				DataRM rm = strategy.cancel(this);
				//显示处理信息
				PromptHelper.showPrompt(rm);
				back();
			}
		}

		@FXML
		@Override
		public void search(){

			//获得关键字
			String pref = searchField.getText();
			String message = "";
			if(pref != null)
				message = pref;

			//查找，分别用三种模糊查找，然后合并得到的商品列表结果
			List<GoodsVO> temp = new ArrayList<GoodsVO>();
			List<GoodsVO> adder = new ArrayList<GoodsVO>();
			try{
			if((adder = fuzzySearch.getGoodsInID(message))!= null)
					temp.addAll(adder);
			if((adder = fuzzySearch.getGoodsInGoodsName(message))!= null)
				temp.addAll(adder);
			if((adder = fuzzySearch.getGoodsInCategory(message))!= null)
				temp.addAll(adder);
			}catch(Exception e){
				PromptHelper.showPrompt(DataRM.NET_FAILED);
			}
			//去重
			temp = new ArrayList<GoodsVO>(new LinkedHashSet<>(temp));
			
			goodsList = GoodsVOTrans.GoodsTransGoodsInSaleInList(temp);
			
//			List<GoodsInSaleVO> listById = GoodsTransGoodsInSale.GoodsTransGoodsInSaleInList(fuzzySearch.getGoodsInID(message));
//			List<GoodsInSaleVO> listByName = GoodsTransGoodsInSale.GoodsTransGoodsInSaleInList(fuzzySearch.getGoodsInGoodsName(message));
//			List<GoodsInSaleVO> listByCategory = GoodsTransGoodsInSale.GoodsTransGoodsInSaleInList(fuzzySearch.getGoodsInCategory(message));
//			goodsList.addAll(listById);
//			goodsList.addAll(listByName);
//			goodsList.addAll(listByCategory);
//			//去重
//			goodsList = new ArrayList<GoodsInSaleVO>(new LinkedHashSet<>(goodsList));
			System.out.println(goodsList);
			
			try {
				new GoodsSearchResultWin(goodsList,this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			}

		
		
		


		/* (non-Javadoc)
		 * @see ui.managerUI.SinglePresentController#refresh()
		 */
		@Override
		public void refresh() {
			presentListVBox.getChildren().clear();
			controllerList.clear();
			// TODO Auto-generated method stub
			for(GoodsInSaleVO vo : presentList){
	   		 PresentEditCellController controller = 
	   				    new PresentEditCellController(this,vo);
	   		 controllerList.add(controller);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        "/fxml/managerUI/PresentCell.fxml"));
	   				loader.setController(controller);
	   				AnchorPane presentroot = null;
					try {
						presentroot = loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(presentroot == null)
						System.out.println("presentroot is null");
					if(presentListVBox == null)
						System.out.println("presentListVBox is null");
//		    	AnchorPane presentroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/PresentForSum.fxml"));
				presentListVBox.getChildren().add(presentroot);
			}
		}	
}