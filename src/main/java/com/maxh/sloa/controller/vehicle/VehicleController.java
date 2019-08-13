package com.maxh.sloa.controller.vehicle;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maxh.sloa.entity.vehicle.Vehicle;
import com.maxh.sloa.mapper.VehicleDao;
import com.maxh.sloa.util.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleDao vehicleDao;
    @RequestMapping("/vehicleList")
    public String index() {
        return "vehicle/vehicle";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int rows, Vehicle vehicle) {
  
        PageHelper.startPage(page, rows); //开始起始页
        List<Vehicle> list = vehicleDao.findAll(vehicle); // 获取数据
        //创建返回结果对象
        PageInfo<Vehicle> pageInfo = new PageInfo<Vehicle>(list); // 实例化PageInfo
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }
}
