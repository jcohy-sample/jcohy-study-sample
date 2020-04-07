package com.jcohy.sample.designpattern.facade;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
public class Disk {
	public void startup() {
		System.out.println("disk startup");
	}

	public void shutdown() {
		System.out.println("disk shutdown");
	}
}
// end::code[]