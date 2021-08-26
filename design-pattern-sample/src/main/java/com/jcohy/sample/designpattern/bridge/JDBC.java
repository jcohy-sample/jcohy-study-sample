package com.jcohy.sample.designpattern.bridge;

/**
 * Copyright : 2017- www.jcohy.com Created by jcohy on 23:48 2018/8/7 Email:
 * jia_chao23@126.com Description:
 **/
// tag::code[]
public abstract class JDBC {

	private Dirver dirver;

	public void connection() {
		dirver.connection();
	}

	public Dirver getDirver() {
		return dirver;
	}

	public void setDirver(Dirver dirver) {
		this.dirver = dirver;
	}

}
// end::code[]