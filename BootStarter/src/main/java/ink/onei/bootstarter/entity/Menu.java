package ink.onei.bootstarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 05/01/2024 18:40 Friday
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Integer id;
    private String name;
    private Integer parentId;
    private String url;
    private String icon;
    private String className;
    private List<Menu> child;
}

