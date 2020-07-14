package com.neusoft.bsp_security.shiro;

import com.neusoft.bsp_security.user.entity.Role;
import com.neusoft.bsp_security.user.entity.User;
import com.neusoft.bsp_security.user.service.RoleService;
import com.neusoft.bsp_security.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("执行认证逻辑" + "Authorization");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("admin");
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Role role = roleService.getById(user.getRole_id());
//        System.out.println("user.getRole_id()"+user.getRole_id());
//        System.out.println("role"+role);
        user.setRole(role);
        info.addStringPermission(role.getRole_name());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        System.out.println("执行认证逻辑" + "Authentication");
        UsernamePasswordToken token = (UsernamePasswordToken)arg0;
        System.out.println(token.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("username", token.getUsername());
        List<User> users = userService.getAllByFilter(map);
        if (users.size() == 0)
            return null;
        User user = users.get(0);
        Role role = roleService.getById(user.getRole_id());
//        System.out.println("user.getRole_id()"+user.getRole_id());
//        System.out.println("role"+role);
        user.setRole(role);
        return new SimpleAuthenticationInfo(users.get(0), users.get(0).getPassword(), "");
    }

}
