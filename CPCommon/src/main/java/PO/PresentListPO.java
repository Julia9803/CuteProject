package PO;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import util.State;

@Entity
@Table(name="PresentListPO")
public class PresentListPO implements Serializable{

	@Id 
	@Column(name="listID")
	public String listID;  //单据编号

	@Column(name="id")
	public ArrayList<String >id ; //赠品ID

	@Column(name="num")
	   public ArrayList<Integer> num;//赠品数量

	@Column(name="name")
	public ArrayList<String> name ;//赠品名字

	@Column(name="VIPname")
	public String VIPname ; // 赠送的对象

	@Column(name="statetype")
	public State statetype;


	@Column(name="time")
	public String time;//操作时间
	@Column(name="operator")
	public String operator;//操作员

	public PresentListPO(){}

}
