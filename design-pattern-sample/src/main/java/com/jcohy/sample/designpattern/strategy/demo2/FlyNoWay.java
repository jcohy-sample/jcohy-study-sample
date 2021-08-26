package com.jcohy.sample.designpattern.strategy.demo2;

/**
 * Created by jcohy on 2019/3/15. ClassName : com.jcohy.study.strategy.demo2 Description :
 */
public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I Can't Fly");
	}

}
