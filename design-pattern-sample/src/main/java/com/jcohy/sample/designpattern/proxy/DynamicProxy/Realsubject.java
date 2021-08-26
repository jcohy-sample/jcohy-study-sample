package com.jcohy.sample.designpattern.proxy.DynamicProxy;

/**
 * @author jcohy
 *
 */
public class Realsubject implements Subject {

	@Override
	public void Request() {
		System.out.println("Relsubject");
	}

	@Override
	public void rent() {
		System.out.println("I want to rent my house");
	}

	@Override
	public void sayHello(String str) {
		System.out.println(str);
	}

}
