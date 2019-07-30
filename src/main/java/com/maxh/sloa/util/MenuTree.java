package com.maxh.sloa.util;

import com.maxh.sloa.common.Menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

public class MenuTree {
    public static Map<String, Object> mapArray = new LinkedHashMap<String, Object>();
    public List<Menu> menuCommon;
    public List<Object> list = new ArrayList<Object>();

    public List<Object> menuList(List<Menu> menu) {
        this.menuCommon = menu;
        for (Menu x : menu) {
            Map<String, Object> mapArr = new LinkedHashMap<String, Object>();
            if (isEmpty(x.getParentId())) {
                mapArr.put("id", x.getId());
                mapArr.put("name", x.getText());
                mapArr.put("href",x.getHref());
                mapArr.put("pid", x.getParentId());
                mapArr.put("child", menuChild(x.getId()));
                list.add(mapArr);
            }
        }
        return list;
    }


    public List<?> menuChild(Long id) {
        List<Object> lists = new ArrayList<Object>();
        for (Menu a : menuCommon) {
            Map<String, Object> childArray = new LinkedHashMap<String, Object>();
            if (a.getParentId() == id) {
                childArray.put("id", a.getId());
                childArray.put("name", a.getText());
                childArray.put("href", a.getHref());
                childArray.put("pid", a.getParentId());
                childArray.put("child", menuChild(a.getId()));
                lists.add(childArray);
            }
        }
        return lists;

    }
}
