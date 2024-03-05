package com.example.cardapio;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@Order(Integer.MIN_VALUE)
public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        headers.add("Access-Control-Allow-Headers", "*");
        headers.add("Access-Control-Allow-Credentials", "true");

        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String headerName = entry.getKey();
            List<String> headerValues = entry.getValue();
            for (String headerValue : headerValues) {
                wrappedResponse.setHeader(headerName, headerValue);
            }
        }

        filterChain.doFilter(request, wrappedResponse);
        wrappedResponse.copyBodyToResponse();
    }
}
