package PO;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StorePO")
public class StorePO  implements Serializable{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 3819185728624176297L;





	@Id
	@Column(name="ID")
	public String ID;  //商品ID

	@Column(name="name")
	public String name; //商品名称

	@Column(name="alarmNum")
	public int alarmNum;//警戒线

	@Column(name="Num")
	public int Num; //现有数量

	@Column(name="averagePrice")
	public double averagePrice;//库存均价

    public StorePO(){}


}
