package com.xencio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Maserhe
 * @date 2023/05/08 15:59
 **/
@RestController
public class test {


    @GetMapping("/test")
    public String testString() {
        return "123";
    }
}
