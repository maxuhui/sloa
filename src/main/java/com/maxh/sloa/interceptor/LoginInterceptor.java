package com.maxh.sloa.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    Logger LOGGER = Logger.getLogger(LoginInterceptor.class);
    private List<String> excludedUrls;
    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //如果是方法请求，则进行统计
        if (handler instanceof HandlerMethod) {
            //获取方法执行前时间
            Long now = System.currentTimeMillis();
            startTime.set(now);

            //格式化当前时间，以便输出
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String methodTime = sdf.format(new Date(now));

            //获取Controller
            String controller = ((HandlerMethod) handler).getBean().getClass().getName();
            //获取方法
            Method mehtod = ((HandlerMethod) handler).getMethod();
            //获取URI
            String uri = request.getRequestURI();
            //获取请求类型 POST 、PUT 、GET等等
            String type = request.getMethod();

            //获取请求参数
            //将request的body信息放到缓存读取器中
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            //创建缓存字符串存储request的body信息
            StringBuffer stringBuffer = new StringBuffer();
            //将bufferedReader的数据读取到stringBuffer中
            String line;
            while (null != (line = bufferedReader.readLine())) {
                stringBuffer.append(line);
            }
            String parameters = stringBuffer.toString();

            //组合信息
            StringBuffer sb = new StringBuffer();
            sb.append("\n------------------------------------------------------------------------------");
            sb.append(methodTime);
            sb.append("--------------------------------------------------------------------------------");
            sb.append("\n----------Controller   :").append(controller);
            sb.append("\n----------Method       :[").append(mehtod);
            sb.append("\n----------Parameters   :").append(parameters);
            sb.append("\n----------URI          :[").append(uri);
            sb.append("\n------------------------------------------------------------------------------");
            sb.append("-------------------");
            sb.append("--------------------------------------------------------------------------------");
            LOGGER.info(sb.toString());
        }
        String requestUri = request.getRequestURI().replace(request.getContextPath(), "");
        if (null != excludedUrls && excludedUrls.size() >= 1) {
            for (String url : excludedUrls) {
                if (requestUri.contains(url)) {
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
        //如果是方法请求，则进行统计
        if (handler instanceof HandlerMethod) {
            //获取方法用时
            Long now = System.currentTimeMillis();
            Long useTime = now - startTime.get();
            //格式化当前日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String endTime = sdf.format(new Date(now));
            //获取URI
            String uri = request.getRequestURI();
            //获取请求类型 POST 、PUT 、GET等等
            String type = request.getMethod();
            //组合信息
            StringBuffer sb = new StringBuffer();
            sb.append("========{").append(endTime).append(",URI = [").append(uri).append("],method = ").append(true)
                    .append(",").append("Use Time : ").append(useTime).append(" 毫秒}\n");
            LOGGER.info(sb.toString());
        }
    }
}
