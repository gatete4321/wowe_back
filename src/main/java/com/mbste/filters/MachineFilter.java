package com.mbste.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MachineFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("remote host:"+servletRequest.getRemoteAddr());
        System.out.println("remote address: "+servletRequest.getRemoteHost());
        System.out.println("remote host:"+servletRequest.getProtocol());
        System.out.println("the local port "+servletRequest.getLocalPort());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
