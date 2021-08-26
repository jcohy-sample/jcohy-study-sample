package com.jcohy.sample.designpattern.responsibility;

// tag::code[]
/**
 * 解决问题具体类(解决奇数号码的问题)
 */
public class OddSupport extends Support {

	public OddSupport(String name) {
		super(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() % 2 == 1) {
			return true;
		}
		return false;
	}

}
// end::code[]