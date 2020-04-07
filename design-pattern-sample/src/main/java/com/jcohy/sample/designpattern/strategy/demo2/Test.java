package com.jcohy.sample.designpattern.strategy.demo2;

/**
 * Created by jcohy on 2019/3/15.
 * ClassName  : com.jcohy.study.strategy.demo2
 * Description  :
 */
public class Test {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        mallard.setFlyBehavior(new FlyWithWings());
        mallard.performFly();
    }
}
