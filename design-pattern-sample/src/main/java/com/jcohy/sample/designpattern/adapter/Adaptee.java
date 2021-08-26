package com.jcohy.sample.designpattern.adapter;

/**
 * Copyright : 2017- www.jcohy.com Created by jcohy on 23:48 2018/8/7 Email:
 * jia_chao23@126.com Description:已存在的、具有特殊功能、但不符合我们既有的标准接口的类
 **/
// tag::code[]
class Adaptee {

	//// 已存在的、具有特殊功能、但不符合我们既有的标准接口的类
	public void specificRequest() {
		System.out.println("被适配类具有 特殊功能...");
	}

}
// end::code[]
