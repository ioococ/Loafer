package ink.onei.exception;

/**
 * @Author: nekotako
 * @Description: 用户异常类
 * @Date: 2023/11/10 18:50 星期五
 */

public class UserException extends RuntimeException {
    private static final long serialVersionUID = 3440731124511860598L;

    public UserException() {
        super();
    }

    public UserException(String msg) {
        super(msg);
    }
}
