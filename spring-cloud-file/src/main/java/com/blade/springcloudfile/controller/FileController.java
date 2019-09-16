package com.blade.springcloudfile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyq
 * @create 6/18/19
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @GetMapping("/test")
    public String test() {
        return "this is file";
    }

}
