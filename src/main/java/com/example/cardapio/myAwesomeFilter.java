package com.example.cardapio;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class myAwesomeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)  throws ServletException, IOException {

        response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.addHeader("pragma", "no-cache");
        filterChain.doFilter(request, response);
    }
}