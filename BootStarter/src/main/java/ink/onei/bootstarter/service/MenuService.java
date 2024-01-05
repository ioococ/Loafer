package ink.onei.bootstarter.service;

import ink.onei.bootstarter.entity.Menu;
import ink.onei.bootstarter.mapper.IMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 02/01/2024 20:00 Tuesday
 */

@Service
public class MenuService implements IMenuService {

    @Autowired
    IMenuMapper menuMapper;

    @Override
    public List<Menu> getMenuList() {
        List<Menu> menuList = menuMapper.getMenuList();
        List<Menu> result = new ArrayList<>();
        HashMap<Integer, Menu> menuMap = new HashMap<>();
        menuList.forEach(item -> menuMap.put(item.getId(), item));
        for (Menu item : menuList) {
            if (item.getParentId() == 0)
                result.add(item);
            else {
                Menu parentMenu = menuMap.get(item.getParentId());
                if (parentMenu.getChild() == null)
                    parentMenu.setChild(new ArrayList<>());
                parentMenu.getChild().add(item);
            }
        }
        return result;
    }
}
