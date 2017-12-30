package ui.stockmanUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import VO.storeVO.AlarmListVO;
import VO.storeVO.PresentListVO;
import VO.storeVO.ReportListVO;
import bl.storebl.StoreblController;
import blservice.storeblservice.StoreBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import util.State;
import util.StoreListType;

public class StoreListController {
//采取折中策略，先跳转，再加载。
	@ FXML Button findButton;
	@ FXML Button filter;
	@ FXML ComboBox<String> combobox;
	@ FXML TextField findTextField;
	@FXML Label typeLabel;
	@FXML VBox  vBox;
	
	StoreBLService storeblservice=new StoreblController();//持有库存接口
	State state=State.IsDraft;
	StoreListType type;
	
	public void set(StoreListType type){
         if(type.equals(StoreListType.ALARM)){
        	 typeLabel.setText("库存报警单");
        	 filter.setVisible(false);
        	 combobox.setVisible(false);
        	 loadAlarmWin();
         }else{
        	 if(type.equals(StoreListType.PRESENT)){
        		 typeLabel.setText("库存赠送单");
        		 loadPresentWin();
        	 }
        	 if(type.equals(StoreListType.OVERFLOW)){
        		 typeLabel.setText("库存报溢单");
        		 loadReportWin();
        	 }
        	 if(type.equals(StoreListType.LOSS)){
        		 typeLabel.setText("库存报损单");
        		 loadReportWin();
        	 }
        	 initCombobox();
         }
		this.type=type;
	}
	
	public void loadAlarmWin(){
		//加载库存报警单的界面
		LinkedList<AlarmListVO>  AlarmList_Arr=storeblservice.openAlarmList();
		for(AlarmListVO vo:AlarmList_Arr){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/stockmanUI/AlarmListItem.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vBox.getChildren().add(loader.getRoot());
            AlarmListItemController itemController=loader.getController();
            itemController.set(vo);
		}
	}
	
	public void loadPresentWin(){
		//加载赠送单的界面
		ArrayList<PresentListVO> PresentList_Arr=storeblservice.openPresentList(state);
		for(PresentListVO vo:PresentList_Arr){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/stockmanUI/PresentListItem.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vBox.getChildren().add(loader.getRoot());
			PresentListItemController itemController=loader.getController();
			itemController.set(vo);
			
		}
	}
	public  void loadReportWin(){
		//加载库存报告单的界面
		ArrayList<ReportListVO>ReportList_Arr=storeblservice.openReportList(type, state);
		for(ReportListVO vo:ReportList_Arr){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/stockmanUI/ReportListItem.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vBox.getChildren().add(loader.getRoot());
			ReportListItemController itemController=loader.getController();
			itemController.set(vo);
		}
	}
	
	protected void initCombobox(){
		//把状态筛选条件给初始化了。
		ArrayList<String> comboboxArr=new ArrayList<String>();
		comboboxArr.add("全部单据");
		comboboxArr.add("草稿单");
		comboboxArr.add("已提交单");
		comboboxArr.add("已过审单");
		comboboxArr.add("未过审单");
		combobox.getItems().addAll(comboboxArr);
	}
}
