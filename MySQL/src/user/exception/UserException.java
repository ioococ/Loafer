package user.exception;

import java.io.Serial;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 18:50 星期五
 */

public class UserException extends Exception{
    @Serial
    private static final long serialVersionUID = 3440731124511860598L;

    public UserException(){
        super();
    }
    public UserException(String msg){
        super(msg);
    }
}
