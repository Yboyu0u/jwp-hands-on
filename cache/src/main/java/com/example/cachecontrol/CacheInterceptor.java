package com.example.cachecontrol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CacheInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (!response.containsHeader(HttpHeaders.CACHE_CONTROL)) {
            final String cacheControl = CacheControl
                    .noCache()
                    .cachePrivate()
                    .getHeaderValue();
            response.addHeader(HttpHeaders.CACHE_CONTROL, cacheControl);
        }
    }
}
