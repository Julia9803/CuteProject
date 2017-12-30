package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description 考虑弃用这个类，直接用Double.parseDouble等方法		//不要弃用，可以留着欣赏用
*/
public class NumberUtil {
    private static boolean isMatch(String regex, String original){  
        if (original == null || original.trim().equals("")) {  
            return false;  
        }  
        Pattern pattern = Pattern.compile(regex);  
        Matcher isNum = pattern.matcher(original);  
        return isNum.matches();  
    }  
  
    public static boolean isPositiveInteger(String original) {  
        return isMatch("^\\+{0,1}[1-9]\\d*", original);  
    }  
  
    public static boolean isNegativeInteger(String original) {  
        return isMatch("^-[1-9]\\d*", original);  
    }  
  
    public static boolean isInteger(String original) {  
        return isMatch("[+-]{0,1}0", original) || isPositiveInteger(original) || isNegativeInteger(original);  
    }  
     
    public static boolean isPositiveDecimal(String original){  
        return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", original);  
    }  
      
    public static boolean isNegativeDecimal(String original){  
        return isMatch("^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*", original);  
    }  
      
    public static boolean isDecimal(String original){  
        return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", original);  
    }  
      
    public static boolean isPositive(String original){
    	return isPositiveInteger(original)||isPositiveDecimal(original);
    }
    
    public static boolean isNotNegative(String original){
    	return isMatch("[+-]{0,1}0", original) || isPositive(original);
    }
}
