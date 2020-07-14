package com.neusoft.bsp_security.controller;

import com.neusoft.bsp_security.common.base.BaseController;
import com.neusoft.bsp_security.common.base.BaseModelJson;
import com.neusoft.bsp_security.user.entity.ChildrenRoute;
import com.neusoft.bsp_security.user.entity.ParentRoute;
import com.neusoft.bsp_security.user.entity.Permission;
import com.neusoft.bsp_security.user.entity.Role;
import com.neusoft.bsp_security.user.service.ChildrenRouteService;
import com.neusoft.bsp_security.user.service.ParentRouteService;
import com.neusoft.bsp_security.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    ParentRouteService parentRouteService;

    @Autowired
    ChildrenRouteService childrenRouteService;


    @PostMapping("getPermissionRoute")
    public BaseModelJson<List<Permission>> getPermissionRoute(@RequestBody Role role) {
        Map<String, Object> map = new HashMap<>();
        map.put("role_id", role.getRole_id());
        List<Permission> permissions = permissionService.getAllByFilter(map);
        for (Permission permission:permissions) {
            ParentRoute parentRoute = parentRouteService.getById(permission.getParent_route_id());
            ChildrenRoute childrenRoute = childrenRouteService.getById(permission.getRoute_id());
            permission.setParentRoute(parentRoute);
            permission.setChildrenRoute(childrenRoute);
        }
        BaseModelJson<List<Permission>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = permissions;
        return result;
    }
}
