package com.neusoft.bsp_security.user.service.impl;


import com.neusoft.bsp_security.user.entity.ChildrenRoute;
import com.neusoft.bsp_security.user.mapper.ChildrenRouteMapper;
import com.neusoft.bsp_security.user.service.ChildrenRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChildrenRouteServiceImpl implements ChildrenRouteService {

    @Autowired
    ChildrenRouteMapper childrenRouteMapper;

    @Override
    public int insert(ChildrenRoute childrenRoute) {
        return childrenRouteMapper.insert(childrenRoute);
    }

    @Override
    public  int update(ChildrenRoute childrenRoute) {
        return childrenRouteMapper.update(childrenRoute);
    }

    @Override
    public int delete(int pk) {
        return childrenRouteMapper.delete(pk);
    }

    @Override
    public ChildrenRoute getById(int id) {
        return childrenRouteMapper.getById(id);
    }

    @Override
    public List<ChildrenRoute> getAllByFilter(Map<String, Object> map) {
        return childrenRouteMapper.getAllByFilter(map);
    }

    @Override
    public List<ChildrenRoute> getAll() {
        return childrenRouteMapper.getAll();
    }

}
