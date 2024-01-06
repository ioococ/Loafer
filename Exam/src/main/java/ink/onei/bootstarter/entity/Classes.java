package ink.onei.bootstarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Classes)实体类
 *
 * @author nekotako
 * @since 2024-01-06 15:35:37
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classes implements Serializable {
    private static final long serialVersionUID = -90101399524458806L;

    private Integer classId;

    private String name;

    private Integer teacherId;

    private Date createTime;

    private Date updateTime;

}

