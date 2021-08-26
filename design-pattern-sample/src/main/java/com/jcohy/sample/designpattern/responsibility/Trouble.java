package com.jcohy.sample.designpattern.responsibility;

// tag::code[]
/**
 * 表示发生问题的类，内有问题编号
 *
 * @author jcohy
 */
public class Trouble {

	private int number;//

	public Trouble(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Trouble [number=" + number + "]";
	}

}
// end::code[]