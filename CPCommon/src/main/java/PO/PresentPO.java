package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.PresentState;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class PresentPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2942592583007803647L;

	/**
	 * 
	 */
	

	/**
	 * 策略编号
	 */
	int id;
	
	/**
	 *开始时间
	 */	
	Date startTime;
	/**
	 *结束时间
	 */	
	Date finishTime;
	/**
	 *赠品列表,或者特价包中特价商品
	 */	
	List<GoodsInSalePO> presentList;

	PresentState state = PresentState.EDIT;
public PresentState getState() {
		return state;
	}


	public void setState(PresentState state) {
		this.state = state;
	}


	//	public PresentPO(String id, Date startTime, Date finishTime) {
//		super();
//		this.id = id;
//		this.startTime = startTime;
//		this.finishTime = finishTime;
//	}
	public PresentPO(){
	}
	


	public PresentPO(int id, Date startTime, Date finishTime, List<GoodsInSalePO> presentList, PresentState state) {
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.presentList = presentList;
		this.state = state;
	}


	public List<GoodsInSalePO> getPresentList() {
		return presentList;
	}
	public void setPresentList(List<GoodsInSalePO> presentList) {
		this.presentList = presentList;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getStartTime() {
		return startTime;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finishTime == null) ? 0 : finishTime.hashCode());
		result = prime * result + ((presentList == null) ? 0 : presentList.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		PresentPO other = (PresentPO) obj;
		if (finishTime == null) {
			if (other.finishTime != null)
				return false;
		} else if (!finishTime.equals(other.finishTime))
			return false;
		if (presentList == null) {
			if (other.presentList != null)
				return false;
		} else if (!presentList.equals(other.presentList))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (state != other.state)
			return false;
		return true;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}



	public Date getFinishTime() {
		return finishTime;
	}



	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}


	@Override
	public String toString() {
		return "PresentPO [startTime=" + startTime + ", finishTime=" + finishTime + ", presentList=" + presentList
				+ ", state=" + state + "]";
	}

	
}
