package com.jcohy.sample.designpattern.factory.AbstractFactory;

/**
 * @author jcohy
 *
 */
// tag::code[]
public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}
// end::code[]