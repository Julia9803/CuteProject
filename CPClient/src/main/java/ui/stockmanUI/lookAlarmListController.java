package ui.stockmanUI;

import VO.storeVO.AlarmListVO;
import bl.storebl.StoreblController;
import blservice.storeblservice.StoreBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.LinkedList;

public class lookAlarmListController {
    @FXML public Label listID1;
    @FXML public Label listID2;
    @FXML public Label num1;
    @FXML public Label num2;
    @FXML public Label goodsID1;
    @FXML public Label goodsID2;
    @FXML public Label alarm1;
    @FXML public Label alarm2;
    @FXML public Label name1;
    @FXML public Label name2;
    @FXML public Label InfoLabel;
    @FXML public Button nextPage;
    @FXML public Button backPage;
    @FXML public Button delete1;
    @FXML public Button delete2;
    @FXML public Pane pane1;
    @FXML public Pane pane2;
    LinkedList<AlarmListVO> al=new LinkedList<AlarmListVO>();
    StoreBLService blService=new StoreblController();
    int alpointer=0;
    private void refresh(){
       // al=blService.openAlarmList();
    }
    private void deleteAlarmListVO(AlarmListVO vo){
        //删除一张报警单
        //blService.deleteAlarmList( vo);
//        init();

    }
    
    @FXML
    private void initialize(){
        //初始化界面数据
        refresh();
        if(al.size()-alpointer==0){
            System.out.println(pane1==null);
        	pane1.setVisible(false);
            
            pane2.setVisible(false);
        }else if(al.size()-alpointer==1){
            pane1.setVisible(true);
            listID1.setText(al.get(alpointer).listID);
            name1.setText(al.get(alpointer).goodsName);
            goodsID1.setText(al.get(alpointer).goodsID);
            num1.setText(Integer.toString(al.get(alpointer).currentNum));
            alarm1.setText(Integer.toString(al.get(alpointer).alarmNum));

            pane2.setVisible(false);

        }else if(al.size()-alpointer>=2){
            pane1.setVisible(true);
            listID1.setText(al.get(alpointer).listID);
            name1.setText(al.get(alpointer).goodsName);
            goodsID1.setText(al.get(alpointer).goodsID);
            num1.setText(Integer.toString(al.get(alpointer).currentNum));
            alarm1.setText(Integer.toString(al.get(alpointer).alarmNum));

            pane2.setVisible(true);
            listID2.setText(al.get(alpointer).listID);
            name2.setText(al.get(alpointer).goodsName);
            goodsID2.setText(al.get(alpointer).goodsID);
            num2.setText(Integer.toString(al.get(alpointer).currentNum));
            alarm2.setText(Integer.toString(al.get(alpointer).alarmNum));
        }


    }

     public lookAlarmListController(){
//        init();  //构造方法，界面自动初始化
//         InfoLabel.setText("");
     }
     @FXML
    public void toNext(){
        if(al.size()-alpointer<=2){
            //这时没有下一页
            InfoLabel.setText("没有下一页了哦！");
        }else{
            alpointer+=2;
            initialize();
            InfoLabel.setText("");
        }
     }

     @FXML
     public void goBack(){
          if(alpointer<=2){
              //这时没有上一页
              InfoLabel.setText("没有上一页了哦！");
          }else{
              alpointer-=2;
              initialize();
              InfoLabel.setText("");
          }
     }
     @FXML
     public void delete1(){
         deleteAlarmListVO(al.get(alpointer));
         InfoLabel.setText("");
     }
    @FXML
    public void delete2(){
         deleteAlarmListVO(al.get(alpointer+1));
        InfoLabel.setText("");
    }


}
