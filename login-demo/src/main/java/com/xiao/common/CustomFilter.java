package com.xiao.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Carl-Xiao 2019-01-03
 * @description
 */
@Component
@Slf4j
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        String context = request.getContextPath();
        if (!context.equals("/")) {
            path = path.substring(context.length());
        }
        log.info("=====================" + path);
        if (path.contains("login") || path.contains("favicon.ico")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            log.info("preHandle============================");
            Cookie[] cookies = request.getCookies();
            String value = "0";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("info")) {
                        value = cookie.getValue();
                    }
                }
            }
            if ("1".equals(value)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setContentType("application/x-javascript;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print("fail");
                out.flush();
                out.close();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
