package com.yan.client;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class JavaClientApplication {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> map = new HashMap<>();
        map.put("author", "李白");

        String str = restTemplate.getForObject("http://localhost:8083/poet?author={author}", String.class, map);
        System.out.println(str);
    }

}
