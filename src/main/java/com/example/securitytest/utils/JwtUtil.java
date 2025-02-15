package com.example.securitytest.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWTVerifier;
import java.util.Date;

public class JwtUtil {
    private static final String KEY = "username";
    private static final int VALID_DAY = 1;
    private static final String JWT_KEY = "abc";

    public static String createToken(String value) {
        long nowMillis = System.currentTimeMillis();
        long dayMillis = VALID_DAY * 24 * 60 * 60 * 1000;
        long validMillis = nowMillis + dayMillis;
        Date date = new Date(validMillis);
        String token = JWT.create()
                .withClaim(KEY, value)
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(JWT_KEY));
        return token;
    }

    public static String getValue(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JWT_KEY)).build();
        DecodedJWT verify = jwtVerifier.verify(token);
        return verify.getClaim(KEY).asString();
    }

    public static void verify(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JWT_KEY)).build();
        jwtVerifier.verify(token);
    }
}
