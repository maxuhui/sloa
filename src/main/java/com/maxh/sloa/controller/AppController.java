package com.maxh.sloa.controller;


import com.maxh.sloa.common.Menu;
import com.maxh.sloa.entity.Menus;
import com.maxh.sloa.entity.Permission;
import com.maxh.sloa.entity.Role;
import com.maxh.sloa.entity.User;
import com.maxh.sloa.mapper.PermissionDao;
import com.maxh.sloa.mapper.UserDao;
import com.maxh.sloa.util.MenuTree;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;

import org.apache.log4j.Logger;

import static org.springframework.util.ObjectUtils.isEmpty;


@Controller
@Transactional(readOnly = true)
public class AppController {
    Logger logger = Logger.getLogger(AppController.class);


    @Autowired
    private UserDao userDao;

    @Value("${system.super.user.id}")
    private Long superId;

    @Autowired
    private PermissionDao permissionDao;


    @RequestMapping("/index")
    public String index(HttpSession session) {
        return "index";
    }


    @RequestMapping("/toLogin")
    public String login(@SessionAttribute(value = "user", required = false) User user) {
        if (user == null) {
            return "login";
        }
        return "index";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String account, @RequestParam String password, HttpSession session, RedirectAttributes rda) {
        // 参数校验
        if (isEmpty(account) || isEmpty(password)) {
            rda.addFlashAttribute("error", "参数错误！");
            return "redirect:/toLogin";
        }

        User user = userDao.findFirstByAccount(account);
        //判断账号是否可用
        if (user != null && user.getEnable()) {
            //判断密码是否匹配
            if (user.getPassword().equals(DigestUtils.md5Hex(password))) {

                Set<Permission> permissions;
                //判断是否是超级管理员
                if (Objects.equals(superId, user.getId())) {
                    permissions = permissionDao.findAllByEnableOrderByWeightDesc(true);
                } else {
                    //获取用户菜单
                    Set<Role> roles = user.getRoles();
                    permissions = new HashSet<>();
                    //roles.forEach(role -> permissions.addAll(role.getPermissions()));
                     
                    for (Role role : roles) {
                        Set<Permission> p = permissionDao.findByRoleId(role.getId());
                        permissions.addAll(p);
                    }
                }
                //存储权限key
                Set<String> keys = new HashSet<>();
                //所有有权限访问的请求
                Set<String> urls = new HashSet<>();
                //存储菜单
                //TODO  权重是什么作用？？
                TreeSet<Permission> menus = new TreeSet<>((o1, o2) -> {
                    if (Objects.equals(o1.getWeight(), o2.getWeight())) {
                        return -1;
                    }
                    return o1.getWeight() - o2.getWeight();
                });

                permissions.forEach(permission -> {
                    if (permission.getEnable()) {//可用状态
                        if (permission.getType().equals(Permission.Type.MENU)) {//是菜单
                            menus.add(permission);
                            urls.add(permission.getPath());
                        }
                        //获取用户拥有的权限
                        keys.add(permission.getPermissionKey());
                        urls.addAll(Arrays.asList(permission.getResource().split(",")));
                    }
                });

//                //树形数据转换
//                List<Menu> menuList = new ArrayList<>();
//                menus.forEach(permission -> {
//                    Menu m = new Menu();
//                    m.setId(permission.getId());
//                    m.setText(permission.getName());
//                    m.setHref(permission.getPath());
////                    m.setParentId(permission.getParent() == null ? null : permission.getParent().getId());
//                    m.setParentId(permission.getParent_id());
//                    menuList.add(m);
//                });

                List<Menus> menuList = new ArrayList<>();
                menus.forEach(permission -> {
                    Menus m = new Menus();
                    m.setMenuid(permission.getId() + "");
                    m.setMenuname(permission.getName());
                    m.setParentMenu(permission.getParent_id() + "");
                    m.setUrl(permission.getPath());
                    menuList.add(m);
                });

                List<Menus> json = new TreeBuilder().buildTree(menuList);

                session.setAttribute("user", user);
                session.setAttribute("menus", json);
                session.setAttribute("keys", keys);
                session.setAttribute("urls", urls);
                session.setAttribute("isSuper", superId == user.getId());
                ;

            } else {
                rda.addFlashAttribute("error", "账号和密码不匹配！");
                return "redirect:/toLogin";
            }
        } else {
            rda.addFlashAttribute("error", "账号不可用！");
            return "redirect:/toLogin";
        }
        return "redirect:/index";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/toLogin";
    }

    /**
     * 权限resource的js资源
     *
     * @param session
     * @return
     */
    @RequestMapping("/resource")
    public String login(HttpSession session, Model model) {
//        ObjectMapper mapper = new ObjectMapper();
        Object resourceKey = session.getAttribute("keys");
//        try {
//            model.addAttribute("resourceKey", mapper.writeValueAsString(resourceKey));
        model.addAttribute("resourceKey", resourceKey);
//        } catch (JsonProcessingException e) {
//            logger.error("json转换错误", e);
//        }
        return "resource";
    }

    @RequestMapping("/menus")
    @ResponseBody
    public List<Menu> menus(@SessionAttribute("menus") List<Menu> menuList) {
        return menuList;
    }
}