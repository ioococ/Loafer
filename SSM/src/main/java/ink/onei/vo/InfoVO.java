package ink.onei.vo;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 前端展示数据
 * @Date: 21/12/2023 20:05 Thursday
 */

public class InfoVO<T> {
    private Integer code;
    private String status;
    private List<T> list;

    public InfoVO() {
    }

    public InfoVO(Integer code, String status, List<T> list) {
        this.code = code;
        this.status = status;
        this.list = list;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
