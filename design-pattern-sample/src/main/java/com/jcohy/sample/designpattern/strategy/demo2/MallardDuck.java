package com.jcohy.sample.designpattern.strategy.demo2;

/**
 * Created by jcohy on 2019/3/15. ClassName : com.jcohy.study.strategy.demo2 Description :
 */
public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("I can display");
	}

}
