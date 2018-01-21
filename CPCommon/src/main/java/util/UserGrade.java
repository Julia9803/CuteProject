package util;


/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public enum UserGrade {
	General(1,"普通人员"),
	Manager(2,"经理");
	
	private final int grade;
	private final String name;
	
	private UserGrade(int grade,String name){
		this.grade = grade;
		this.name = name;
	}
	
	public int getGrade(){
		return this.grade;
	}
	
	public String getName(){
		return this.name;
	}
	
}
