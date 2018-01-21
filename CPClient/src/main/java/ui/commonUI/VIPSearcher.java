package ui.commonUI;

import VO.VIPVO.VIPVO;

/**
 * 需要选择vip的人可以实现此接口
 * 相当于提供一个回调函数
 * 在vip选择完毕时会调用该函数，将选择的vipvo传回去
 * @author zxy
 *
 */
public interface VIPSearcher {
	public void VIPSelected(VIPVO vipvo);
}
