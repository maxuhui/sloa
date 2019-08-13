package com.maxh.sloa.mapper;

import com.maxh.sloa.entity.vehicle.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDao {
    /**
     * 车辆列表
     * @param vehicle
     * @return
     */
    List<Vehicle> findAll(Vehicle vehicle);
}
