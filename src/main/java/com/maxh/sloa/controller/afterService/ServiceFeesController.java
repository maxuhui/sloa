package com.maxh.sloa.controller.afterService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maxh.sloa.entity.vehicle.ServiceFees;
import com.maxh.sloa.mapper.ServiceFeesDao;
import com.maxh.sloa.mapper.VehicleDao;
import com.maxh.sloa.util.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/serviceFees")
public class ServiceFeesController {
    @Autowired
    ServiceFeesDao serviceFeesDao;

    @RequestMapping("/index")
    public String index() {
        return "serviceFees/serviceFees";
    }
    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int rows, ServiceFees serviceFees) {

        String orderBy = "sf_time desc";
        PageHelper.startPage(page, rows,orderBy); //开始起始页
        List<ServiceFees> list = serviceFeesDao.findAll(serviceFees); // 获取数据
        //创建返回结果对象
        PageInfo<ServiceFees> pageInfo = new PageInfo<ServiceFees>(list); // 实例化PageInfo
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }
}
