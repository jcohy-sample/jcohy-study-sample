package com.jcohy.sample.designpattern.iterator;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
/**
 * 执行递增，遍历的接口
 * @author jcohy
 */
public interface Iterator {
	public abstract boolean hashNext();
	public abstract Object next();
}
// end::code[]