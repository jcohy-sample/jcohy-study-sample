package com.jcohy.sample.designpattern.adapter;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
public class ConcreteTarget implements Target {
    //// 具体目标类，只提供普通功能
    public void request() {
        System.out.println("普通类 具有 普通功能...");
    }
}
// end::code[]