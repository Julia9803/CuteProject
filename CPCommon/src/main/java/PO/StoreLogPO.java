package PO;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import util.GreatListType;

@Entity
@Table(name="StoreLogPO")
public class StoreLogPO implements Serializable{
	//为了库存查看，必须记录下来每次库存变动的时间、商品ID、商品名称、变动原因、商品数量、涉及的单价
    
    @Column(name="id")
    public String id;

    @Id
    @Column(name="time")
    public String time;


    @Column(name="name")
    public String name;

    @Column(name="type")
    public GreatListType type;

    @Column(name="num")
	public int num;

    @Column(name="price")
    public double price;

    public StoreLogPO(){}
}
