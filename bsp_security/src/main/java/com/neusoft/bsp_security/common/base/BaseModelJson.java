package com.neusoft.bsp_security.common.base;

public class BaseModelJson<T> extends BaseModel {

    public T data;

    @Override
    public String toString() {
        return "BaseModelJson{" +
                "data=" + data +
                '}';
    }
}
