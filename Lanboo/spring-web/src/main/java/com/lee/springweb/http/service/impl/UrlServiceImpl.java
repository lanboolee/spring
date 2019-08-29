package com.lee.springweb.http.service.impl;

import com.alibaba.fastjson.JSON;
import com.lee.springweb.http.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author lanboo
 * @date 2019/8/28 16:54
 */
@Service
@Slf4j
public class UrlServiceImpl implements UrlService {
    @Override
    public void getHtml() {
        String HTML = "https://www.xiashuwu.com/253355/read_1_3.html";
        Document parse = Jsoup.parse(HTML);
        Element elementById = parse.getElementById("tac");
        String content = elementById.toString();
        log.info(content);
    }

    @Override
    public String getContentByUrl() {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("https://www.xiashuwu.com/253355/read_2_3.html");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            String s = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            log.info(JSON.toJSONString(s));
            return s;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
