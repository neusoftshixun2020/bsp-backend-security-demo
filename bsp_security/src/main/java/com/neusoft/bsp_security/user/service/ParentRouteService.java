package com.neusoft.bsp_security.user.service;



import com.neusoft.bsp_security.user.entity.ParentRoute;
import com.neusoft.bsp_security.user.entity.User;

import java.util.List;
import java.util.Map;


public interface ParentRouteService {

    int insert(ParentRoute parentRoute);

    int update(ParentRoute parentRoute);

    int delete(int pk);

    ParentRoute getById(int parentRoute_id);

    List<ParentRoute> getAllByFilter(Map<String, Object> map);

    List<ParentRoute> getAll();

}
