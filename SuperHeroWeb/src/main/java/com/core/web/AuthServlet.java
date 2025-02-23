
package com.core.web;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//Clase Java con las librerias de Servlet
public class AuthServlet implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;
        HttpSession session = request.getSession();
       
        String loginURI = request.getContextPath() + "/index.jsp";
        if (session != null && session.getAttribute("user") != null) {
            fc.doFilter(sr, sr1);
        } else {
            response.sendRedirect(loginURI);
        }
    }
}

