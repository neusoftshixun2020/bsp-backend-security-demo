package com.neusoft.bsp_security.user.service.impl;


import com.neusoft.bsp_security.user.entity.ParentRoute;
import com.neusoft.bsp_security.user.mapper.ParentRouteMapper;
import com.neusoft.bsp_security.user.service.ParentRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ParentRouteServiceImpl implements ParentRouteService {

    @Autowired
    ParentRouteMapper parentRouteMapper;

    @Override
    public int insert(ParentRoute parentRoute) {
        return parentRouteMapper.insert(parentRoute);
    }

    @Override
    public  int update(ParentRoute parentRoute) {
        return parentRouteMapper.update(parentRoute);
    }

    @Override
    public int delete(int pk) {
        return parentRouteMapper.delete(pk);
    }

    @Override
    public  ParentRoute getById(int id) {
        return parentRouteMapper.getById(id);
    }

    @Override
    public List<ParentRoute> getAllByFilter(Map<String, Object> map) {
        return parentRouteMapper.getAllByFilter(map);
    }

    @Override
    public List<ParentRoute> getAll() {
        return parentRouteMapper.getAll();
    }

}
