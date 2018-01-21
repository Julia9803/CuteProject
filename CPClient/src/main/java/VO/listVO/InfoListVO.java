package VO.listVO;

import util.GreatListType;
import util.State;

public class InfoListVO {
    public String id;  //单据编号
    public GreatListType type;  // 单据类型
    public String operator; //操作人员
    public String note; //备注
    public State  state;
    public InfoListVO (String id,GreatListType type,String operator,String note){
        this.id=id;
        this.note=note;
        this.type=type;
        this.operator=operator;
        
    }
    


}
