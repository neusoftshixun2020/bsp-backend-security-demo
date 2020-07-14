package com.neusoft.bsp_security.user.mapper;

import com.neusoft.bsp_security.common.base.BaseMapper;
import com.neusoft.bsp_security.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<String, User> {
}
