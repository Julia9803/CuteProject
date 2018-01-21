package VO.presentVO;

import java.util.Date;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public abstract class PresentVO {

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
	 * @param id
	 * @param startTime
	 * @param finishTime
	 */
	public PresentVO(int id, Date startTime, Date finishTime) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}


	public Date getStartTime() {
		return startTime;
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "PresentVO [id=" + id + ", startTime=" + startTime + ", finishTime=" + finishTime + "]";
	}
	
	

}
