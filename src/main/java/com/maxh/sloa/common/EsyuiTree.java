package com.maxh.sloa.common;

import com.maxh.sloa.entity.Permission;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class EsyuiTree {

    public EsyuiTree() {
    }

    /**
     * 组装树形列表 treegrid
     *
     * @param list
     * @return
     */
    public static List<Permission> makeTree(List<Permission> list) {
        List<Permission> parent = new ArrayList<Permission>();
        for (Permission p : list) {
            if (isEmpty(p.getParent_id())) {
                p.setChildren(new ArrayList<Permission>(0));
                parent.add(p);
            }
        }
        list.removeAll(parent);
        makeChildren(parent, list);
        return parent;
    }

    private static void makeChildren(List<Permission> parent, List<Permission> children) {
        if (children.isEmpty()) {
            return;
        }
        List<Permission> tmp = new ArrayList<Permission>();
        for (Permission c1 : parent) {
            for (Permission c2 : children) {
                c2.setChildren(new ArrayList<Permission>(0));
                if (c1.getId().equals(c2.getParent_id())) {
                    c1.getChildren().add(c2);
//                    if (!c1.getParent_id().equals("0")) {
//                        c1.setState("closed");
//                    }
                    tmp.add(c2);
                }
            }
        }
        children.removeAll(tmp);
        makeChildren(tmp, children);
    }
}
