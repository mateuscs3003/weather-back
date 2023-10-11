package com.example.demo.config;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.MDC;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            MDC.put("host", request.getRemoteHost());
            MDC.put("ip", request.getRemoteAddr());
            MDC.put("url", request.getRequestURI());

            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("host");
            MDC.remove("ip");
            MDC.remove("url");
        }
    }
}

