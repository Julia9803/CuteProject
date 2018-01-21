package PO;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import util.GreatListType;
import util.State;

@Entity
@Table(name="InfoListPO")
public class InfoListPO implements Serializable{




    @Id 
   // @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payablemoney_seq")
   // @SequenceGenerator(name="payablemoney_seq", sequenceName="id")
   
    @Column(name="id",length=
    32) 
	public String id;  //单据编号

    @Column(name="type",length=32)
    public GreatListType type;  // 单据类型
    @Column(name="operator",length=32)
    public String operator; //操作人员
    @Column(name="note",length=32)
    public String note; //备注
    @Column(name="state")
    public State state;//单据状态
    public InfoListPO (String id,GreatListType type,String operator,String note){
        this.id=id;
        this.note=note;
        this.type=type;
        this.operator=operator;
        this.state=State.IsCommitted;
    }

    public InfoListPO() {
    }


//  王瑞华 制作
}
