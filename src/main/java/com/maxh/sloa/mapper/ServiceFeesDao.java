package com.maxh.sloa.mapper;

import com.maxh.sloa.entity.vehicle.ServiceFees;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ServiceFeesDao {
    
    List<ServiceFees> findAll(ServiceFees serviceFees);
}
