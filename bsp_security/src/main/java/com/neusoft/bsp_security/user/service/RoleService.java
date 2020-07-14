package com.neusoft.bsp_security.user.service;



import com.neusoft.bsp_security.user.entity.Role;
import com.neusoft.bsp_security.user.entity.User;

import java.util.List;
import java.util.Map;


public interface RoleService {

    int insert(Role role);

    int update(Role role);

    int delete(int pk);

    Role getById(int role_id);

    List<Role> getAllByFilter(Map<String, Object> map);

    List<Role> getAll();

}
