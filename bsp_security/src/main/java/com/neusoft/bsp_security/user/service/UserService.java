package com.neusoft.bsp_security.user.service;



import com.neusoft.bsp_security.user.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {

    int insert(User user);

    int update(User user);

    int delete(String pk);

    User getById(String userid);

    List<User> getAllByFilter(Map<String, Object> map);

    List<User> getAll();

}
