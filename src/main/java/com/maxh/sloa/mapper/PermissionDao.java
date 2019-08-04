package com.maxh.sloa.mapper;

import com.maxh.sloa.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PermissionDao {


    /**
     * 根据父节点找子节点
     *
     * @param enable
     * @return
     */
    Set<Permission> findAllByEnableOrderByWeightDesc(boolean enable);
    
    Permission findByRoleId(Long id);
}
