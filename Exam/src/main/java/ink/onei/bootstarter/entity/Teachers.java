package ink.onei.bootstarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Teachers)实体类
 *
 * @author nekotako
 * @since 2024-01-06 15:35:37
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teachers implements Serializable {
    private static final long serialVersionUID = 146406491731752678L;

    private Integer teacherId;

    private String name;

    private Integer gender;

    private Date birthday;

    private String title;

    private Date createTime;

    private Date updateTime;

}

