package com.jcohy.sample.designpattern.proxy.example2;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0 Description 2020/4/7 14:35
 */
// tag::code[]
public class RealSubject implements Subject {

	@Override
	public void method() {
		System.out.println("afternoon");
	}

}
// end::code[]