package ink.onei.bootstarter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 26/12/2023 21:00 Tuesday
 */

@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private List<T> rows;
    public T object;
    private long total;

    public Result(List<T> rows, T object, long total) {
        this();
        this.rows = rows;
        this.object = object;
        this.total = total;
    }

    public Result() {
        code = 200;
        msg = "success";
    }
}


