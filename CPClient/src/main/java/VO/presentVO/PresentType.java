package VO.presentVO;


/**     
* @author 李安迪
* @date 2017年11月8日
* @description 策略
*/
public enum PresentType {
	Membership("针对用户级别型赠送策略"),
	SpecialPackage("特价包型赠送策略"),
	Sum("总价型赠送策略");

	private final String strategyType;
	
	private PresentType(String strategyType){
		this.strategyType = strategyType;
	}
	
	public String getName(){
		return this.strategyType;
	}
	
}
