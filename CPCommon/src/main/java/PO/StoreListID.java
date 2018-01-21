package PO;

//import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StoreListID")
public class StoreListID {
//用于计算库存类单据ID，理论上别的单据也可以复用，你们要用的话跟我说一声。
	
	@Column
	public String day;  
	
	
	@Id
	@Column(name="ListType")
	public String ListType;
	
	@Column(name="num")
	public int num;
	
	@Column(name="listName")
	public String listName;
	
	public StoreListID(){}
    public StoreListID(String type,String listName){
    	this.ListType=type;
    	this.listName=listName;
    }
	
}
