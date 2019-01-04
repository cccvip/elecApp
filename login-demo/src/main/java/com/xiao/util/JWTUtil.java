package com.xiao.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * @author Carl-Xiao 2019-01-03
 * @description xiaobowen@newrank.cn
 */
public class JWTUtil {
    public static String getToken(String name,String password) {
        String token="";
        token= JWT.create().withAudience(name)
                .sign(Algorithm.HMAC256(password));
        return token;
    }

    public static void main(String[] args) {

        System.out.println(getToken("admin","admin"));

    }



}
