package com.maxh.sloa.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public class LoginInterceptor implements HandlerInterceptor {
    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI().replace(request.getContextPath(), "");
        if (null != excludedUrls && excludedUrls.size() >= 1) {
            for (String url : excludedUrls) {
                if (requestUri.contains(url)) {
                    System.out.println(url);
                    return true;
                }
            }
        }
        
        HttpSession session = request.getSession();
        //判断session中是否有用户信息
        if (session.getAttribute("user") == null) {
            if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
                //ajax请求
                response.sendError(401);
            } else {
                response.sendRedirect("index.jsp");
            }
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
