package com.neusoft.bsp_security.user.mapper;

import com.neusoft.bsp_security.common.base.BaseMapper;
import com.neusoft.bsp_security.user.entity.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper extends BaseMapper<Integer, Permission> {
}
