package VO.listVO;

import java.util.Date;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description
*/
public class SaleDetailConditionVO {
	/**
	 * 开始时间
	 */
	Date startTime;
	/**
	 * 结束时间
	 */
	Date finishTime;
	/**
	 * 商品名
	 */
	String goodsName;
	/**
	 * 客户
	 */
	String memberName;
	/**
	 * 业务员
	 */
	String clerk;
	/**
	 * 仓库
	 */
	String storage = "默认仓库";
	
}
