package com.ggboy.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggboy.api.domain.RequestParam;
import com.ggboy.api.domain.ResponseParam;
import com.ggboy.api.exception.BusinessException;
import com.ggboy.api.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/base/api")
public class BaseApiController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private Map<String, BaseService<?>> serviceMap;

    @PostMapping(headers = "version=1.0")
    public Object action(@RequestBody(required = false) String body) throws IOException {
        BaseService service = serviceMap.get("demo_service");
        if (service == null)
            throw new BusinessException("");
        Class<? extends RequestParam> clazz = service.getParamClass();
        RequestParam requestParam = new ObjectMapper().readValue(body, clazz);
        requestParam.setUserId("翟卓群");
        return service.service(requestParam);
    }
}