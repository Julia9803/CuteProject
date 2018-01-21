package util;

import java.io.Serializable;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 用户等级，分为5个等级
*/
public enum VIPGrade implements Serializable{

	GradeOne(1),
	GradeTwo(2),
	GradeThree(3),
	GradeFour(4),
	GradeFive(5);
	
	private final int grade;
	
	VIPGrade(int grade){
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "" + grade;	
	}
	
    public static VIPGrade getVIPGradeByString(String s) {
    	int i = Integer.parseInt(s);
        for (VIPGrade vipGrade : VIPGrade.values()) {
            if (i == vipGrade.grade)
                return vipGrade;
        }
        return null;
    }
    
	public int getGrade(){
		return this.grade;
	}
}
