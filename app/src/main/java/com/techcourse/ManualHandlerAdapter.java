package com.techcourse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.interface21.webmvc.servlet.ModelAndView;
import com.interface21.webmvc.servlet.mvc.asis.Controller;
import com.interface21.webmvc.servlet.mvc.tobe.handlerAdapter.HandlerAdapter;
import com.interface21.webmvc.servlet.view.JspView;

public class ManualHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean support(Object handler) {
        return handler instanceof Controller;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String viewName = ((Controller)handler).execute(request, response);
        return new ModelAndView(new JspView(viewName));
    }
}
