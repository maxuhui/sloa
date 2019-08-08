package com.maxh.sloa.controller.system;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maxh.sloa.common.JsonResult;
import com.maxh.sloa.entity.Role;
import com.maxh.sloa.entity.User;
import com.maxh.sloa.mapper.RoleDao;
import com.maxh.sloa.mapper.UserDao;
import com.maxh.sloa.util.EasyUIDataGridResult;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @RequestMapping("/index")
    public String index(HttpSession session) {
        return "system/user";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int rows, User user) {

        PageHelper.startPage(page, rows); //开始起始页
        List<User> userList = userDao.findAll(user); // 获取数据
        //创建返回结果对象
        PageInfo<User> pageInfo = new PageInfo<User>(userList); // 实例化PageInfo
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(userList);
        return result;
    }

    @RequestMapping({"/form", "/load"})
    public String form(Long id, Model model) {
        if (id != null) {
            //编辑
            User user = userDao.findOne(id);
            JSONObject entityJson = JSONObject.fromObject(user);
            model.addAttribute("userBean", entityJson);
        }
        //查询角色
//        model.addAttribute("roles", roleDao.findByStatus(true));
        return "system/user/form";
    }

    @RequestMapping("/check")
    @ResponseBody
    public String check(String account) {
        if (userDao.countByUserName(account) == 0) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/roles")
    @ResponseBody
    public List<Role> roles() {
        return roleDao.findByStatus(true);
    }

    @RequestMapping({"/save", "/update"})
    @ResponseBody
    public JsonResult form( User user, Long[] roles) {
        if (user.getId() == null) {
            //md5加密密码
            user.setPassword("000000");
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        } else {
            User org = userDao.findOne(user.getId());
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            } else {
                //不修改密码
                user.setPassword(org.getPassword());
            }
        }

        //处理角色的关联
//        if (roles != null && roles.length > 1) {
//            Set<Role> rolesList = new HashSet<Role>();
//            for (Long rid : roles) {
//                if (rid != null) {
//                    rolesList.add(roleDao.findOne(rid));
//                }
//            }
//            user.setRoles(rolesList);
//        }

        userDao.save(user);

        return JsonResult.success();

    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id) {
        User user = userDao.findOne(id);
        if (user != null) {
            userDao.delete(user);
            return JsonResult.success();
        }
        return JsonResult.error("数据不存在！");
    }
}
