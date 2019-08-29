package com.lee.springweb.web;

import com.lee.springweb.http.service.JsoupExecute;
import com.lee.springweb.http.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanboo
 * @date 2019/8/28 11:11
 */
@RestController
public class TestController {
    @Autowired
    private UrlService urlService;
    @Autowired
    private JsoupExecute jsoupExecute;

    @GetMapping("test")
    public String test() {
        return jsoupExecute.getContent();

    }
}
