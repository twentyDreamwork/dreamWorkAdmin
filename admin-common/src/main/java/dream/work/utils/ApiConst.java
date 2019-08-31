package dream.work.utils;

public class ApiConst {
	
	public static final String KEY = "123456"; // 密钥加密signature用到
	
    public static final String[] API_REGISTERED_PARAM_ARRAY = new String[] { "username", "password", "phone", "platform","MachineCode", "ip","InvitationCode"};
    
    
    public static final String[] API_LOGIN_PARAM_ARRAY = new String[] { "username", "password", "phone","platform","MachineCode","ip"};
   
    public static final String[] API_DOWNLOADLIST_PARAM_ARRAY = new String[] {"username","platform","pageno"};
}
