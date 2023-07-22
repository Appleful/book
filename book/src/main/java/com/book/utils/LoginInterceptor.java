package com.book.utils;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截器配置类
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");

        String uri = request.getRequestURI();
        if(account!=null){
            String servletPath = request.getServletPath();
            int role = (int)session.getAttribute("role");
            if(role==0 && !new UserPermissionUtil().checkPermissions(servletPath)){
                response.setContentType("text/html;charset=utf-8");
                PrintWriter writer = null;
                try {
                    writer = response.getWriter();
                    writer.println("<script>alert(\"权限不足，不可访问！\")</script>");
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    writer.close();
                }
                response.sendRedirect(request.getContextPath()+"/user/login");
                return false;
            }
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/");
        return false;
    }
}
