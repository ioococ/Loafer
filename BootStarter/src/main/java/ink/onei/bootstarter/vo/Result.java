package ink.onei.bootstarter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 05/01/2024 10:10 Friday
 */
@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private List<T> rows;
    private T data;
    private Integer total;

    public Result() {
        code = 200;
        msg = "success";
        total = 0;
    }
}
