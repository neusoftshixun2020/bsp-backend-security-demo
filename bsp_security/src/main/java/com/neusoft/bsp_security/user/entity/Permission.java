package com.neusoft.bsp_security.user.entity;

import com.neusoft.bsp_security.common.base.BaseEntity;

public class Permission implements BaseEntity<Integer> {
    int permission_id;
    int role_id;
    int parent_route_id;
    int route_id;
    ParentRoute parentRoute;
    ChildrenRoute childrenRoute;

    @Override
    public Integer getId() {
        return permission_id;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getParent_route_id() {
        return parent_route_id;
    }

    public void setParent_route_id(int parent_route_id) {
        this.parent_route_id = parent_route_id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public ParentRoute getParentRoute() {
        return parentRoute;
    }

    public void setParentRoute(ParentRoute parentRoute) {
        this.parentRoute = parentRoute;
    }

    public ChildrenRoute getChildrenRoute() {
        return childrenRoute;
    }

    public void setChildrenRoute(ChildrenRoute childrenRoute) {
        this.childrenRoute = childrenRoute;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permission_id=" + permission_id +
                ", role_id=" + role_id +
                ", parent_route_id=" + parent_route_id +
                ", route_id=" + route_id +
                ", parentRoute=" + parentRoute +
                ", childrenRoute=" + childrenRoute +
                '}';
    }
}
