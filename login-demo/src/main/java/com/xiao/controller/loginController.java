package com.xiao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Carl-Xiao 2019-01-03
 * @description
 */
@RestController
public class loginController {
    @RequestMapping(value = "login",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@RequestParam(value = "name") String name,
                        @RequestParam(value = "password") String password,HttpServletResponse response) {
        if ("admin".equals(name) && "admin".equals(password)) {
            Cookie cookie = new Cookie("info","1");
            cookie.setDomain("localhost");
            cookie.setPath("/");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            return "success";
        }
        return "fail";
    }

}
