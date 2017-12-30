package bl.listbl;

import VO.listVO.InfoListVO;
import VO.listVO.ListRM;

public interface InfoList {
    //这个接口是所有可审批的表单在提交和过审时必须调用的接口
    /*
    *这个接口包括两个方法，一个是注册待审信息表、另一个是修改信息表（将过审的单据放到过审信息表中/将未过审的单据移出待审信息表）
    *第二个接口中的布尔值代表单据是否审批成功。这个接口的实现写在表单包里。
     */
    public ListRM register(InfoListVO vo);

    public ListRM modify(boolean b,String id);

}
