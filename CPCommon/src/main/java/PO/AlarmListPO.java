package PO;

import  javax.persistence.*;

@Entity
@Table(name="AlarmListPO")
public class AlarmListPO {
    @Id @GeneratedValue
    @Column(name="id")
    public  String listID;

    @Column(name="alarmNum")
    public int alarmNum;

    @Column(name="currentNum")
    public  int currentNum;

    @Column(name="goodsID")
    public  String goodsID;


    @Column(name="goodsName")
    public String goodsName;

}
