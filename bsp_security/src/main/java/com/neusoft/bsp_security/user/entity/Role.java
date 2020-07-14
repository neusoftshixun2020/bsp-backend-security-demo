package com.neusoft.bsp_security.user.entity;

import com.neusoft.bsp_security.common.base.BaseEntity;

public class Role implements BaseEntity<Integer> {
    int role_id;
    String role_name;
    String role_path;

    @Override
    public Integer getId() {
        return role_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_path() {
        return role_path;
    }

    public void setRole_path(String role_path) {
        this.role_path = role_path;
    }

    @Override
    public String toString() {
        return "role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_path='" + role_path + '\'' +
                '}';
    }
}
