package com.jcohy.sample.designpattern.factory.AbstractFactory;

/**
 * @author jcohy
 *
 */
// tag::code[]
public class Blue implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Blue::fill() method.");
	}

}
// end::code[]