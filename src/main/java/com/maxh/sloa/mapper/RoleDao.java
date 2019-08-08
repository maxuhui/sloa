package com.maxh.sloa.mapper;

import com.maxh.sloa.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Repository
public interface RoleDao {

    List<Role> findByStatus(boolean enable);

    Role findByUid(Long id);
    
    Role findOne(Long id);
    
    void save(Role role);

    List<Role>  findAll();

//    void permissionSave(Long roleId, Long[] permissionId);

    void deletePermissionByRole(Long roleId);

    void permissionSave(Map<String, Object> map);
}
