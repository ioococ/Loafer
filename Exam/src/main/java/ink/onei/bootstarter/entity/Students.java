package ink.onei.bootstarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Students)实体类
 *
 * @author nekotako
 * @since 2024-01-06 15:35:37
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students implements Serializable {
    private static final long serialVersionUID = 914722827398205959L;

    private Integer studentId;

    private String name;

    private Integer gender;

    private Date birthday;

    private Integer classId;

    private Date createTime;

    private Date updateTime;


}

