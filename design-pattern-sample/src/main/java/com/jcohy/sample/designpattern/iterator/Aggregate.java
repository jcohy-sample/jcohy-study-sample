package com.jcohy.sample.designpattern.iterator;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
/**
 * 一个执行递增的 "聚合" ，实现此接口的类就变成类似数组的 "多个数字或者变量的聚合"
 *
 * @author jcohy
 */
public interface Aggregate {

	public abstract Iterator iterator();

}
// end::code[]