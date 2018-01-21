package ui.stockmanUI;



import VO.listVO.ListRM;
import VO.storeVO.ReportListVO;
import VO.storeVO.StoreVO;
import bl.storebl.StoreblController;
import blservice.storeblservice.StoreBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.mainUI.loginUI.User;
import util.State;
import util.StoreListType;


public class ReportListController {

	/*
	 * 库存报溢单/报损单的Controller,有四种初始化状态
	 * 第一种，在查看草稿单时打开
	 * 第二种，在新建时打开
	 * 第三种，在总经理查看审批时打开
	 * 第四种，在财务人员查看审批时打开
	 */
	@FXML Label listID;
	@FXML TextField goodsID;
	@FXML Label operator;
	@FXML Label time;
    @FXML  Label goodsName;
	@FXML  Label num;
	@FXML  Label delta;
	@FXML Label deltaLabel;
    @FXML Label title;
	@FXML Label rm;
	@FXML Button GoodsInfoBtn;
	@ FXML TextField actualNum;
	@ FXML Button btn1;
    @ FXML Button btn2;
    @ FXML Button btn3;
    State state ;
    StoreListType type;
    StoreBLService service=new StoreblController();
    ReportListVO vo;

    @FXML public void Action1(){
         if(state.equals(State.IsEditting)){
        	ListRM listrm= save();
        	 if(listrm.equals(ListRM.SUCCESS)){
        		 rm.setText("保存成功");
        	 }else{
        		 if(listrm.equals(ListRM.REFUSED)){rm.setText("数据格式不正确");}
        		 rm.setText("保存失败");
        	 }
         }
    }

    @FXML public void Action2(){
    	if(state.equals(State.IsEditting)){
    		ListRM listrm=commit();
       	 if(listrm.equals(ListRM.SUCCESS)){
    		 rm.setText("提交成功");
    	 }else{
    		 if(listrm.equals(ListRM.REFUSED)){rm.setText("数据格式不正确");}
    		 rm.setText("提交失败");
    	 }
        }
    }

    @FXML public void Action3(){

    }

    @FXML public void getGoodsInfo(){
    	StoreVO storeVO=service.getStoreVO(goodsID.getText());
       if(storeVO!=null){
    	   num.setText(Integer.toString(storeVO.Num));
    	   goodsName.setText(storeVO.name);
    	   
       }else{
    	   rm.setText("该商品不存在！");
       }
    }

    public void set(StoreListType type, State state){
        setType(type);
        setState(state);
        rm.setText("");
    }

    private   void setType(StoreListType type){
    	this.type=type;
        if(type.equals(StoreListType.OVERFLOW)){
            title.setText("库存报溢单");
            deltaLabel.setText("报溢数量");
        }else {
            title.setText("库存报损单");
            deltaLabel.setText("报损数量");
        }

    }

    private   void setState(State state){
    	this.state=state;
        if(state.equals(State.IsEditting)){
            delta.setVisible(false);
            deltaLabel.setVisible(false);
            btn1.setText("保存");
            btn2.setText("提交");//实际上是保存并提交
            btn3.setText("取消");
            btn3.setVisible(false);
            vo=new ReportListVO();
            vo.listID=service.newList(type);
            listID.setText(vo.listID);
            vo.operator=User.getInstance().getUserName();
            operator.setText(vo.operator);
            vo.st=type;
            
            vo.time=User.calcTime();
            time.setText(vo.time);
          
        }

    }
    
    private ListRM save(){
    	fillVO();
    	if(vo.st.equals(StoreListType.LOSS)){
    		if(vo.actualNum<0||vo.actualNum>=vo.Num){
    			return ListRM.REFUSED;
    		}
    	}else if(vo.st.equals(StoreListType.OVERFLOW)){
    		if(vo.actualNum<=vo.Num){
    			return ListRM.REFUSED;
    		}
    	}
    	vo.statetype=State.IsDraft;
    	return service.saveReportList(vo);
    	
     }
    
    private ListRM commit(){
    
    	if(save().equals(ListRM.SUCCESS)){
    	return service.commit(type, vo.listID);
    	}else{return ListRM.REFUSED;}
    }
    
    private void fillVO(){
    	vo.actualNum=Integer.parseInt(actualNum.getText());
    	vo.GoodsName=goodsName.getText();
    	vo.goodsID=goodsID.getText();
    	vo.Num=Integer.parseInt(num.getText());
    	if(vo.st.equals(StoreListType.OVERFLOW)){
    		vo.delta=vo.actualNum-vo.Num;
    	}else{
    		vo.delta=vo.Num-vo.actualNum;
    	}
    }
    
    public void set(ReportListVO vo){
    	setType(vo.st);
    	setState(State.IsEditting);
    	actualNum.setText(Integer.toString(vo.actualNum));
    	goodsName.setText(vo.GoodsName);
    	goodsID.setText(vo.goodsID);
    	num.setText(Integer.toString(vo.Num));
    	
    }
    



}
