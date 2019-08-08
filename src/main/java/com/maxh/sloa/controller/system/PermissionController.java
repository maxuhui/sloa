package com.maxh.sloa.controller.system;

import com.maxh.sloa.common.JsonResult;
import com.maxh.sloa.entity.Permission;
import com.maxh.sloa.mapper.PermissionDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Controller
@RequestMapping("/system/permission")
public class PermissionController {

    @Autowired
    private PermissionDao permissionDao;

    @RequestMapping
    public String index(HttpSession session) {
        return "system/permission";
    }

    @RequestMapping({"/form", "/load"})
    public String form(Long id, Model model) {
        if (id != null) {
            //编辑
            Permission permission = permissionDao.findOne(id);
//            model.addAttribute("permission", permission);
            JSONObject entityJson = JSONObject.fromObject(permission);
            model.addAttribute("permission", entityJson);
        }
        return "system/permission/form";
    }

    @PostMapping("/list")
    @ResponseBody
    public List<Permission> list() {
        List<Permission> roots = permissionDao.findAllByParentIsNull();
        return makeTree(roots);
    }

    @PostMapping("/combox")
    @ResponseBody
    public List<Permission> combo() {
        List<Permission> roots = permissionDao.findAllByParent();
        return makeTree(roots);
    }

    @PostMapping({"/save", "/update"})
    @ResponseBody
    @Transactional
    public JsonResult form(Permission permission) {
        if(isEmpty(permission.getId())){
            permissionDao.save(permission);
        }else{
            permissionDao.update(permission);
        }
        
        return JsonResult.success();
    }

    @GetMapping("/delete")
    @ResponseBody
    @Transactional
    public JsonResult delete(Long id) {
        Permission permission = permissionDao.findOne(id);
        if (permission != null) {
            permissionDao.delete(permission);
            return JsonResult.success();
        }
        return JsonResult.error("数据不存在！");
    }

    /**
     * 组装树形列表 treegrid
     *
     * @param list
     * @return
     */
    private List<Permission> makeTree(List<Permission> list) {
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

    private void makeChildren(List<Permission> parent, List<Permission> children) {
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
