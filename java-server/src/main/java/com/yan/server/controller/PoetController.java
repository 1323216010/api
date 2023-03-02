package com.yan.server.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.io.FileUtils;
/**
 * @author yan
 **/
@RestController
public class PoetController {
    @GetMapping("/poet")
    public Map<String, Object> list() throws IOException {
        Map<String, Object> map = new HashMap<>();
        String separator = File.separator;
        ClassPathResource classPathResource = new ClassPathResource("json" + separator + "poet300.json");
        File file = classPathResource.getFile();

        //将file对象转为字符串
        String s = FileUtils.readFileToString(file);
        //将字符串解析为JSONObject对象
        JSONObject jsonObject = JSONObject.parseObject(s);
        //获取数组对象
        JSONArray sites = jsonObject.getJSONArray("sites");
        //遍历数组对象
        sites.forEach(x -> {
            System.out.println(x.toString());
        });
        //将json转为对象
        map = JSONObject.parseObject(s, HashMap.class);
        System.out.println(map);
        return map;
    }
}
