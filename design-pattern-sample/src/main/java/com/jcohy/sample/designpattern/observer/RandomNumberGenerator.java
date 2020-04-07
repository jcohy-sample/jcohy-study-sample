package com.jcohy.sample.designpattern.observer;

import java.util.Random;

// tag::code[]
/**
 * 产生随机数
 * @author jcohy
 */
public class RandomNumberGenerator extends NumberGenerator {
	Random rd = new Random();
	private int number = 0;
	@Override
	public int getNum() {
		return number;
	}
	@Override
	public void excuteNum() {
		for(int i=0;i<10;i++) {
			number = rd.nextInt(50);
			// TODO Auto-generated method stub
			notifyObservers();
		}
	}
}
// end::code[]