package PO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AlarmListPO")
public class AlarmListPO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6401586978907261654L;

	@Id 
    @Column(name="id")
    public  String id;

    @Column(name="alarmNum")
    public int alarmNum;

    @Column(name="currentNum")
    public  int currentNum;

    @Column(name="goodsID")
    public  String goodsID;


    @Column(name="goodsName")
    public String goodsName;

    public AlarmListPO(){}

}
