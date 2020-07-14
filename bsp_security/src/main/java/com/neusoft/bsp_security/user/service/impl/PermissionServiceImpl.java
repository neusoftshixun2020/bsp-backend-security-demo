package com.neusoft.bsp_security.user.service.impl;


import com.neusoft.bsp_security.user.entity.Permission;
import com.neusoft.bsp_security.user.mapper.PermissionMapper;
import com.neusoft.bsp_security.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public int insert(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public  int update(Permission permission) {
        return permissionMapper.update(permission);
    }

    @Override
    public int delete(int pk) {
        return permissionMapper.delete(pk);
    }

    @Override
    public Permission getById(int permission_id) {
        return permissionMapper.getById(permission_id);
    }

    @Override
    public List<Permission> getAllByFilter(Map<String, Object> map) {
        return permissionMapper.getAllByFilter(map);
    }

    @Override
    public List<Permission> getAll() {
        return permissionMapper.getAll();
    }

}
