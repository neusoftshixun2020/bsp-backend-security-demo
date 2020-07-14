package com.neusoft.bsp_security.user.service;


import com.neusoft.bsp_security.user.entity.ChildrenRoute;

import java.util.List;
import java.util.Map;


public interface ChildrenRouteService {

    int insert(ChildrenRoute childrenRoute);

    int update(ChildrenRoute ChildrenRoute);

    int delete(int pk);

    ChildrenRoute getById(int childrenRoute_id);

    List<ChildrenRoute> getAllByFilter(Map<String, Object> map);

    List<ChildrenRoute> getAll();

}
