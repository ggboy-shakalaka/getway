package com.ggboy.gatway.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class ResponseParam {
    private String code;
    private String message;
    private Object data;

    public ResponseParam (String code, String message, Object data) {
        this.code = code; this.message = message; this.data = data;
    }

    public final static ResponseParam success(Object data) {
        return new ResponseParam(null, null, data);
    }
}