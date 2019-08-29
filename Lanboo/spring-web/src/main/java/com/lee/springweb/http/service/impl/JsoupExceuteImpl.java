package com.lee.springweb.http.service.impl;

import com.alibaba.fastjson.JSON;
import com.lee.springweb.http.service.JsoupExecute;
import com.lee.springweb.http.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lanboo
 * @date 2019/8/28 18:05
 */
@Service
@Slf4j
public class JsoupExceuteImpl implements JsoupExecute {

    @Autowired
    private UrlService urlService;

    @Override
    public String getContent() {
        String html = urlService.getContentByUrl();
        Document parse = Jsoup.parse(html);
        Element tac = parse.getElementById("tac");
        String cleanContent = JSON.toJSONString(tac);
       log.info(cleanContent);
       return cleanContent;
    }
}
