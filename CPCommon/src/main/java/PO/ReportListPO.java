package PO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import util.State;
import util.StoreListType;


@Entity
@Table(name="ReportListPO")
public class ReportListPO implements Serializable{
	/**
	 * 
	 */
		@Id 
	@Column(name="listID")
	public  String listID;

	@Column(name="st")
	  public  StoreListType st;

	@Column(name="statetype")
	   public State statetype;
	@Column(name="actualNum")
	    public int actualNum;
	@Column(name="Num")
	    public int Num;
	@Column(name="delta")
	   public  int delta;
	@Column(name="goodsID")
	   public  String goodsID;
	@Column(name="GoodsName")
	   public  String GoodsName;
	@Column(name="time")
	   public String time;//操作时间
	@Column(name="operator")
	   public String operator;//操作员

	public ReportListPO (){}
}
