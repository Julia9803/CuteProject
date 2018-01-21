package resultmessage;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年12月2日
* @description
*/
public enum DataRM implements Serializable{
	SUCCESS,
	//提示信息
	CANCEL_REMIND,
	EXIST,
	NOT_EXIST,
	//今日单据生成数量达到上限
	LIST_FULL,
	FAILED,
	//其他错误
	//折让超过额度
	REBATE_FAILED,
	//格式错误
	FORMAT_FAILED,
	//网络错误
	NET_FAILED,
	//库存不足
	STOCK_FAILED,
	//会员应收额度
	VIP_FAILED,
	//库存赠送单生成失败
	PRESENT_FAILED;


}
