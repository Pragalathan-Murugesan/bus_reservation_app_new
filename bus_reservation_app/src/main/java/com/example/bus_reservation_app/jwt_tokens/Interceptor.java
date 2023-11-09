package com.example.bus_reservation_app.jwt_tokens;

import com.example.bus_reservation_app.global_exception.IlllegalAuthException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor implements HandlerInterceptor {
    @Autowired
    private TokenGeneration tokenGeneration;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwts = null;
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer")) {
            jwts = token.substring(7, token.length());
        }

        if (!(request.getRequestURI().contains("/user/api/signup")||request.getRequestURI().contains("user/api/login")||request.getRequestURI().contains("/api/trigger-webhook")
                ||request.getRequestURI().contains("/admin/api/adduserprofile")|| request.getRequestURI().contains("/admin/api/adminlogin"))){
            try {
               Claims claims = tokenGeneration.verifyToken(jwts);

                if (claims.getIssuer().equals("Admin")) {
                    if (!request.getRequestURI().contains("/admin/api")) {
                        throw new IlllegalAuthException();
                    }

                } else if (claims.getIssuer().equals("User")) {
                    if (!request.getRequestURI().contains("/user/api")) {
                        throw new IlllegalAuthException();
                    }
                }
            } catch (IllegalArgumentException e) {
                throw new IlllegalAuthException();
            }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
