package com.yan.server.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yan
 **/
@RestController
public class PoetController {
    @GetMapping ("/poet")
    public List<Map<String, Object>> list(@RequestBody Map<String, Object> map) {
        String separator = File.separator;
        String path = System.getProperty("user.dir") + separator + "src" + separator + "main" + separator +
                "resources" + separator + "json" + separator + "poet300.json";

        File file = new File(path);
        String str = null;
        try {
            str = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Map<String, Object>> list1 = JSON.parseObject(str, new TypeReference<List<Map<String, Object>>>() {
        });
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list1.size(); ++i) {
            if (list1.get(i).get("author").toString().equals(map.get("author").toString())) {
                list2.add(list1.get(i));
            }
        }
        return list2;
    }

}
