package com.jcohy.sample.designpattern.strategy;
// tag::code[]
public class Context {
	Strategy sta;
	public Context(Strategy sta) {
		this.sta=sta;
	}
	public void deMethod(){
		sta.method();
	}
}
// end::code[]