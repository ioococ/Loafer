package ink.onei.dto;

import org.springframework.stereotype.Component;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 20/12/2023 18:24 Wednesday
 */
@Component
public class Message {
    private Integer status;
    private String msg;

    public Message() {
    }

    public Integer getStatus() {
        return status;
    }

    public Message(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
