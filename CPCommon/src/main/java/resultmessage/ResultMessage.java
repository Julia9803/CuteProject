package resultmessage;
/**
 * 
 * @author julia98
 *
 */
public enum ResultMessage {
	SUCCESS, // 成功
    FAILED, // 失败
    WRONG, // 错误
    EXIST, // 已存在
    NOT_EXIST, // 不存在
    TRUE,//判断为真
    FALSE;//判断为假
	
	@Override
	public String toString() {
        switch (this) {
            case SUCCESS:
                return "成功";
            case FAILED:
                return "失败";
            case WRONG:
                return "错误";
            case EXIST:
                return "已存在";
            case NOT_EXIST:
                return "不存在";
            case TRUE:
                return "真";
            case FALSE:
                return "假";
            default:
                return null;
        }
    }
}
