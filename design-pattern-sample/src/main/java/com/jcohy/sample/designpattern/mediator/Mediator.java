package com.jcohy.sample.designpattern.mediator;

// tag::code[]
/**
 * 表示"顾问"的接口
 *
 * @author jcohy
 *
 */
public interface Mediator {

	public abstract void createColleagues();

	public abstract void colleagueChanged(Colleague colleague);

}
// end::code[]