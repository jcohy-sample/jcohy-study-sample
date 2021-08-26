package com.jcohy.sample.designpattern.prototype;

// tag::code[]
public class Test {

	public static void main(String[] args) {
		Prototype pro = new ConcretePrototype("大骗子");
		Prototype pro1 = (Prototype) pro.clone();
		System.out.println(pro.getName());
		System.out.println(pro1.getName());
	}

}
// end::code[]