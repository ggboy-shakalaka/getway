package com.ggboy.gatway.service;

import com.ggboy.gatway.domain.RequestParam;
import com.ggboy.gatway.domain.ResponseParam;
import com.ggboy.gatway.exception.BusinessException;

import java.lang.reflect.ParameterizedType;

public abstract class BaseService<T extends RequestParam> {
    @SuppressWarnings("unchecked")
    public final ResponseParam service(RequestParam param) {
        T data = (T) param;
        verify(data);
        return doService(data);
    }

    abstract void verify(T data) throws BusinessException;
    abstract ResponseParam doService(T data) throws BusinessException;

    @SuppressWarnings("unchecked")
    public Class<T> getParamClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}