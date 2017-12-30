package PO;
import  javax.persistence.*;
import util.GreatListType;

@Entity
@Table(name="StoreLogPO")
public class StoreLogPO {
	//为了库存查看，必须记录下来每次库存变动的时间、商品ID、商品名称、变动原因、商品数量、涉及的单价
    @Id @GeneratedValue
    @Column(name="id")
    public String id;

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

}
