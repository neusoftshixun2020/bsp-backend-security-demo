package com.neusoft.bsp_security.user.entity;

import com.neusoft.bsp_security.common.base.BaseEntity;

public class ChildrenRoute implements BaseEntity<Integer> {
    int children_route_id;
    int parent_route_id;
    String children_route_path;
    String children_route_name;

    @Override
    public Integer getId() {
        return children_route_id;
    }

    public int getChildren_route_id() {
        return children_route_id;
    }

    public void setChildren_route_id(int children_route_id) {
        this.children_route_id = children_route_id;
    }

    public int getParent_route_id() {
        return parent_route_id;
    }

    public void setParent_route_id(int parent_route_id) {
        this.parent_route_id = parent_route_id;
    }

    public String getChildren_route_path() {
        return children_route_path;
    }

    public void setChildren_route_path(String children_route_path) {
        this.children_route_path = children_route_path;
    }

    public String getChildren_route_name() {
        return children_route_name;
    }

    public void setChildren_route_name(String children_route_name) {
        this.children_route_name = children_route_name;
    }

    @Override
    public String toString() {
        return "ChildrenRoute{" +
                "children_route_id=" + children_route_id +
                ", parent_route_id=" + parent_route_id +
                ", children_route_path='" + children_route_path + '\'' +
                ", children_route_name='" + children_route_name + '\'' +
                '}';
    }
}
