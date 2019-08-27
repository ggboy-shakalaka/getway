package com.ggboy.api.service;

import com.ggboy.api.domain.ResponseParam;
import com.ggboy.api.domain.demo.DemoParam;
import com.ggboy.api.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service("demo_service")
public class DemoService extends BaseService<DemoParam> {
    @Override
    void verify(DemoParam data) throws BusinessException {
    }

    @Override
    ResponseParam doService(DemoParam data) throws BusinessException {
        return ResponseParam.success("userId: " + data.getUserId() + ", name: " + data.getName());
    }
}