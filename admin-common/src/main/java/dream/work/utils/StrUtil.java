package dream.work.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {

	/**
	* 剔除字母
	* @param value
	*/
	public static String removeLetter(String value){
		Pattern p = Pattern.compile("[a-zA-z]");
		Matcher matcher = p.matcher(value);
		String result = matcher.replaceAll("");
		System.out.println(result);
		return result;
	}
	
}
