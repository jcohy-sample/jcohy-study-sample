package com.jcohy.sample.designpattern.proxy;


public class ProxyObject implements java.lang.Object {
	java.lang.Object obj;
    
	public ProxyObject(){
		System.out.println("这是代理的类:"+this.getClass());
		obj= (java.lang.Object) new RealObjectImpl();
	}
	@Override
	public void action() {
		System.out.println("代理开始");
		obj.action();
		System.out.println("代理结束");
	}
}
