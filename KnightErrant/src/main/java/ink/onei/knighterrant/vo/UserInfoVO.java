package ink.onei.knighterrant.vo;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户列表视图
 * @Date: 25/12/2023 10:43 Monday
 */

public class UserInfoVO<T> {
    private Integer code;
    private String msg;
    private List<T> data;
    private Long total;

    public UserInfoVO() {
    }

    public UserInfoVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public UserInfoVO(Integer code, String msg, List<T> data, Long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
