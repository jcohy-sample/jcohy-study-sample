package com.jcohy.sample.designpattern.bridge;

/**
 * Copyright : 2017- www.jcohy.com Created by jcohy on 23:48 2018/8/7 Email:
 * jia_chao23@126.com Description:
 **/
// tag::code[]
public class SqlSerDirver implements Dirver {

	@Override
	public void connection() {
		System.out.println("implement sqlserver connection");

	}

}
// end::code[]