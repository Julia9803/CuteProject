package PO;
import  javax.persistence.*;
import util.GreatListType;
import util.State;

@Entity
@Table(name="InfoListPO")
public class InfoListPO {
    @Id @GeneratedValue
    @Column(name="id")
	public String id;  //单据编号

    @Column(name="type")
    public GreatListType type;  // 单据类型
    @Column(name="operator")
    public String operator; //操作人员
    @Column(name="note")
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



//  王瑞华 制作
}
