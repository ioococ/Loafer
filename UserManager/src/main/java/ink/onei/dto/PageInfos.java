package ink.onei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: nekotako
 * @Description: 页数相关
 * @Date: 07/12/2023 19:50 Thursday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfos {
    private Integer pageNum;
    private Integer pageSize;
    private Integer start;

    public void getPageStart() {
        this.start = (this.pageNum - 1) * this.pageSize;
    }
}
