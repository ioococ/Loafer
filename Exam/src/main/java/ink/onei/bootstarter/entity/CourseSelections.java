package ink.onei.bootstarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (CourseSelections)实体类
 *
 * @author nekotako
 * @since 2024-01-06 15:35:37
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSelections implements Serializable {
    private static final long serialVersionUID = -96981606914009580L;

    private Integer selectionId;

    private Integer studentId;

    private Integer courseId;

    private Double score;

    private Date createTime;

    private Date updateTime;

}

