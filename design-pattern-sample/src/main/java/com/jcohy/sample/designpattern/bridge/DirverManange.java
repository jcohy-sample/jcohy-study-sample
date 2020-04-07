package com.jcohy.sample.designpattern.bridge;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
public class DirverManange extends JDBC {

	@Override
	public void connection() {
		getDirver().connection();
	}
}
// end::code[]