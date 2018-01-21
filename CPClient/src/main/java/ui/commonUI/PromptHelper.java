package ui.commonUI;

import java.io.IOException;

import resultmessage.DataRM;

/**     
* @author 李安迪
* @date 2018年1月2日
* @description 显示提示框
*/
public class PromptHelper {
	public static void showPrompt(DataRM rm){
		try{
		switch(rm){
		case SUCCESS:
			new PromptWin("成功~");
			break;
		case EXIST:
			new PromptWin("存在重复单据哦~");
			break;
		case NOT_EXIST:
			new PromptWin("单据不存在~");
			break;
		case FAILED:
			new PromptWin("失败了呢~");
			break;
		case NET_FAILED:
			new PromptWin("网络有点渣~");
			break;
		case STOCK_FAILED:
			new PromptWin("库存不足~");
			break;
		case VIP_FAILED:
			new PromptWin("超出应收额度~");
			break;
		case PRESENT_FAILED:
			new PromptWin("生成库存赠送单失败了~");
			break;
		case FORMAT_FAILED:
			new PromptWin("数字格式错误哦~");
			break;
		case REBATE_FAILED:
			new PromptWin("折让金额超过额度~");
			break;
		case CANCEL_REMIND:
			new PromptWin("请先取消当前操作,返回主界面~");
			break;
		case LIST_FULL:
			new PromptWin("今天生成太多单啦明天再试哦~");
			break;
		default:
			new PromptWin("出现未知错误");
		}
		
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
