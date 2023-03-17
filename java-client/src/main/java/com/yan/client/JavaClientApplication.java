package com.yan.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class JavaClientApplication {

    public static void main(String[] args) {
        RestTemplate rest = new RestTemplate();

        Map<String, Object> map = new HashMap<>();
        map.put("author", "李白");

        String str = rest.getForObject("http://localhost:8083/poet?author={author}", String.class, map);
        System.out.println(str);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImY1NGFmN2UwLWY1M2YtNDlkNy1iZWM5LWEzMTZkM2E2ZTUwOSJ9.jRDJuRoVsCMEaT-SefzvkrgH9b6FMoArPqMfPvg44P4wq1GMzx6sLmxIMp79gztSuwWk8liIlkFaFN3iXJfC0g");

        Map<String, Object> body = new HashMap<>();
        body.put("author", "李白");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, httpHeaders);
        str = rest.postForObject("http://localhost:8083/poet", request, String.class);
        System.out.println(str);
    }

}
