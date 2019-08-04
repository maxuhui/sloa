package com.maxh.sloa.mapper;

import com.maxh.sloa.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleDao {

    List<Role> findByStatus(boolean enable);

    Role findByUid(Long id);


}
