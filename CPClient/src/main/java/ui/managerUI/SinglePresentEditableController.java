package ui.managerUI;

import java.util.List;

import VO.GoodsInSaleVO;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description 单个赠送策略的单独界面实现这个接口
*/
public interface SinglePresentEditableController extends SinglePresentController{
	/**
	 * fxml的initialize，每次自动加载
	 */
	void initialize();
	/**
	 * 保存
	 */
	void save();
	/**
	 * 显示确认信息对话框
	 * @return 是否确认操作
	 */
	boolean showConfirmDialog();
	/**
	 * 回到主页面
	 */
	void back();
//	void cancel();
	/**
	 * 查找商品
	 */
	void search();
	/**
	 * @param vo
	 * 添加到赠品列表或特价商品列表
	 */
	void addToPresentList(GoodsInSaleVO vo);
	/**
	 * 更新显示的赠品列表
	 */
	void refresh();

	/**
	 * @return 赠品清单或商品清单
	 */
	List<GoodsInSaleVO> getPresentList();
//	/**
//	 * @param presentList
//	 */
//	void setPresentList(List<GoodsInSaleVO> presentList);
	/**
	 * @param vo
	 */
	void deleteFromPresentList(GoodsInSaleVO vo);
}
