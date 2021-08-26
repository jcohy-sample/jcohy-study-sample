package com.jcohy.sample.designpattern.proxy.example2;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0 Description 2020/4/7 14:35
 */
// tag::code[]
public class Proxy implements Subject {

	private RealSubject realSubject;

	public Proxy() {
		realSubject = new RealSubject();
	}

	public void after() {
		System.out.println("Good Night!");
	}

	@Override
	public void method() {
		before();
		realSubject.method();
		after();
	}

	public void before() {
		System.out.println("Hello Moring");
	}

}
// end::code[]
