package ink.onei.vo;

import org.springframework.stereotype.Component;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 20/12/2023 18:24 Wednesday
 */
@Component
public class MessageVO {
    private Integer status;
    private String msg;

    public MessageVO() {
    }

    public Integer getStatus() {
        return status;
    }

    public MessageVO(Integer status, String msg) {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("\"status\":").append(status);
        sb.append(", \"msg\":\"").append(msg).append("\"}");
        System.out.println(sb);
        return sb.toString();
    }
}
