package com.jcohy.sample.designpattern.strategy.demo2;

/**
 * Created by jiac on 2019/3/15.
 * ClassName  : com.jcohy.study.strategy.demo2
 * Description  :
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I Can Fly");
    }
}