package com.maxh.sloa.controller.vehicle;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maxh.sloa.common.JsonResult;
import com.maxh.sloa.entity.vehicle.Vehicle;
import com.maxh.sloa.mapper.VehicleDao;
import com.maxh.sloa.util.EasyUIDataGridResult;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

import static org.springframework.util.ObjectUtils.isEmpty;

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
    @RequestMapping({"/form", "/load"})
    public String form(String id, Model model) {
        if (id != null) {
            //编辑
            Vehicle vehicle = vehicleDao.findOne(id);
            JSONObject entityJson = JSONObject.fromObject(vehicle);
            model.addAttribute("vehicle", entityJson);
        }
        return "vehicle/vehicleForm";
    }
    @RequestMapping("/form/save")
    @ResponseBody
    public JsonResult form(Vehicle vehicle) {
        if(isEmpty(vehicle.getId())){
            Vehicle ve= findByCarNumber(vehicle.getCarNumber().trim());
            if(!isEmpty(ve)){
                return JsonResult.error("车牌号已经存在");
            }
            vehicle.setId(UUID.randomUUID()+"");
            vehicleDao.save(vehicle);
        }else{
            vehicleDao.edit(vehicle);
        }
        return JsonResult.success();

    }
  
    @RequestMapping(value = "/findByCarNumber", method = { RequestMethod.POST })
    public Vehicle findByCarNumber(String carNumber) {
        Vehicle vehicle = new Vehicle();
        vehicle.setCarNumber(carNumber);
        return vehicleDao.queryOne(vehicle);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(String id) {
         if (!isEmpty(id)) {
             vehicleDao.deleteById(id);
            return JsonResult.success();
        }
        return JsonResult.error("数据不存在！");
    }
    
    
}
