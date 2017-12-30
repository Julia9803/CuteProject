package PO;

import java.io.Serializable;

public class OperationPO implements Serializable{
     public String opID;//操作编号
     public String time ;//操作时间
     public String operator ;//操作员
     public String opCategory;//操作类型
     public String operation; //操作内容
   
     public OperationPO (String opID,String time,String operator,String opCategory,String operation){
    	 this.opID=opID;
    	 this.time=time;
    	 this.operator=operator;
    	 this.opCategory=opCategory;
    	 this.operation=operation;
    	 
     }
     
     

	public String getOpID() {
		return opID;
	}

	public void setOpID(String opID) {
		this.opID = opID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOpCategory() {
		return opCategory;
	}

	public void setOpCategory(String opCategory) {
		this.opCategory = opCategory;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
      
}
