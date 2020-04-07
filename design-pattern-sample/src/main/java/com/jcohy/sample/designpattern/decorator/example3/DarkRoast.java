package com.jcohy.sample.designpattern.decorator.example3;

/**
 * Created by jcohy on 2019/3/15.
 * ClassName  : com.jcohy.study.decorator.example3
 * Description  :
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 1.20;
    }
}
