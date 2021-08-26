package com.jcohy.sample.designpattern.observer;

// tag::code[]
/**
 * 实现Observer接口,以 "*" 来表示观察到的数值
 *
 * @author jcohy
 */
public class GraphObserver implements Observer {

	@Override
	public void update(NumberGenerator numberGenerator) {
		System.out.println("GraphObserver:");
		int count = numberGenerator.getNum();
		for (int i = 0; i < count; i++) {
			System.out.print("*");
		}
		System.out.println();
		try {
			Thread.sleep(100);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
// end::code[]