package ink.onei.bootstarter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 06/01/2024 17:16 Saturday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDetailVO {
    private Integer studentId;
    private String name;
    private Integer gender;
    private Date birthday;
    private Integer classId;
    private Date createTime;
    private Date updateTime;
    private Integer avgScore;
    private Integer status;
}
