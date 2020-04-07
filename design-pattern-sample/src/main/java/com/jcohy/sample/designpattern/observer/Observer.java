package com.jcohy.sample.designpattern.observer;

// tag::code[]
/**
 * 观察者接口
 * @author jcohy
 */
public interface Observer {
	void update(NumberGenerator numberGenerator);
}
// end::code[]