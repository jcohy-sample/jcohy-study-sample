package com.jcohy.sample.designpattern.factory.AbstractFactory;

/**
 * @author jcohy
 *
 */
// tag::code[]
public abstract class AbstractFactory {

	abstract Color getColor(String color);

	abstract Shape getShape(String shape);

}
// end::code[]