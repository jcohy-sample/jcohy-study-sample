package com.jcohy.sample.designpattern.factory.AbstractFactory;

/**
 * @author jcohy
 *
 */
// tag::code[]
public class Green implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Green::fill() method.");

	}

}
// end::code[]