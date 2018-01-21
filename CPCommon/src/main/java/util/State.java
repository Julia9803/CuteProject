package util;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description 单据状态
*/
public enum State implements Serializable{
	IsDraft(0,"草稿单"),
	IsCommitted(1,"已提交"),
	IsApproved(2,"已通过审批"),
	IsRefused(3,"已拒绝"),
	IsEditting(4,"编辑中"),
	IsDeleted(5,"已删除");
	
	private final int state;
	private final String stateName;
	
	State(int state, String name){
		this.state = state;
		this.stateName = name;
	}
	
	public int getState(){
		return state;
	}

	public String getStateName() {
		return stateName;
	}
	
	@Override
	public String toString(){
		return stateName;
	}
	
	
}
