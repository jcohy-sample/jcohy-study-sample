package com.jcohy.sample.designpattern.adapter;

/**
 * Copyright : 2017- www.jcohy.com Created by jcohy on 23:48 2018/8/7 Email:
 * jia_chao23@126.com Description:
 **/
// tag::code[]
class Adapter extends Adaptee implements Target {

	public void request() {
		super.specificRequest();
	}

}
// end::code[]