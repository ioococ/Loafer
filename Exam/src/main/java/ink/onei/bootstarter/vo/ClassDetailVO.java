package ink.onei.bootstarter.vo;

import ink.onei.bootstarter.entity.Students;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 06/01/2024 15:41 Saturday
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassDetailVO {

    private Integer classId;
    private String name;
    private Integer teacherId;
    private Date createTime;
    private Date updateTime;
    private Integer studentNum;

}
