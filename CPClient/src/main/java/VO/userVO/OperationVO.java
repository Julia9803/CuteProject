package VO.userVO;

public class OperationVO{
     public String opID;//操作编号
     public String time ;//操作时间
     public String operator ;//操作员
     public String opCategory;//操作类型
     public String operation; //操作内容
   
     public OperationVO (String opID,String time,String operator,String opCategory,String operation){
    	 this.opID=opID;
    	 this.time=time;
    	 this.operator=operator;
    	 this.opCategory=opCategory;
    	 this.operation=operation;
    	 
     }
}
