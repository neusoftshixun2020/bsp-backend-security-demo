package com.neusoft.bsp_security.user.service.impl;


import com.neusoft.bsp_security.user.entity.User;
import com.neusoft.bsp_security.user.mapper.UserMapper;
import com.neusoft.bsp_security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public  int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(String pk) {
        return userMapper.delete(pk);
    }

    @Override
    public  User getById(String userid) {
        return userMapper.getById(userid);
    }

    @Override
    public List<User> getAllByFilter(Map<String, Object> map) {
        return userMapper.getAllByFilter(map);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

}
