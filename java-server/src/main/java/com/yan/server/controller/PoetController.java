package com.yan.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yan
 **/
@RestController
public class PoetController {
    @GetMapping("/poet")
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        String separator = File.separator;
        String path = System.getProperty("user.dir") + separator + "src" + separator + "main" + separator +
                "resources" + separator + "json" + separator + "poet300.json";
        System.out.println(path);
        return map;
    }
}
