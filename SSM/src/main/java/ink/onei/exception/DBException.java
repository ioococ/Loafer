package ink.onei.exception;

/**
 * @Author: nekotako
 * @Description: 操作数据库时异常
 * @Date: 15/12/2023 16:37 Friday
 */

public class DBException extends RuntimeException{
    public DBException() {
        super();
    }
    public DBException(String message) {
        super(message);
    }
}
