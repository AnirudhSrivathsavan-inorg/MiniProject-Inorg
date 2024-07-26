package com.inorg.miniproject.filter;

import org.springframework.security.core.context.SecurityContextHolder;

import lombok.extern.slf4j.Slf4j;
import jakarta.servlet.*;
import org.springframework.security.core.Authentication;

import java.io.IOException;

@Slf4j
public class AuthoritiesLoggingAfterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            log.info("User:{}", authentication.getName());
        }

        filterChain.doFilter(request,response);
    }
}