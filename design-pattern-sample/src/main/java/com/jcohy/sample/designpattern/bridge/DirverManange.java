package com.jcohy.sample.designpattern.bridge;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class DirverManange extends JDBC {

	public void connection() {
		getDirver().connection();
	}
}
