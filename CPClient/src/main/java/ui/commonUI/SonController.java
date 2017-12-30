package ui.commonUI;
/**
 *  子界面的controller可以实现此接口，方便父界面将自己的引用设置给他，以便回退。
 */
public interface SonController {
	public void setParentController(ParentController controller);
}
