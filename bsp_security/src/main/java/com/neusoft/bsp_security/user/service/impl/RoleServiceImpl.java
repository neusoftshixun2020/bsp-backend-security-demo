package com.neusoft.bsp_security.user.service.impl;


import com.neusoft.bsp_security.user.entity.Role;
import com.neusoft.bsp_security.user.mapper.RoleMapper;
import com.neusoft.bsp_security.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public  int update(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int delete(int pk) {
        return roleMapper.delete(pk);
    }

    @Override
    public Role getById(int role_id) {
        return roleMapper.getById(role_id);
    }

    @Override
    public List<Role> getAllByFilter(Map<String, Object> map) {
        return roleMapper.getAllByFilter(map);
    }

    @Override
    public List<Role> getAll() {
        return roleMapper.getAll();
    }

}
