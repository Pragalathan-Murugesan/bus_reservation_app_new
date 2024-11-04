package com.example.bus_reservation_app.jwt_tokens;

import com.example.bus_reservation_app.global_exception.IllegalAuthException;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.regex.Pattern;

@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    private TokenGeneration tokenGeneration;

    private static final Pattern OPEN_PATHS = Pattern.compile(
            "(/swagger-ui.*|/v3/api-docs.*|/user/api/signup|/user/api/login|" +
                    "/api/trigger-webhook|/admin/api/adduserprofile|/admin/api/adminlogin)"
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String token = request.getHeader("Authorization");

        // Allow access without token for open paths
        if (OPEN_PATHS.matcher(uri).matches()) {
            return true;
        }

        // Check for JWT token in Authorization header
        if (token == null || !token.startsWith("Bearer ")) {
            throw new IllegalArgumentException("JWT token is missing");
        }

        String jwts = token.substring(7); // Remove "Bearer " prefix
        try {
            Claims claims = tokenGeneration.verifyToken(jwts);

            // Check issuer-specific path access
            if ("Admin".equals(claims.getIssuer()) && !uri.startsWith("/admin/api")) {
                throw new IllegalAuthException();
            } else if ("User".equals(claims.getIssuer()) && !uri.startsWith("/user/api")) {
                throw new IllegalAuthException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalAuthException();
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
