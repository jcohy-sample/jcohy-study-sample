package com.jcohy.gateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Copyright: Copyright (c) 2019 http://www.jcohy.com
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/12 9:31
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/12      jiac           v1.0.0               修改原因
 */


public class JwtUtil {

    private static String SECRET = "d3d3Lnh1YW53dWFpLmNu";
    private static String TOKEN_PREFIX = "Bearer";
    public static String HEADER_AUTH = "Authorization";

    public static String generateToken(String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", new Random().nextInt());
        map.put("user", name);

        String jwt = Jwts.builder().setSubject("user info").addClaims(map)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return TOKEN_PREFIX + " " + jwt;
    }

    public static Map<String,String> validateToken(String token) {
        if (token != null) {
            HashMap<String, String> map = new HashMap<String, String>();
            Map<String,Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();

            String id =  String.valueOf(body.get("id"));
            String user = (String) (body.get("user"));
            map.put("id", id);
            map.put("user", user);
            if(StringUtils.isEmpty(user)) {
                throw new PermissionException("user is error, please check");
            }
            return map;
        }else {
            throw new PermissionException("token is error, please check");
        }
    }
}
