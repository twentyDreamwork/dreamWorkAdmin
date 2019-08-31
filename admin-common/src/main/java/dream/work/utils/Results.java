package dream.work.utils;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Results<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	private boolean success;

    private int code;

    private String message;

    private T result;

    public Results(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }
    
    public Results(String message){
        this.success = false;
        this.code = 401;
        this.message =message;
    }
    
    
    public Results(boolean success,int code,String message,T result) {
    	this.success = success;
    	this.code = code;
    	this.message = message;
    	this.result = result;
    }
    
    public Results(ResultCode resultCode, T result){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.result = result;
    }
    
    
    public static Results resultSucc(){
        return new Results<>(CommonCode.SUCCESS);
    }
    public static Results resultErr(){
        return new Results<>(CommonCode.FAIL);
    }

    public static Results resultSucc(Object result){
        return new Results<>(CommonCode.SUCCESS, result);
    }
    public static Results resultErr(Object result){
        return new Results<>(CommonCode.FAIL, result);
    }

    public static Results resultTokenErr(Object result){
        return new Results<>(CommonCode.INVALID_TOKEN, result);
    }
    
    public static Results resultDTO(boolean success,int code,String message,Object result) {
    	return new Results<>(success,code, message, result);
    }
    
    public static Results resultParamErr(String message){
    	return new Results<>(message);
    }

}