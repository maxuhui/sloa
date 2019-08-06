package com.maxh.sloa.controller.system;

import com.maxh.sloa.common.JsonResult;
import com.maxh.sloa.entity.Permission;
import com.maxh.sloa.mapper.PermissionDao;
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
import java.util.List;

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
            model.addAttribute("permission", permission);
        }
        return "system/permission/form";
    }

    @PostMapping("/list")
    @ResponseBody
    public List<Permission> list() {
        List<Permission> roots = permissionDao.findAllByParentIsNull();
        return roots;
    }

    @PostMapping("/combo")
    @ResponseBody
    public List<Permission> combo() {
        List<Permission> roots = permissionDao.findAllByParentIsNull();
        return roots;
    }

    @PostMapping({"/save", "/update"})
    @ResponseBody
    @Transactional
    public JsonResult form(Permission permission, BindingResult br) {
        if (!br.hasErrors()) {
            permissionDao.save(permission);
            return JsonResult.success();
        } else {
            return JsonResult.error("校验不通过！");
        }
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
}
