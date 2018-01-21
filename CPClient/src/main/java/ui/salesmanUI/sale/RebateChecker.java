package ui.salesmanUI.sale;

import util.UserGrade;
import util.UserType;

/**     
* @author 李安迪
* @date 2018年1月3日
* @description 检查销售单的折让额度
*/
public class RebateChecker {
	public static double getRebateLimit(UserType type ,UserGrade grade){
		if(type == UserType.Salesman)
		switch(grade){
		case General:
			return 1000;
		case Manager:
			return 5000;
		}
		return Double.MAX_VALUE;
	}
}
