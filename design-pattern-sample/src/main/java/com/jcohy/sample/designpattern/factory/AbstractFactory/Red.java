package com.jcohy.sample.designpattern.factory.AbstractFactory;

/**
 * @author jcohy
 *
 */
// tag::code[]
public class Red implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");

	}

}
// end::code[]