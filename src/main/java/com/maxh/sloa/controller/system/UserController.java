package com.maxh.sloa.controller.system;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maxh.sloa.entity.User;
import com.maxh.sloa.mapper.UserDao;
import com.maxh.sloa.util.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserDao userDao;

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

        PageInfo<User> pageData = new PageInfo<User>(userList); // 实例化PageInf
        Map<String, Object> data = new HashMap<>();
        //总记录数
        data.put("total", pageData.getTotal());
        //当前页数据
        data.put("rows", userList);


        return result;
    }

    @RequestMapping({"/form", "/load"})
    public String form(Long id, Model model) {
        if (id != null) {
            //编辑
            User user = userDao.findOne(id);
            model.addAttribute("user", user);
        }
        //查询角色
//        model.addAttribute("roles", roleDao.findAllByEnable(true));
        return "system/user/form";
    }
}
