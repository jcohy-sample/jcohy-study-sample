package com.jcohy.sample.designpattern.singleton;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0 Description 2020/4/7 14:50
 */
public class Singleton2 {

	// tag::lazy1[]
	/**
	 * 第二种: 懒汉模式: 懒汉模式中单例是在需要的时候才去创建的，如果单例已经创建，再次调用获取接口将不会重新创建新的对象 而是直接返回之前创建的对象。
	 * 如果某个单例使用的次数少，并且创建单例消耗的资源较多，那么就需要实现单例的按需创建， 这个时候使用懒汉模式就是一个不错的选择。
	 * 但是这里的懒汉模式并没有考虑线程安全问题， 在多个线程可能会并发调用它的getInstance()方法，导致创建多个实例。 因此需要加锁解决线程同步问题
	 *
	 * 持有私有静态实例，防止被引用，此处赋值为 null，目的是实现延迟加载
	 */
	private static Singleton2 instance = null;

	private Singleton2() {
	}

	public static Singleton2 newInstance() {
		if (null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}

	// end::lazy1[]

	// tag::lazy2[]
	public static synchronized Singleton2 newInstance2() {
		if (null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}
	// end::lazy2[]

}
