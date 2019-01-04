package com.xiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Carl-Xiao 2019-01-03
 * @description
 */
@Controller
public class AdminController {

    @RequestMapping(value = "admin")
    public String admin() {








        return "admin";
    }

}
