package com.jcohy.sample.designpattern.factory.AbstractFactory;


/**
 * @author jcohy
 *
 */
// tag::code[]
public class Square implements Shape{

	@Override
	public void draw() {
		 System.out.println("Inside Square::draw() method.");		
	}

}
// end::code[]