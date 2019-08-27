package com.ggboy.api.service;

import com.ggboy.api.domain.RequestParam;
import com.ggboy.api.domain.ResponseParam;
import com.ggboy.api.exception.BusinessException;

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