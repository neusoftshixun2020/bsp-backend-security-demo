package com.neusoft.bsp_security.user.entity;

import com.neusoft.bsp_security.common.base.BaseEntity;

public class ParentRoute implements BaseEntity<Integer> {
    int parent_route_id;
    String parent_route_name;
    String parent_route_path;

    @Override
    public Integer getId() {
        return parent_route_id;
    }

    public int getParent_route_id() {
        return parent_route_id;
    }

    public void setParent_route_id(int parent_route_id) {
        this.parent_route_id = parent_route_id;
    }

    public String getParent_route_name() {
        return parent_route_name;
    }

    public void setParent_route_name(String parent_route_name) {
        this.parent_route_name = parent_route_name;
    }

    public String getParent_route_path() {
        return parent_route_path;
    }

    public void setParent_route_path(String parent_route_path) {
        this.parent_route_path = parent_route_path;
    }

    @Override
    public String toString() {
        return "ParentRoute{" +
                "parent_route_id=" + parent_route_id +
                ", parent_route_name='" + parent_route_name + '\'' +
                ", parent_route_path='" + parent_route_path + '\'' +
                '}';
    }
}
