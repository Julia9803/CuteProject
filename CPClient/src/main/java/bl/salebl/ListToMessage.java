package bl.salebl;

import java.util.Date;
import java.util.List;

import VO.saleVO.SaleListVO;
import VO.saleVO.SaleReturnListVO;
import VO.saleVO.SalesmanItemVO;
import VO.saleVO.SalesmanListVO;
import VO.saleVO.StockListVO;
import VO.saleVO.StockReturnListVO;
import VO.userVO.MessageVO;
import bl.userbl.MessageCenter;
import util.UserType;

/**     
* @author 李安迪
* @date 2018年1月7日
* @description 完成销售类单据审批中的发消息操作
*/
public class ListToMessage {
	MessageCenter c = new MessageCenter();
	private static final String OUT_TITLE = "出货";
	private static final String IN_TITLE=  "进货";
	private static final String VOUCHER_TITLE = "赠券";
	private static final String APPROVE_TITLE="审批通过";
	
	private String generateGoodsList(List<SalesmanItemVO> list){
		String message = "";
		if(list == null)
			return "";
		else{
			for(SalesmanItemVO vo : list){
				message+=vo.getId()+vo.getName()+vo.getType()+vo.getAmount()+"（"+vo.getNotes()+"）"+"；";
			}
		}
		return message;
	}
	
	private String generateStockMessage(SalesmanListVO vo){
		String message = "";
		message += "仓库"+vo.getWarehouse()+"：";
		message+="客户"+vo.getMemberID()+vo.getMemberName()+"：";
		message+=generateGoodsList(vo.getSaleListItems());

		return message;
	}
	
	
	private void sendApproveMessage(SalesmanListVO vo){
		c.sendMessage(new MessageVO(APPROVE_TITLE,vo.getId(),new Date()),UserType.Salesman);
	}
	public void sendMessage(StockListVO vo){
		String message = "";				
		if(vo == null)
			return;
		else{
			message = generateStockMessage(vo);
		}
		c.sendMessage(new MessageVO(OUT_TITLE, message, new Date()), UserType.Stockman);
		sendApproveMessage(vo);
	}
	
	public void sendMessage(StockReturnListVO vo){
		String message = "";				
		if(vo == null)
			return;
		else{
			message = generateStockMessage(vo);
		}
		c.sendMessage(new MessageVO(IN_TITLE, message, new Date()), UserType.Stockman);
		sendApproveMessage(vo);
	}
	
	public void sendMessage(SaleReturnListVO vo){
		String message = "";				
		if(vo == null)
			return;
		else{
			message = generateStockMessage(vo);
		}
		c.sendMessage(new MessageVO(IN_TITLE, message, new Date()), UserType.Stockman);
		sendApproveMessage(vo);
	}
	
	public void sendMessage(SaleListVO vo){
		String message = "";				
		if(vo == null)
			return;
		else{
			message = generateStockMessage(vo);
		}
		c.sendMessage(new MessageVO(OUT_TITLE, message, new Date()), UserType.Stockman);
		c.sendMessage(new MessageVO(VOUCHER_TITLE,"客户:"+vo.getMemberID()+vo.getMemberName()+" 赠券"+vo.getVoucher()+"",new Date()), UserType.Salesman);
		sendApproveMessage(vo);
	}
}

