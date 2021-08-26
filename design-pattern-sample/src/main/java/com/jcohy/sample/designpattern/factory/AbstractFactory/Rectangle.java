package com.jcohy.sample.designpattern.factory.AbstractFactory;

/**
 * @author jcohy
 *
 */
// tag::code[]
public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

}
// end::code[]