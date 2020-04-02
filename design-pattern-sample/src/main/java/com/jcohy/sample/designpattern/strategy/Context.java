package com.jcohy.sample.designpattern.strategy;

public class Context {
	Strategy sta;
	public Context(Strategy sta) {
		this.sta=sta;
	}
	public void deMethod(){
		sta.method();
	}
}
