package dream.work.utils;


import net.sf.json.JSONObject;

public class ApiUtil {
	
	/** 
	    * @Title: checkParam 
	    * @Description: 检查参数是否合格 
	    * @date：2017年12月5日 下午5:23:25
	    * @param type (1.api 2.web)
	    * @param method
	    * @param data
	    * @return   
	    */
	    public static boolean checkParam(int type,String method, JSONObject data) {
	        boolean result = false;
	        int falseCount = 0;
	        int size = 0;
	        String[] paramArray = null;
	        // String[] valueArray;
	        String[] tempArray = null; // 临时数组
	        if(type==1) {
	        	if("register".equals(method)){
		        	paramArray = ApiConst.API_REGISTERED_PARAM_ARRAY;// 参数
		            size = paramArray.length;
		            tempArray = new String[size];
		        }else if ("login".equals(method)) {
		            paramArray = ApiConst.API_LOGIN_PARAM_ARRAY;// 参数
		            size = paramArray.length;
		            tempArray = new String[size];
		        }else if("downloadlist".equals(method)) {
		        	paramArray = ApiConst.API_DOWNLOADLIST_PARAM_ARRAY;// 参数
		            size = paramArray.length;
		            tempArray = new String[size];
		        }
	        }
	        if(type==2) {
	        	if ("weblogin".equals(method)) {
		            paramArray = WebConst.LOGIN_PARAM_ARRAY;// 参数
		            size = paramArray.length;
		            tempArray = new String[size];
		            
		        }else if("userlist".equals(method)) {
		        	paramArray = WebConst.USER_PARAM_ARRAY;// 参数
		            size = paramArray.length;
		            tempArray = new String[size];
		        }
	        }

	        for (int i = 0; i < size; i++) {
	            if (!data.containsKey(paramArray[i])) {
	                tempArray[falseCount] = paramArray[i];
	                falseCount += 1;
	            } else if (data.containsKey(paramArray[i]) && data.get(paramArray[i]) == null) {
	                tempArray[falseCount] = paramArray[i];
	                falseCount += 1;
	            } else {
	                continue;
	            }
	        }
	        
	        if(!(falseCount > 0)){
	        	result = true;
	        }
	        if (falseCount > 0) {
	            System.out.println(method + "接口，请求协议中缺少 " + falseCount + "个 参数");
	            for (int j = 1; j <= falseCount; j++) {
	            	 System.out.println("   第" + j + "个：" + tempArray[j - 1]);
	            }
	        } else {
	            result = true;
	        }

	        return result;
	    }
	    
	    
}
