package PO;

import java.io.Serializable;
import java.util.Date;

import util.State;

/**     
* @author 李安迪
* @date 2017年10月27日 
* @date 2017\12\25
* @description 单据类继承的抽象类
* 
*/
public class ListPO implements Serializable{
	
	private static final long serialVersionUID = 6571259727395966114L;
	/**
	 * 单据编号
	 */
	private String id = "";
	/**
	 * 操作员名称
	 */
	private String operator;
	/**
	 * 操作员编号
	 */
	private String operatorId;

	/**
	 * 单据状态
	 */
	private State state;

	/**
	 * 日期
	 */
	private Date day;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public ListPO(){};
	public ListPO(String id, String operator, String operatorId, State state, Date day) {
		super();
		this.id = id;
		this.operator = operator;
		this.operatorId = operatorId;
		this.state = state;
		this.day = day;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListPO other = (ListPO) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (operatorId == null) {
			if (other.operatorId != null)
				return false;
		} else if (!operatorId.equals(other.operatorId))
			return false;
		if (state != other.state)
			return false;
		return true;
	}

	
	
}
