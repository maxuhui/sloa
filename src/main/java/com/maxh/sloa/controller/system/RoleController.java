package com.maxh.sloa.controller.system;

import com.maxh.sloa.common.EsyuiTree;
import com.maxh.sloa.common.JsonResult;
import com.maxh.sloa.entity.Permission;
import com.maxh.sloa.entity.Role;
import com.maxh.sloa.mapper.PermissionDao;
import com.maxh.sloa.mapper.RoleDao;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/role")
public class RoleController {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    @RequestMapping
    public String index() {
        return "system/role";
    }

    @RequestMapping({"/form", "/load"})
    public String form(Long id, Model model) {
        if (id != null) {
            //编辑
            Role role = roleDao.findOne(id);
            JSONObject entityJson = JSONObject.fromObject(role);
            model.addAttribute("role", entityJson);
        }
        return "system/permission/form";
    }
    @RequestMapping("/list")
    @ResponseBody
    public List<Role> list() {
        return roleDao.findAll();
    }
    
    @RequestMapping("permission/tree")
    @ResponseBody
    public List<Permission> permissionTree() {
        List<Permission> roots = permissionDao.findAllByParentIsNull();
        return EsyuiTree.makeTree(roots);
    }

    @RequestMapping("permission/save")
    @ResponseBody
    public JsonResult permissionSave( @Param("roleId") Long roleId, @Param("permissionId") Long[] permissionId) {
        roleDao.deletePermissionByRole(roleId);
        Map<String,Object> map = new HashMap<>();
        map.put("roleId",roleId);
        map.put("permissionId",permissionId);
//        roleDao.permissionSave(roleId,permissionId);
        roleDao.permissionSave(map);
        return JsonResult.success("授权成功！");
    }
    
}
