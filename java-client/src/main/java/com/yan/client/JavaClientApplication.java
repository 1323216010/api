package com.yan.client;

import com.alibaba.fastjson2.JSON;
import com.yan.client.config.RequestFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//@SpringBootApplication
public class JavaClientApplication {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new RequestFactory());

        Map<String, Object> map = new HashMap<>();
        map.put("author", "李白");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(map), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8083/poet", HttpMethod.GET, httpEntity, String.class);
        System.out.println(responseEntity);
//        SpringApplication.run(JavaClientApplication.class, args);
    }

}
