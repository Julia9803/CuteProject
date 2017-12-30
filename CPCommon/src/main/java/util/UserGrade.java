package util;


/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public enum UserGrade {
	General(1),
	Manager(2);
	
	private final int grade;
	
	private UserGrade(int grade){
		this.grade = grade;
	}
	
	public int getName(){
		return this.grade;
	}
	
}
