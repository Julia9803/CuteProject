package VO.accountVO;

import java.util.ArrayList;
import java.util.List;

import util.State;

public class CollectionListVO extends FinanceListVO{
	private String VIPID;
	private String VIPName;
	private List<TransferItemVO> transferItem;
	
	
	public CollectionListVO(String listID, String VIPID, String VIPName, String operator, String operatorId, List<TransferItemVO> transferItem, double totalAmount, State state){
		setId(listID);
		setVIPID(VIPID);
		setVIPName(VIPName);
		setOperator(operator);
		setOperatorId(operatorId);
		setTransferItem(transferItem);
		setTotalAmount(totalAmount);
		setState(state);
	}
	
	
	public String getVIPID() {
		return VIPID;
	}
	public void setVIPID(String vIPID) {
		VIPID = vIPID;
	}
	public String getVIPName() {
		return VIPName;
	}
	public void setVIPName(String vIPName) {
		VIPName = vIPName;
	}
	
	public List<TransferItemVO> getTransferItem() {
		if(transferItem == null)
			return null;
		else
			return new ArrayList<TransferItemVO>(transferItem);
		
	}
	public void setTransferItem(List<TransferItemVO> transferItem) {
		if(transferItem == null)
			this.transferItem = null;
		else
			this.transferItem = new ArrayList<TransferItemVO>(transferItem);
	}
	
	
	
}
