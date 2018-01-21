package PO.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.State;

public class CollectionListPO extends FinanceListPO{
	private static final long serialVersionUID = 2734975037357897283L;
	private String VIPID;
	private String VIPName;
	private List<TransferItemPO> transferItem;
	
	
	public CollectionListPO(){}
	public CollectionListPO(String listID, String VIPID, String VIPName, String operator,String operatorId, List<TransferItemPO> transferItem, double totalAmount, State state, Date day){
		setId(listID);
		this.VIPID = VIPID;
		this.VIPName = VIPName;
		setOperator(operator);
		setOperatorId(operatorId);
		setTransferItem(transferItem);
		setTotalAmount(totalAmount);
		setState(state);
		setDay(day);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((VIPID == null) ? 0 : VIPID.hashCode());
		result = prime * result + ((VIPName == null) ? 0 : VIPName.hashCode());
		result = prime * result + ((transferItem == null) ? 0 : transferItem.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollectionListPO other = (CollectionListPO) obj;
		if (VIPID == null) {
			if (other.VIPID != null)
				return false;
		} else if (!VIPID.equals(other.VIPID))
			return false;
		if (VIPName == null) {
			if (other.VIPName != null)
				return false;
		} else if (!VIPName.equals(other.VIPName))
			return false;
		if (transferItem == null) {
			if (other.transferItem != null)
				return false;
		} else if (!transferItem.equals(other.transferItem))
			return false;
		return true;
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
	
	public List<TransferItemPO> getTransferItem() {
		if(transferItem == null)
			return null;
		return new ArrayList<TransferItemPO>(transferItem);
	}
	public void setTransferItem(List<TransferItemPO> transferItem) {
		if(transferItem == null)
			this.transferItem = null;
		else
			this.transferItem = new ArrayList<TransferItemPO>(transferItem);
	}

}
