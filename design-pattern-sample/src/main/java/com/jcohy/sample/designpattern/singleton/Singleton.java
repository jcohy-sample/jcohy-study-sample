package com.jcohy.sample.designpattern.singleton;

/**
 * 下面前四种方法都有以下缺点: 1. 需要额外的工作来实现序列化，否则每次反序列化一个序列化的对象时都会创建一个新的实例。
 * 2.可以使用反射强行调用私有构造器(如果要避免这种情况，可以修改构造器，让它在创建第二个实例的时候抛异常)。
 * 而枚举类很好的解决了这两个问题，使用枚举除了线程安全和防止反射调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。
 * 双重校验锁和静态内部类的方式可以解决大部分问题，平时工作中使用的最多的也是这两种方式。
 *
 * @author jcohy
 *
 */
public class Singleton {

	// tag::code[]
	/**
	 *
	 * 第一种: 饿汉模式 饿汉模式在类加载的时候就对实例进行创建，实例在整个程序周期都存在。
	 * 它的好处是只在类加载的时候创建一次实例，不会存在多个线程创建多个实例的情况，避免了多线程同步的问题。
	 * 它的缺点也很明显，即使这个单例没有用到也会被创建，而且在类加载之后就被创建，内存就被浪费了。
	 *
	 * 持有私有静态实例，防止被引用，此处赋值为 null，目的是实现延迟加载
	 *
	 * 私有划静态方法
	 */
	//
	private static Singleton instance = new Singleton();

	//
	private Singleton() {
	}

	public static Singleton newInstance() {
		return instance;
	}

	// end::code[]

}
