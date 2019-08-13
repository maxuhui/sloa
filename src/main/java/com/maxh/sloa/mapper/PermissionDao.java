package com.maxh.sloa.mapper;

import com.maxh.sloa.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PermissionDao {

    List<Permission> findAllByEnableOrderByWeightDesc(boolean enable);

    /**
     * 查询角色下的资源
     * @param id
     * @return
     */
    List<Permission> findByRoleId(Long id);



    /**
     * 获取根节点
     *
     * @return
     */
    List<Permission> findAllByParentIsNull();
    

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Permission findOne(Long id);
    
    /**
     * 保存资源
     * @param permission
     */
    void save(Permission permission);

    /**
     * 删除
     * @param permission
     */
    void delete(Permission permission);

    List<Permission> findAllByParent();

    void update(Permission permission);
}
