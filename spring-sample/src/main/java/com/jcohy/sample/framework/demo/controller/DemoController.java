package com.jcohy.sample.framework.demo.controller;


import com.jcohy.sample.framework.demo.service.DemoService;
import com.jcohy.sample.framework.mvcframework.annotation.JcohyAutowired;
import com.jcohy.sample.framework.mvcframework.annotation.JcohyController;
import com.jcohy.sample.framework.mvcframework.annotation.JcohyRequestMapping;
import com.jcohy.sample.framework.mvcframework.annotation.JcohyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jiac on 2019/3/21.
 * ClassName  : com.jcohy.study.mvc.demo.controller
 * Description  :
 */
@JcohyController
public class DemoController {

    @JcohyAutowired
    private DemoService demoService;
    @JcohyRequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response,@JcohyRequestParam("name") String name) throws IOException {
       String result =  demoService.show(name);
       response.getWriter().write(result);
    }
}
