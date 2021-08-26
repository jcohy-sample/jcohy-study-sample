package com.jcohy.sample.designpattern.facade;

/**
 * Copyright : 2017- www.jcohy.com Created by jcohy on 23:48 2018/8/7 Email:
 * jia_chao23@126.com Description:
 **/
// tag::code[]
public class Client {

	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}

}
// end::code[]