package com.jcohy.sample.designpattern.observer;

// tag::code[]
/**
 * 实现Observer接口,以 "数字" 来表示观察到的数值
 * @author jcohy
 */
public class DigitObserver implements Observer{

	@Override
	public void update(NumberGenerator numberGenerator) {
		System.out.println("DigitObserver:"+numberGenerator.getNum());	
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
// end::code[]