package com.ggboy.api.domain.demo;

import com.ggboy.api.domain.RequestParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoParam extends RequestParam {
    private String name;
}