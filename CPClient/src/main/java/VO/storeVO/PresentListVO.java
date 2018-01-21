package VO.storeVO;

import java.util.ArrayList;

import util.State;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class PresentListVO {
   public ArrayList<String >id=new ArrayList<String >(); //赠品ID
   public String listID="";  //单据编号
   public ArrayList<Integer > num=new ArrayList<Integer >();//赠品数量
   public ArrayList<String >name =new ArrayList<String >();//赠品名字
   public String VIPname="" ; // 赠送的对象
   public State statetype=State.IsCommitted;
   
   public String time="";//操作时间
   public String operator="";//操作员
   
   public PresentListVO(String listID,ArrayList<String > id,ArrayList<Integer > num, ArrayList<String >name,String VIPname){
	   this.listID=listID;
	   this.id=id;
	   this.name=name;
	   this.num=num;
	   this.VIPname=VIPname;
   }
   public PresentListVO(){}
   
   public void setOperator(String s){
	   operator=s;
   }
   public void setTime(String s){
	   time=s;
   }
}
