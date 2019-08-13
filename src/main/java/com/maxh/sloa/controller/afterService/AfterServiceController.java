package com.maxh.sloa.controller.afterService;

import com.maxh.sloa.mapper.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/afterService")
public class AfterServiceController {
    @Autowired
    VehicleDao vehicleDao;

    @RequestMapping("/service")
    public String index() {
        return "afterService/service";
    }

}
